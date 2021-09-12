package com.innovertech.gameon.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.innovertech.gameon.model.CricketMatchHistory.CricketMatchHistoryRes;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class CricketHistoryRepository {
    private SessionManager sessionManager;
    private static CricketHistoryRepository cricketHistoryRepoInstance;

    public CricketHistoryRepository(Context context) {
        sessionManager = SessionManager.getInstance(context);
    }

    public static CricketHistoryRepository getInstance(Application application) {
        if (cricketHistoryRepoInstance == null) {
            cricketHistoryRepoInstance = new CricketHistoryRepository(application);
        }
        return cricketHistoryRepoInstance;
    }

    public MutableLiveData<CricketMatchHistoryRes> getMatchHistoryMutableLiveData(DialogCallback dialogCallback) {

        MutableLiveData<CricketMatchHistoryRes> matchHistoryMutableLiveData = new MutableLiveData<>();

        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<CricketMatchHistoryRes> matchHistoryCall = apiService.getUserCricketHistory(sessionManager.getSubId());
        matchHistoryCall.enqueue(new Callback<CricketMatchHistoryRes>() {
            @Override
            public void onResponse(Call<CricketMatchHistoryRes> call, Response<CricketMatchHistoryRes> response) {
                Log.d(TAG, "onCricketHistoryResponse: " + response.body());
                matchHistoryMutableLiveData.setValue(response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<CricketMatchHistoryRes> call, Throwable t) {
                Log.d(TAG, "onCricketHistoryFailure: " + t.getMessage());
                matchHistoryMutableLiveData.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });
        return matchHistoryMutableLiveData;
    }
}
