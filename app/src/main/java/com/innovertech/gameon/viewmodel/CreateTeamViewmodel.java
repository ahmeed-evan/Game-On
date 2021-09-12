package com.innovertech.gameon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.innovertech.gameon.model.Squad.SquadRes;
import com.innovertech.gameon.repository.CreateTeamRepository;
import com.innovertech.gameon.utils.DialogCallback;

import org.jetbrains.annotations.NotNull;

public class CreateTeamViewmodel extends AndroidViewModel {

    private CreateTeamRepository createTeamRepository;
    public LiveData<SquadRes> squadRes;

    public CreateTeamViewmodel(@NonNull @NotNull Application application) {
        super(application);
        createTeamRepository = CreateTeamRepository.getInstance(application);
    }

    public void getSquad(int matchId, String type, DialogCallback dialogCallback) {
        squadRes = createTeamRepository.getSquad(matchId, type,dialogCallback);
    }
}
