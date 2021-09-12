package com.innovertech.gameon.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.innovertech.gameon.R;
import com.innovertech.gameon.model.CricketMatchHistory.CricketMatchHistoryData;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.view.activity.PlayerPointDetailsActivity;
import com.innovertech.gameon.view.adapter.CricketMatchHistoryAdapter;
import com.innovertech.gameon.view.interfaces.OnRecyclerItemClickListener;
import com.innovertech.gameon.viewmodel.CricketHistoryViewmodel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

public class HistoryFragment extends Fragment implements DialogCallback, OnRecyclerItemClickListener {

    @BindView(R.id.totalPointCountTextTV)
    TextView totalPointCountTextTV;
    @BindView(R.id.matchHistoryCricketRecyclerView)
    RecyclerView matchHistoryCricketRecyclerView;
    @BindView(R.id.backArrow)
    ImageView backArrow;

    private CricketHistoryViewmodel cricketHistoryViewmodel;
    private List<CricketMatchHistoryData> historyDataList;
    private CustomLoadingDialog customLoadingDialog;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hisory, container, false);
        ButterKnife.bind(this, view);
        setBackpress();
        loadContent();
        return view;
    }

    private void loadContent() {
        customLoadingDialog = new CustomLoadingDialog(getActivity());
        historyDataList = new ArrayList<>();
        cricketHistoryViewmodel = new ViewModelProvider(this).get(CricketHistoryViewmodel.class);
        matchHistoryCricketRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cricketHistoryViewmodel.getCricketHistory(this::onRequestCompleted);
        customLoadingDialog.startLoadingDialog();
        cricketHistoryObserve();

    }

    private void cricketHistoryObserve() {
        cricketHistoryViewmodel.cricketMatchHistoryRes.observe(getActivity(), matchHistory -> {
            Log.d(TAG, "loadMatchHistoryCricket: " + matchHistory.getData());
            if (matchHistory != null) {
                historyDataList = matchHistory.getData();
                totalPointCountTextTV.setText(matchHistory.getTotalPoints());
                CricketMatchHistoryAdapter cricketMatchHistoryAdapter = new CricketMatchHistoryAdapter(getActivity(), historyDataList, this::onOptionItemCLicked);
                cricketMatchHistoryAdapter.notifyDataSetChanged();
                matchHistoryCricketRecyclerView.setAdapter(cricketMatchHistoryAdapter);
            }
        });
    }

    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) customLoadingDialog.stopLoadingDialog();
    }

    @Override
    public void onOptionItemCLicked(int position) {
        CricketMatchHistoryData historyData = historyDataList.get(position);
        Intent intent = new Intent(getActivity(), PlayerPointDetailsActivity.class);
        intent.putExtra("matchData", (Parcelable) historyData);
        startActivity(intent);
    }

    @OnClick(R.id.backArrow)
    void backClicked() {
        NavHostFragment.findNavController(this)
                .popBackStack();
    }

    private void setBackpress() {
        if (getArguments() != null) backArrow.setVisibility(View.VISIBLE);
    }
}
