package com.innovertech.gameon.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.innovertech.gameon.model.CricketMatchHistory.CricketMatchHistoryRes;
import com.innovertech.gameon.repository.CricketHistoryRepository;
import com.innovertech.gameon.utils.DialogCallback;

import org.jetbrains.annotations.NotNull;

import static android.content.ContentValues.TAG;

public class CricketHistoryViewmodel extends AndroidViewModel {
    private CricketHistoryRepository cricketHistoryRepository;
    public LiveData<CricketMatchHistoryRes> cricketMatchHistoryRes;

    public CricketHistoryViewmodel(@NonNull @NotNull Application application) {
        super(application);
        cricketHistoryRepository = CricketHistoryRepository.getInstance(application);
    }

    public void getCricketHistory(DialogCallback dialogCallback) {
        cricketMatchHistoryRes = cricketHistoryRepository.getMatchHistoryMutableLiveData(dialogCallback);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: Called");
    }
}
