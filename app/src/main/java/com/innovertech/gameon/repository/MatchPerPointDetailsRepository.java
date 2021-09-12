package com.innovertech.gameon.repository;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderPoint;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MatchPerPointDetailsRepository {
    private static MatchPerPointDetailsRepository matchPerPointDetailsRepoInstance;

    public static MatchPerPointDetailsRepository getMatchPerLeaderBoardRepoInstance() {
        if (matchPerPointDetailsRepoInstance == null) {
            matchPerPointDetailsRepoInstance = new MatchPerPointDetailsRepository();
        }
        return matchPerPointDetailsRepoInstance;
    }

    public MutableLiveData<MatchPerLeaderPoint> getMatchPerPointDetails(String matchId, Integer participateId, DialogCallback dialogCallback) {
        MutableLiveData<MatchPerLeaderPoint> matchPerPointDetailsMutableLiveData = new MutableLiveData<>();

        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<MatchPerLeaderPoint> matchPerLeaderPointCall = apiService.getMatchPerLeaderPointDetails(matchId, participateId);
        matchPerLeaderPointCall.enqueue(new Callback<MatchPerLeaderPoint>() {
            @Override
            public void onResponse(Call<MatchPerLeaderPoint> call, Response<MatchPerLeaderPoint> response) {
                Log.d(TAG, "onMatchPerLeaderPointDetailsResponse: " + response.body());
                matchPerPointDetailsMutableLiveData.setValue(response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<MatchPerLeaderPoint> call, Throwable t) {
                Log.d(TAG, "onMatchPerLeaderPointDetailsFailure: " + t.getMessage());
                matchPerPointDetailsMutableLiveData.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });


        return matchPerPointDetailsMutableLiveData;
    }
}
