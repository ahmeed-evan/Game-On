package com.innovertech.gameon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.innovertech.gameon.model.Match.MatchRes;
import com.innovertech.gameon.repository.HomeFragmentRepository;
import com.innovertech.gameon.utils.DialogCallback;

import org.jetbrains.annotations.NotNull;

public class HomeFragmentViewModel extends AndroidViewModel {

    private HomeFragmentRepository homeFragmentRepository;
    public LiveData<MatchRes> matchRes;

    public HomeFragmentViewModel(@NonNull @NotNull Application application) {
        super(application);
        this.homeFragmentRepository = new HomeFragmentRepository(application);
    }

    public void getMatches(DialogCallback dialogCallback) {
        matchRes = homeFragmentRepository.getMatches(dialogCallback);
    }
}
