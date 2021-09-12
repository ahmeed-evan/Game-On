package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.innovertech.gameon.R;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotifyFragment extends Fragment {
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notify, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.goHomeButton)
    void goBackButtonClicked() {
        NavHostFragment.findNavController(this)
                .navigate(R.id.toHomeHostFragment);
    }
}
