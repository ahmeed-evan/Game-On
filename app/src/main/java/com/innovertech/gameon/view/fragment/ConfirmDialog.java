package com.innovertech.gameon.view.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;


import com.innovertech.gameon.R;
import com.innovertech.gameon.model.Squad.SendAbleList;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

public class ConfirmDialog extends DialogFragment {

    private SendAbleList list;
    private String matchType;
    private int matchId;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_dialog, container, false);
        ButterKnife.bind(this, view);
        getData();
        setCancelable(false);
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return view;
    }

    private void getData() {
        list = ConfirmDialogArgs.fromBundle(getArguments()).getSelectedSquad();
        matchId = ConfirmDialogArgs.fromBundle(getArguments()).getMatchId();
        matchType = ConfirmDialogArgs.fromBundle(getArguments()).getMatchType();

        Log.d(TAG, "getSquadListData: " + list.getSquadList());
    }

    @OnClick(R.id.cancelButton)
    void cancelClicked() {
        NavHostFragment.findNavController(this)
                .popBackStack();
    }

    @OnClick(R.id.confirmButton)
    void confirmClicked() {
        NavHostFragment.findNavController(this)
                .navigate(ConfirmDialogDirections.actionConfirmDialogToCaptainSelectorFragment(list, matchType, matchId));
    }
}
