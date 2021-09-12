package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.innovertech.gameon.R;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class HostFragmentHome extends Fragment {

    @BindView(R.id.bot_navigation)
    BottomNavigationView bot_navigation;
    @BindView(R.id.side_nav_drawer)
    NavigationView side_nav_drawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;

    @BindView(R.id.homeLayout)
    ConstraintLayout homeHostLayout;

    private Fragment selectedFragment;
    private NavController navController;
    private boolean isDrawerOpen = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.host_fragment_home, container, false);
        ButterKnife.bind(this, view);
        loadContent();
        return view;
    }

    private void loadContent() {
        navController = NavHostFragment.findNavController(getParentFragment());
        NavigationUI.setupWithNavController(side_nav_drawer, navController);
        selectedFragment = new HomeFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.bottom_host, selectedFragment).commit();


        bot_navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.more:
                    drawer_layout.openDrawer(GravityCompat.END);
                    isDrawerOpen = true;
                    break;
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.history:
                    selectedFragment = new HistoryFragment();
                    break;
                case R.id.leaderboard:
                    selectedFragment = new LeaderBoardFragment();
                    break;
            }
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.bottom_host, selectedFragment).commit();
            return true;
        });

        side_nav_drawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.policy:
                        NavHostFragment.findNavController(getParentFragment())
                                .navigate(HostFragmentHomeDirections.actionHostFragmentHomeToPolicyFragment());
                        break;
                    case R.id.history:
                        NavHostFragment.findNavController(getParentFragment())
                                .navigate(HostFragmentHomeDirections.actionHostFragmentHomeToHistoryFragment("1"));
                        break;
                    case R.id.leaderBoard:
                        NavHostFragment.findNavController(getParentFragment())
                                .navigate(HostFragmentHomeDirections.actionHostFragmentHomeToLeaderBoardFragment("1"));
                        break;
                    case R.id.prize:
                        NavHostFragment.findNavController(getParentFragment())
                                .navigate(HostFragmentHomeDirections.actionHostFragmentHomeToPrizeFragment());
                        break;
                }

                return true;
            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + "drawer_layout");
        if (isDrawerOpen) {
            drawer_layout.closeDrawer(GravityCompat.END);
        }
    }
}
