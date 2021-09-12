package com.innovertech.gameon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.innovertech.gameon.model.PointHistoryDetails.PointHistoryDetailsCricket;
import com.innovertech.gameon.repository.PlayerPointDetailsRepository;
import com.innovertech.gameon.utils.DialogCallback;

import org.jetbrains.annotations.NotNull;

public class PlayerPointDetailsViewmodel extends AndroidViewModel {

    private PlayerPointDetailsRepository detailsRepository;
    public LiveData<PointHistoryDetailsCricket> pointHistoryDetailsCricketLiveData;

    public PlayerPointDetailsViewmodel(@NonNull @NotNull Application application) {
        super(application);
        this.detailsRepository = PlayerPointDetailsRepository.getInstance(application);
    }

    public void getPlayerPointDetails(Integer matchId, DialogCallback dialogCallback) {
        pointHistoryDetailsCricketLiveData = detailsRepository.getPlayerPointDetails(matchId,dialogCallback);
    }

}
