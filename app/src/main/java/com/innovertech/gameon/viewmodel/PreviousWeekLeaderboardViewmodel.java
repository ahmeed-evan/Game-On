package com.innovertech.gameon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.innovertech.gameon.model.Leaderboard;
import com.innovertech.gameon.repository.PreviousWeekLeaderboardRepository;
import com.innovertech.gameon.utils.DialogCallback;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PreviousWeekLeaderboardViewmodel extends AndroidViewModel {

    private PreviousWeekLeaderboardRepository previousWeekLeaderboardRepository;
    public LiveData<List<Leaderboard>> previousLeaderboard;

    public PreviousWeekLeaderboardViewmodel(@NonNull @NotNull Application application) {
        super(application);
        this.previousWeekLeaderboardRepository = PreviousWeekLeaderboardRepository.getInstance(application);
    }

    public void getLastWeekLeaderboard(DialogCallback dialogCallback) {
        previousLeaderboard = previousWeekLeaderboardRepository.getPreWeekData(dialogCallback);
    }
}
