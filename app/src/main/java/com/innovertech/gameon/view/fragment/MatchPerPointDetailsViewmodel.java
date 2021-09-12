package com.innovertech.gameon.view.fragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderPoint;
import com.innovertech.gameon.repository.MatchPerPointDetailsRepository;
import com.innovertech.gameon.utils.DialogCallback;


public class MatchPerPointDetailsViewmodel extends AndroidViewModel {

    public LiveData<MatchPerLeaderPoint> matchPerLeaderPointLiveData;
    private MatchPerPointDetailsRepository matchPerPointDetailsRepository;

    public MatchPerPointDetailsViewmodel(@NonNull Application application) {
        super(application);
        matchPerPointDetailsRepository = MatchPerPointDetailsRepository.getMatchPerLeaderBoardRepoInstance();
    }

    public void getMatchPerLeaderData(String matchId, Integer participateId, DialogCallback dialogCallback){
        matchPerLeaderPointLiveData=matchPerPointDetailsRepository.getMatchPerPointDetails(matchId,participateId,dialogCallback);
    }
}
