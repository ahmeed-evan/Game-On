package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.innovertech.gameon.R;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;

public class SplashFragment extends Fragment {
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);
        ButterKnife.bind(this, view);
//        setFullScreen();
        gotoNextScreen();
        return view;
    }

    private void gotoNextScreen() {
        new Handler().postDelayed(() -> NavHostFragment.findNavController(SplashFragment.this)
                .navigate(SplashFragmentDirections.actionSplashFragmentToSignInFragment()), 3000);
    }

    private void setFullScreen() {
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
