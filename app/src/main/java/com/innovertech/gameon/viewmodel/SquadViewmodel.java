package com.innovertech.gameon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import com.innovertech.gameon.model.Squad.SelectedSquad;
import com.innovertech.gameon.repository.SquadRepository;
import com.innovertech.gameon.utils.DialogCallback;

import org.jetbrains.annotations.NotNull;

public class SquadViewmodel extends AndroidViewModel {
    private SquadRepository squadRepository;

    public SquadViewmodel(@NonNull @NotNull Application application) {
        super(application);
        squadRepository = SquadRepository.getInstance(application);
    }

    public void submitSquad(SelectedSquad selectedSquad, String type, DialogCallback dialogCallback) {
        squadRepository.submitSquad(selectedSquad, type, dialogCallback);
    }
}
