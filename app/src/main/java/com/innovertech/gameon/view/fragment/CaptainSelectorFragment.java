package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.innovertech.gameon.R;
import com.innovertech.gameon.model.Squad.SelectedSquad;
import com.innovertech.gameon.model.Squad.SendAbleList;
import com.innovertech.gameon.model.Squad.Squad;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.view.adapter.CaptainSelectorAdapter;
import com.innovertech.gameon.view.interfaces.OnRecyclerItemClickListenerWithView;
import com.innovertech.gameon.viewmodel.SquadViewmodel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CaptainSelectorFragment extends Fragment implements OnRecyclerItemClickListenerWithView, DialogCallback {

    @BindView(R.id.captainSelectorRecyclerView)
    RecyclerView captainSelectorRecyclerView;
    @BindView(R.id.selectCapLayout)
    ConstraintLayout selectCapLayout;

    private List<Squad> squadList;
    private String captainId = "";
    private SquadViewmodel squadViewmodel;
    private SendAbleList list;
    private String matchType;
    private int matchId;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_captin_selector, container, false);
        ButterKnife.bind(this, view);
        getSquadData();
        initRecycler();
        initViewmodel();
        return view;
    }

    private void initViewmodel() {
        squadViewmodel = new ViewModelProvider(this).get(SquadViewmodel.class);
    }

    private void getSquadData() {
        matchType = CaptainSelectorFragmentArgs.fromBundle(getArguments()).getMatchType();
        matchId = CaptainSelectorFragmentArgs.fromBundle(getArguments()).getMatchId();
        list = CaptainSelectorFragmentArgs.fromBundle(getArguments()).getSelectedList();
        squadList = new ArrayList<>();
        squadList = list.getSquadList();
    }

    private void initRecycler() {
        captainSelectorRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        captainSelectorRecyclerView.setAdapter(new CaptainSelectorAdapter(squadList, getActivity(), this::onItemClicked));
    }

    @Override
    public void onItemClicked(int position, View view) {
        if (!squadList.get(position).getPlayerId().equals(captainId)) {
            captainId = squadList.get(position).getPlayerId();
        } else {
            captainId = "";
        }
    }

    @OnClick(R.id.nextButton)
    void nextButtonClicked() {
        if (!captainId.isEmpty()) {
            squadViewmodel.submitSquad(new SelectedSquad(
                    String.valueOf(matchId),
                    squadList.get(0).getPlayerId(),
                    squadList.get(1).getPlayerId(),
                    squadList.get(2).getPlayerId(),
                    squadList.get(3).getPlayerId(),
                    squadList.get(4).getPlayerId(),
                    squadList.get(5).getPlayerId(),
                    squadList.get(6).getPlayerId(),
                    squadList.get(7).getPlayerId(),
                    squadList.get(8).getPlayerId(),
                    squadList.get(9).getPlayerId(),
                    squadList.get(10).getPlayerId(),
                    captainId
            ), matchType, this);
        } else {
            Snackbar.make(selectCapLayout, "Please select a captain to continue. ", BaseTransientBottomBar.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.backArrow)
    void backArrowClick() {
        getActivity().onBackPressed();
    }

    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_captainSelectorFragment_to_notifyFragment);
        } else {
            Snackbar.make(selectCapLayout, "Something went wrong. Please try again ", BaseTransientBottomBar.LENGTH_SHORT).show();
        }
    }
}
