package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.innovertech.gameon.R;
import com.innovertech.gameon.model.BannerSlider;
import com.innovertech.gameon.model.Match.MatchData;
import com.innovertech.gameon.utils.CustomLoadingDialog;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;
import com.innovertech.gameon.view.adapter.OnGoingMatchAdapter;
import com.innovertech.gameon.view.adapter.SliderAdapter;
import com.innovertech.gameon.view.interfaces.OnRecyclerItemClickListener;
import com.innovertech.gameon.viewmodel.HomeFragmentViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment implements
        DialogCallback, OnRecyclerItemClickListener {

    @BindView(R.id.imageSliderVP)
    ViewPager imageSlider;
    @BindView(R.id.onGoingMatchRecyclerView)
    RecyclerView onGoingMatchRecyclerView;
    @BindView(R.id.onGoingMatchTextTV)
    TextView onGoingMatchTextTV;
    @BindView(R.id.matchNotFoundTV)
    CardView matchNotFoundTV;

    private int currentPage = 0;
    private Timer timer;
    private NavController navController;

    private CustomLoadingDialog customLoadingDialog;
    private List<MatchData> matchList = new ArrayList<>();

    private final List<BannerSlider> sliderList = new ArrayList<>(Arrays.asList(
            new BannerSlider(R.drawable.slider_one, ""),
            new BannerSlider(R.drawable.slider_two, ""),
            new BannerSlider(R.drawable.slider_four, ""),
            new BannerSlider(R.drawable.slider_five, ""),
            new BannerSlider(R.drawable.slider_six, "")
    ));
    private HomeFragmentViewModel homeFragmentViewModel;
    private SessionManager sessionManager;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initSlider();
        initSession();
        initNav();
        initDialog();
        initViewmodel();
        initOnGoingRecyclerView();
        return view;
    }

    private void initOnGoingRecyclerView() {
        onGoingMatchRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getMatchData();
    }

    private void getMatchData() {

        matchList = new ArrayList<>();
        homeFragmentViewModel.getMatches(this::onRequestCompleted);
        customLoadingDialog.startLoadingDialog();
        onGoingMatchObserver();
    }

    private void onGoingMatchObserver() {
        homeFragmentViewModel.matchRes.observe(getActivity(), match -> {
            if (match != null) {
                matchList = match.getData();
                if (!matchList.isEmpty()) {
                    OnGoingMatchAdapter onGoingMatchAdapter = new OnGoingMatchAdapter(matchList, getActivity(), this::onOptionItemCLicked);
                    onGoingMatchAdapter.notifyDataSetChanged();
                    onGoingMatchRecyclerView.setAdapter(onGoingMatchAdapter);
                } else {
                    matchNotFoundTV.setVisibility(View.VISIBLE);
                }
            } else {
                Toast.makeText(getActivity(), "Something went wrong! Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initSession() {
        sessionManager = SessionManager.getInstance(getActivity());
    }

    private void initSlider() {
        imageSlider.setAdapter(new SliderAdapter(getActivity(), sliderList));
        sliderAutoChange();
    }


    private void initViewmodel() {
        homeFragmentViewModel = new ViewModelProvider(requireActivity()).get(HomeFragmentViewModel.class);
    }

    private void initDialog() {
        customLoadingDialog = new CustomLoadingDialog(getActivity());
    }

    private void initNav() {
        navController = NavHostFragment.findNavController(getParentFragment());
    }


    private void sliderAutoChange() {
        final Handler handler = new Handler(Looper.myLooper());
        final Runnable Update = () -> {
            if (currentPage == sliderList.size()) {
                currentPage = 0;
            }
            imageSlider.setCurrentItem(currentPage++, true);
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 300, 3000);

    }

    @Override
    public void onRequestCompleted(boolean isCompleted) {
        if (isCompleted) customLoadingDialog.stopLoadingDialog();
    }

    @Override
    public void onOptionItemCLicked(int position) {
        MatchData matchData = matchList.get(position);
        if (!matchData.getPlayed().equals("1")) {
            navController.navigate(HostFragmentHomeDirections.actionHostFragmentHomeToCreateTeamFragment(matchData));
        }
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
