package com.innovertech.gameon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.innovertech.gameon.model.Leaderboard;
import com.innovertech.gameon.repository.CurrentWeekLeaderboardRepository;
import com.innovertech.gameon.utils.DialogCallback;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CurrentWeekLeaderboardViewmodel extends AndroidViewModel {

    private CurrentWeekLeaderboardRepository currentWeekLeaderboardRepository;
    public LiveData<List<Leaderboard>> currentLeaderboard;

    public CurrentWeekLeaderboardViewmodel(@NonNull @NotNull Application application) {
        super(application);
        this.currentWeekLeaderboardRepository = CurrentWeekLeaderboardRepository.getInstance(application);
    }

    public void getThisWeekLeaderboard(DialogCallback dialogCallback) {
        currentLeaderboard = currentWeekLeaderboardRepository.getThisWeekLeaderboard(dialogCallback);
    }
}
