package com.innovertech.gameon.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.innovertech.gameon.R;
import com.innovertech.gameon.model.auth.SignUpReq;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;
import com.innovertech.gameon.utils.Utils;
import com.innovertech.gameon.viewmodel.AuthViewmodel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpFragment extends Fragment implements DialogCallback {

    @BindView(R.id.phnNumberET)
    EditText phnNumberET;
    @BindView(R.id.nameET)
    EditText nameET;
    @BindView(R.id.passwordET)
    EditText passwordET;
    @BindView(R.id.retypePasswordET)
    EditText retypePasswordET;
    @BindView(R.id.signUpLayout)
    ConstraintLayout signUpLayout;

    private CustomLoadingDialog customLoadingDialog;
    private AuthViewmodel authViewmodel;
    private String phnNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        initViewmodel();
        initDialog();
        return view;
    }

    private void initDialog() {
        customLoadingDialog = new CustomLoadingDialog(requireActivity());
    }

    private void initViewmodel() {
        authViewmodel = new ViewModelProvider(requireActivity()).get(AuthViewmodel.class);
    }

    @OnClick(R.id.text_sign_in)
    void text_sign_inClicked() {
//        NavHostFragment.findNavController(this)
//                .popBackStack();
        getActivity().onBackPressed();
    }

    @OnClick(R.id.signUpButton)
    void signUpButtonClicked() {
        hideKeyPad();
        phnNumber = phnNumberET.getText().toString();
        String password = passwordET.getText().toString();
        String name = nameET.getText().toString();
        String confirmPassword = retypePasswordET.getText().toString();

        if (inputIsValid(phnNumber, name, password, confirmPassword)) {
            authViewmodel.signUpUser(new SignUpReq(name, phnNumber, password), this::onRequestCompleted);
            customLoadingDialog.startLoadingDialog();
            observeData();
        } else {
            Utils.showSnackBar(signUpLayout, "Phone Number should start with 01** and total 11 digits or check your password.");
        }
    }

    private void observeData() {
        authViewmodel.signUpResLiveData.observe(getViewLifecycleOwner(), authRes -> {
            if (authRes != null) {
                if (authRes.status) {
                    SessionManager.getInstance(getActivity())
                            .saveSubId(phnNumber);
                    NavHostFragment.findNavController(this)
                            .navigate(SignUpFragmentDirections.toHomeHostFragment());
                } else {
                    Utils.showSnackBar(signUpLayout, authRes.msg);
                }
            }
        });
    }

    private boolean inputIsValid(String phnNumber, String name, String password, String confirmPassword) {
        if (!(phnNumber.isEmpty() &&
                name.isEmpty()
                && password.isEmpty()
                && confirmPassword.isEmpty())) {
            if (password.equals(confirmPassword) && phnNumber.startsWith("01") && phnNumber.length() == 11) {
                return true;
            }
        }

        return false;
    }

    private void hideKeyPad() {
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) customLoadingDialog.stopLoadingDialog();
    }
}
