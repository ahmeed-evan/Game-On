package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.innovertech.gameon.R;
import com.innovertech.gameon.model.CricketMatchHistory.CricketMatchHistoryData;
import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderBoard;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.view.adapter.MatchPerLeaderAdapter;
import com.innovertech.gameon.view.interfaces.OnRecyclerItemClickListener;
import com.innovertech.gameon.viewmodel.MatchPerLeaderViewmodel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

public class MatchPerLeaderBoardFragment extends Fragment implements DialogCallback, OnRecyclerItemClickListener {

    @BindView(R.id.matchPerLeaderboardRecyclerView)
    RecyclerView matchPerLeaderboardRecyclerView;
    @BindView(R.id.matchNameTV)
    TextView matchNameTV;
    @BindView(R.id.teamOneIV)
    ImageView teamOneIV;
    @BindView(R.id.teamTwoIV)
    ImageView teamTwoIV;

    private MatchPerLeaderViewmodel matchPerLeaderViewmodel;
    private CricketMatchHistoryData cricketMatchHistoryData;
    private CustomLoadingDialog customLoadingDialog;
    private List<MatchPerLeaderBoard> matchPerLeaderBoardList;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_per_leaderboard, container, false);
        ButterKnife.bind(this, view);
        getArgs();
        initDialog();
        initViewmodel();
        getLeaders();
        setMatchDetails();
        setUpRecycler();
        return view;
    }

    private void setMatchDetails() {
        if (cricketMatchHistoryData != null) {
            matchNameTV.setText(cricketMatchHistoryData.getTeam1() + " VS " + cricketMatchHistoryData.getTeam2());
            Glide.with(getActivity()).load(cricketMatchHistoryData.getBoardFlag1()).into(teamOneIV);
            Glide.with(getActivity()).load(cricketMatchHistoryData.getBoardFlag2()).into(teamTwoIV);
        }
    }

    private void setUpRecycler() {
        matchPerLeaderboardRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        customLoadingDialog.startLoadingDialog();
        observeData();
    }

    private void observeData() {
        matchPerLeaderViewmodel.matchPerLeaderData.observe(requireActivity(), matchPerLeaderBoard -> {
            if (matchPerLeaderBoard != null) {
                matchPerLeaderBoardList = matchPerLeaderBoard;
                Log.d(TAG, "observeData: " + matchPerLeaderBoardList);
                MatchPerLeaderAdapter matchPerLeaderAdapter = new MatchPerLeaderAdapter(getActivity(), matchPerLeaderBoardList, this::onOptionItemCLicked);
                matchPerLeaderAdapter.notifyDataSetChanged();
                matchPerLeaderboardRecyclerView.setAdapter(matchPerLeaderAdapter);
            }
        });
    }

    private void initDialog() {
        customLoadingDialog = new CustomLoadingDialog(getActivity());
    }

    private void getLeaders() {
        if (cricketMatchHistoryData != null) {
            matchPerLeaderViewmodel.getMatchLeader(String.valueOf(cricketMatchHistoryData.getApiUniqueId()), this::onRequestCompleted);
        }
    }

    private void initViewmodel() {
        matchPerLeaderViewmodel = new ViewModelProvider(this).get(MatchPerLeaderViewmodel.class);
    }

    private void getArgs() {
        cricketMatchHistoryData = MatchPerLeaderBoardFragmentArgs.fromBundle(getArguments()).getMatchId();
    }


    @OnClick(R.id.backArrow)
    void backClicked() {
        getActivity().onBackPressed();
    }


    @Override
    public void onOptionItemCLicked(int position) {
        NavController navController = NavHostFragment.findNavController(this);
        if (cricketMatchHistoryData != null) {
            navController.navigate(com.innovertech.gameon.view.fragment.MatchPerLeaderBoardFragmentDirections
                    .actionMatchPerLeaderboardFragmentToMatchPerPointDetails(String.valueOf(cricketMatchHistoryData.getApiUniqueId()), matchPerLeaderBoardList.get(position)));
        }
    }

    @Override
    public void onRequestCompleted(boolean isCompleted) {
        customLoadingDialog.stopLoadingDialog();
    }
}
