package com.innovertech.gameon.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderBoard;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MatchPerLeaderBoardRepository {

    private static MatchPerLeaderBoardRepository matchPerLeaderBoardRepoInstance;
    private SessionManager sessionManager;

    public MatchPerLeaderBoardRepository(Application application) {
        sessionManager = SessionManager.getInstance(application);
    }

    public static MatchPerLeaderBoardRepository getInstance(Application application) {
        if (matchPerLeaderBoardRepoInstance == null) {
            matchPerLeaderBoardRepoInstance = new MatchPerLeaderBoardRepository(application);
        }
        return matchPerLeaderBoardRepoInstance;
    }

    public MutableLiveData<List<MatchPerLeaderBoard>> getMatchLeaders(String matchId, DialogCallback dialogCallback) {
        MutableLiveData<List<MatchPerLeaderBoard>> matchPerLeaders = new MutableLiveData<>();

        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<List<MatchPerLeaderBoard>> leaderBoardCall = apiService.getMatchLeaders(matchId, sessionManager.getSubId());
        leaderBoardCall.enqueue(new Callback<List<MatchPerLeaderBoard>>() {
            @Override
            public void onResponse(Call<List<MatchPerLeaderBoard>> call, Response<List<MatchPerLeaderBoard>> response) {
                Log.d(TAG, "onMatchPerLeadersResponse: " + response.body());
                matchPerLeaders.setValue(response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<List<MatchPerLeaderBoard>> call, Throwable t) {
                Log.d(TAG, "onMatchPerLeadersFailure: " + t.getMessage());
                matchPerLeaders.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });

        return matchPerLeaders;
    }
}
