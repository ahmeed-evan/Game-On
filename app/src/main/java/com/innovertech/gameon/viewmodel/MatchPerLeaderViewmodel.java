package com.innovertech.gameon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderBoard;
import com.innovertech.gameon.repository.MatchPerLeaderBoardRepository;
import com.innovertech.gameon.utils.DialogCallback;

import java.util.List;

public class MatchPerLeaderViewmodel extends AndroidViewModel {

    public LiveData<List<MatchPerLeaderBoard>> matchPerLeaderData;
    private MatchPerLeaderBoardRepository matchPerLeaderBoardRepository;

    public MatchPerLeaderViewmodel(@NonNull Application application) {
        super(application);
        matchPerLeaderBoardRepository = MatchPerLeaderBoardRepository.getInstance(application);
    }

    public void getMatchLeader(String matchId, DialogCallback dialogCallback) {
        matchPerLeaderData = matchPerLeaderBoardRepository.getMatchLeaders(matchId, dialogCallback);
    }
}
