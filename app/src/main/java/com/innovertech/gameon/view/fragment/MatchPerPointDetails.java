package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.innovertech.gameon.R;
import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderBoard;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.view.adapter.PlayerPointDetailsAdapterCricket;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatchPerPointDetails extends Fragment implements DialogCallback {

    @BindView(R.id.pointDetailsRecyclerView)
    RecyclerView pointDetailsRecyclerView;
    @BindView(R.id.participantNameTV)
    TextView participantNameTV;
    @BindView(R.id.totalPointNumberTv)
    TextView totalPointNumberTv;

    private MatchPerLeaderBoard matchPerLeaderBoard;
    private String matchId;
    private CustomLoadingDialog customLoadingDialog;
    private MatchPerPointDetailsViewmodel matchPerPointDetailsViewmodel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_per_point_details, container, false);
        ButterKnife.bind(this, view);
        getArgs();
        initDialog();
        initViewmodel();
        retrieveLeadersTeam();
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        pointDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
    }

    private void retrieveLeadersTeam() {
        matchPerPointDetailsViewmodel.getMatchPerLeaderData(matchId, matchPerLeaderBoard.getId(), this);
        customLoadingDialog.startLoadingDialog();
        observeData();
    }

    private void observeData() {
        matchPerPointDetailsViewmodel.matchPerLeaderPointLiveData.observe(getActivity(), matchPerLeaderPoint ->
        {
            if (matchPerLeaderPoint != null) {

                PlayerPointDetailsAdapterCricket playerPointDetailsAdapterCricket
                        = new PlayerPointDetailsAdapterCricket(requireActivity(), matchPerLeaderPoint.getPlayerPoints());
                playerPointDetailsAdapterCricket.notifyDataSetChanged();

                pointDetailsRecyclerView.setAdapter(playerPointDetailsAdapterCricket);

                totalPointNumberTv.setText(matchPerLeaderPoint.getPoint());
            }

        });
    }

    private void initDialog() {
        customLoadingDialog = new CustomLoadingDialog(requireActivity());
    }

    private void initViewmodel() {
        matchPerPointDetailsViewmodel = new ViewModelProvider(this).get(MatchPerPointDetailsViewmodel.class);
    }

    private void getArgs() {
        matchPerLeaderBoard = MatchPerPointDetailsArgs.fromBundle(getArguments()).getMatchPerLeaderInfo();
        matchId = MatchPerPointDetailsArgs.fromBundle(getArguments()).getMatchId();
        setParticipateName(matchPerLeaderBoard.getName());
    }

    private void setParticipateName(String name) {
        participantNameTV.setText("Participant Name: " + name);
    }

    @OnClick(R.id.backArrow)
    void backClicked() {
        getActivity().onBackPressed();
    }


    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) customLoadingDialog.stopLoadingDialog();
    }
}
