package com.innovertech.gameon.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.innovertech.gameon.R;
import com.innovertech.gameon.model.CricketMatchHistory.CricketMatchHistoryData;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.view.adapter.PlayerPointDetailsAdapterCricket;
import com.innovertech.gameon.viewmodel.PlayerPointDetailsViewmodel;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerPointDetailsFragment extends Fragment implements DialogCallback {

    @BindView(R.id.pointDetailsRecyclerView)
    RecyclerView pointDetailsRecyclerView;
    @BindView(R.id.totalPointNumberTv)
    TextView totalPointNumberTv;
    @BindView(R.id.seeLeaderboard)
    TextView seeLeaderboard;

    private PlayerPointDetailsViewmodel playerPointDetailsViewmodel;
    private CricketMatchHistoryData cricketMatchHistoryData;

    private CustomLoadingDialog customLoadingDialog;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_point_details, container, false);
        ButterKnife.bind(this, view);
        initDialog();
        getArgs();
        initViewmodel();
        loadContent();
        return view;
    }

    private void getArgs() {

        Intent intent = getActivity().getIntent();
        cricketMatchHistoryData = intent.getParcelableExtra("matchData");
    }

    private void initViewmodel() {
        playerPointDetailsViewmodel = new ViewModelProvider(this).get(PlayerPointDetailsViewmodel.class);
    }

    private void initDialog() {
        customLoadingDialog = new CustomLoadingDialog(getActivity());
    }

    private void loadContent() {
        pointDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        if (cricketMatchHistoryData != null) {
            playerPointDetailsViewmodel.getPlayerPointDetails(cricketMatchHistoryData.getApiUniqueId(), this::onRequestCompleted);
            customLoadingDialog.startLoadingDialog();
            playerPointDetailsViewmodel.pointHistoryDetailsCricketLiveData.observe(requireActivity(), historyDetails -> {
                if (historyDetails.getPlayerPoints() != null) {
                    PlayerPointDetailsAdapterCricket pointDetailsAdapter = new PlayerPointDetailsAdapterCricket(requireActivity(), historyDetails.getPlayerPoints());
                    pointDetailsAdapter.notifyDataSetChanged();
                    pointDetailsRecyclerView.setAdapter(pointDetailsAdapter);
                    totalPointNumberTv.setText(historyDetails.getPoint());
//                    if (historyDetails.getShowLeaderboard() != null) {
//                        seeLeaderboard.setVisibility(View.VISIBLE);
//                    }
                }
            });
        }
    }

    @OnClick(R.id.backArrow)
    void onBackArrowClicked() {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.seeLeaderboard)
    void seeLeaderboardClicked() {
        if (cricketMatchHistoryData != null) {
            NavHostFragment.findNavController(this)
                    .navigate(com.innovertech.gameon.view.fragment.PlayerPointDetailsFragmentDirections
                            .actionPlayerPointDetailsFragmentToMatchPerLeaderboardFragment(cricketMatchHistoryData));
        }
    }


    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) customLoadingDialog.stopLoadingDialog();
    }
}
