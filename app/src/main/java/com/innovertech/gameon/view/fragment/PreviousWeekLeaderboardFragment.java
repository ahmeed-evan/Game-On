package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.innovertech.gameon.R;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.view.adapter.LeaderBoardAdapter;
import com.innovertech.gameon.viewmodel.PreviousWeekLeaderboardViewmodel;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class PreviousWeekLeaderboardFragment extends Fragment implements DialogCallback {

    @BindView(R.id.leaderboardPreviousWeekRecyclerView)
    RecyclerView leaderboardPreviousWeekRecyclerView;

    private PreviousWeekLeaderboardViewmodel previousWeekLeaderboardViewmodel;
    private CustomLoadingDialog customLoadingDialog;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leaderboard_previous_week, container, false);
        ButterKnife.bind(this, view);
        loadContent();
        return view;
    }

    private void loadContent() {
        customLoadingDialog = new CustomLoadingDialog(getActivity());
        previousWeekLeaderboardViewmodel = new ViewModelProvider(this).get(PreviousWeekLeaderboardViewmodel.class);
        leaderboardPreviousWeekRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        previousWeekLeaderboardViewmodel.getLastWeekLeaderboard(this::onRequestCompleted);
        customLoadingDialog.startLoadingDialog();
        observePreviousLeaderboard();
    }

    private void observePreviousLeaderboard() {
        previousWeekLeaderboardViewmodel.previousLeaderboard.observe(getActivity(), leaderboards -> {
            Log.d(TAG, "prevWeekLeaderboard: " + leaderboards);
            if (leaderboards != null) {
                LeaderBoardAdapter leaderBoardAdapter = new LeaderBoardAdapter(leaderboards, getActivity());
                leaderBoardAdapter.notifyDataSetChanged();
                leaderboardPreviousWeekRecyclerView.setAdapter(leaderBoardAdapter);
            }
        });
    }

    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) customLoadingDialog.stopLoadingDialog();
    }
}
