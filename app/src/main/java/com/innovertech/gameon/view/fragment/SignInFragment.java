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
import com.innovertech.gameon.model.auth.SignInReq;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;
import com.innovertech.gameon.utils.Utils;
import com.innovertech.gameon.viewmodel.AuthViewmodel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInFragment extends Fragment implements DialogCallback {

    @BindView(R.id.phnNumberET)
    EditText phnNumberET;
    @BindView(R.id.passwordET)
    EditText passwordET;
    @BindView(R.id.signInLayout)
    ConstraintLayout signInLayout;

    private CustomLoadingDialog customLoadingDialog;
    private AuthViewmodel authViewmodel;
    private String phnNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);
        initViewmodel();
        initDialog();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!SessionManager.getInstance(getActivity())
                .getSubId().isEmpty()) {

            NavHostFragment.findNavController(this)
                    .navigate(SignInFragmentDirections.toHomeHostFragment());
        }
    }

    private void initDialog() {
        customLoadingDialog = new CustomLoadingDialog(requireActivity());
    }

    private void initViewmodel() {
        authViewmodel = new ViewModelProvider(requireActivity()).get(AuthViewmodel.class);
    }

    @OnClick(R.id.signInButton)
    void signInButtonClicked() {

        hideKeyPad();
        phnNumber = phnNumberET.getText().toString();
        String password = passwordET.getText().toString();

        if (inputValid(phnNumber, password)) {
            authViewmodel.signInUser(new SignInReq(phnNumber, password), this::onRequestCompleted);
            customLoadingDialog.startLoadingDialog();
            observeData();
        } else {
            Utils.showSnackBar(signInLayout, "Please provide a valid input. Phone Number should start with 01** and total 11 digits");
        }
    }

    private void observeData() {
        authViewmodel.signInResLiveData.observe(getViewLifecycleOwner(), authRes -> {
            if (authRes != null) {
                if (authRes.status) {
                    SessionManager.getInstance(getActivity())
                            .saveSubId(phnNumber);
                    NavHostFragment.findNavController(this)
                            .navigate(SignInFragmentDirections.toHomeHostFragment());
                } else {
                    Utils.showSnackBar(signInLayout, authRes.msg);
                }
            }
        });
    }

    private boolean inputValid(String phnNumber, String password) {

        if (!(phnNumber.isEmpty() && password.isEmpty())) {
            if (phnNumber.startsWith("01") && phnNumber.length() == 11) return true;
        }
        return false;
    }

    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) customLoadingDialog.stopLoadingDialog();
    }

    private void hideKeyPad() {
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    @OnClick(R.id.text_sign_up)
    void signUpTextClicked() {
        NavHostFragment.findNavController(this)
                .navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment());
    }
}
