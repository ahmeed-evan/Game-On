package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.innovertech.gameon.R;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeaderBoardFragment extends Fragment {


    @BindView(R.id.leaderBoardNavBar)
    BottomNavigationView leaderBoardNavBar;
    @BindView(R.id.backArrow)
    ImageView backArrow;

    private NavController navController;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.host_fragment_leaderboard, container, false);
        ButterKnife.bind(this, view);
        setBackpress();
        loadContent();
        return view;
    }

    private void setBackpress() {
        if (getArguments() != null) backArrow.setVisibility(View.VISIBLE);
    }


    private void loadContent() {
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.nav_host_leaderboard);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(leaderBoardNavBar, navController);
    }

    @OnClick(R.id.backArrow)
    void backClicked() {
        NavHostFragment.findNavController(this)
                .popBackStack();
    }
}
