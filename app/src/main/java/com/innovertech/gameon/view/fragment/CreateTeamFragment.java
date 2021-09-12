package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.innovertech.gameon.R;
import com.innovertech.gameon.model.Match.MatchData;
import com.innovertech.gameon.model.Squad.SendAbleList;
import com.innovertech.gameon.model.Squad.Squad;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.view.adapter.TeamOneAdapter;
import com.innovertech.gameon.view.adapter.TeamTwoAdapter;
import com.innovertech.gameon.viewmodel.CreateTeamViewmodel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

public class CreateTeamFragment extends Fragment implements
        TeamOneAdapter.OnTeamOneItemClickListener, TeamTwoAdapter.OnTeamTwoItemClickListener, DialogCallback {


    @BindView(R.id.teamOnePlayersRecyclerView)
    RecyclerView teamOnePlayersRecyclerView;
    @BindView(R.id.teamTwoPlayersRecyclerView)
    RecyclerView teamTwoPlayersRecyclerView;
    @BindView(R.id.teamOneTotalPlayerTV)
    TextView teamOneTotalPlayerTV;
    @BindView(R.id.teamOne_text)
    TextView teamOne_text;
    @BindView(R.id.teamTwo_text)
    TextView teamTwo_text;
    @BindView(R.id.teamTwoTotalPlayerTV)
    TextView teamTwoTotalPlayerTV;
    @BindView(R.id.playerCounterTV)
    TextView playerCounterTV;
    @BindView(R.id.teamOneIV)
    ImageView teamOneIV;
    @BindView(R.id.teamTwoIV)
    ImageView teamTwoIV;
    @BindView(R.id.teamCardView)
    CardView teamCardView;

    private List<Squad> squadList = new ArrayList<>();
    private List<Squad> list = new ArrayList<>();
    private CreateTeamViewmodel createTeamViewmodel;
    private List<Squad> selectedSquadList = new ArrayList<>();
    private CustomLoadingDialog customLoadingDialog;
    private MatchData selectedMatch;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_team, container, false);
        ButterKnife.bind(this, view);
        getAgrs();
        initDialog();
        loadContent();
        return view;
    }

    private void getAgrs() {
        selectedMatch = CreateTeamFragmentArgs.fromBundle(getArguments()).getMatchData();
    }

    private void initDialog() {
        customLoadingDialog = new CustomLoadingDialog(getActivity());
    }

    private void loadContent() {
        createTeamViewmodel = new ViewModelProvider(this).get(CreateTeamViewmodel.class);
        Log.d(TAG, "onCreateView: match" + selectedMatch.toString());
        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
        playerCounterTV.setText(selectedSquadList.size() + "/11");
        teamOnePlayersRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        teamTwoPlayersRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        if (selectedMatch != null) {
            createTeamViewmodel.getSquad(selectedMatch.getMatchId(), selectedMatch.getType(), this);
            customLoadingDialog.startLoadingDialog();
            createTeamViewmodel.squadRes.observe(getActivity(), squadRes -> {

                if (squadRes != null) {
                    squadList = squadRes.getTeam1().getSquad();
                    list = squadRes.getTeam2().getSquad();
                    if (getActivity() != null) {
                        Glide.with(this).load(squadRes.getTeam1().getFlag()).override(120, 120).into(teamOneIV);
                        Glide.with(this).load(squadRes.getTeam2().getFlag()).override(120, 120).into(teamTwoIV);
                        teamOne_text.setText(squadRes.getTeam1().getName());
                        teamTwo_text.setText(squadRes.getTeam2().getName());
                        teamOneTotalPlayerTV.setText("Total Player " + String.valueOf(squadList.size()));
                        teamTwoTotalPlayerTV.setText("Total Player " + String.valueOf(list.size()));
                        TeamOneAdapter teamOneAdapter = new TeamOneAdapter(
                                requireActivity(), squadList, this::onTeamOneItemClicked);
                        TeamTwoAdapter teamTwoAdapter = new TeamTwoAdapter(requireActivity(), list, this::onTeamTwoItemClicked);
                        teamOnePlayersRecyclerView.setAdapter(teamOneAdapter);
                        teamTwoPlayersRecyclerView.setAdapter(teamTwoAdapter);
                    }
                }
            });

        }
    }

    @Override
    public void onTeamOneItemClicked(View view, int position) {
        Squad selectedPlayer = squadList.get(position);
        if (!selectedSquadList.contains(selectedPlayer)) {
            selectedSquadList.add(selectedPlayer);
            playerCounterTV.setText(selectedSquadList.size() + "/11");
            view.setBackground(getResources().getDrawable(R.drawable.bg_bottom_nav));
            if (selectedSquadList.size() == 11) NavHostFragment.findNavController(this)
                    .navigate(CreateTeamFragmentDirections.actionCreateTeamFragmentToConfirmDialog(new SendAbleList(selectedSquadList), selectedMatch.getType(), selectedMatch.getMatchId()));
            Log.d(TAG, "onTeamOneItemClicked: add player " + position + " " + selectedSquadList);
        } else {
            selectedSquadList.remove(selectedPlayer);
            playerCounterTV.setText(selectedSquadList.size() + "/11");
            view.setBackground(getResources().getDrawable(R.drawable.bg_team_one));
            Log.d(TAG, "onTeamOneItemClicked: remove player " + position + " " + selectedSquadList);
        }
    }


    @Override
    public void onTeamTwoItemClicked(View view, int position) {
        Squad selectedPlayer = list.get(position);

        if (!selectedSquadList.contains(selectedPlayer)) {
            selectedSquadList.add(selectedPlayer);
            playerCounterTV.setText(selectedSquadList.size() + "/11");
            view.setBackground(getResources().getDrawable(R.drawable.bg_bottom_nav));
            if (selectedSquadList.size() == 11) NavHostFragment.findNavController(this)
                    .navigate(CreateTeamFragmentDirections.actionCreateTeamFragmentToConfirmDialog(new SendAbleList(selectedSquadList), selectedMatch.getType(), selectedMatch.getMatchId()));
            Log.d(TAG, "onTeamOneItemClicked: add player " + position + " " + selectedSquadList);

        } else {
            selectedSquadList.remove(selectedPlayer);
            playerCounterTV.setText(selectedSquadList.size() + "/11");
            view.setBackground(getResources().getDrawable(R.drawable.bg_team_two));
            Log.d(TAG, "onTeamOneItemClicked: remove player " + position + " " + selectedSquadList);

        }
    }


    @OnClick(R.id.backArrow)
    void backClicked() {
        NavHostFragment.findNavController(this)
                .navigate(R.id.toHomeHostFragment);
    }

    OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
        @Override
        public void handleOnBackPressed() {

        }
    };

    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) customLoadingDialog.stopLoadingDialog();
    }
}
