package com.innovertech.gameon.repository;

import android.app.Application;
import android.util.Log;


import com.innovertech.gameon.model.Squad.SelectedSquad;
import com.innovertech.gameon.model.Squad.SelectedSquadRes;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class SquadRepository {

    private static SquadRepository squadRepoInstance;
    private SessionManager sessionManager;

    public SquadRepository(Application application) {
        sessionManager = SessionManager.getInstance(application);
    }

    public static SquadRepository getInstance(Application application) {
        if (squadRepoInstance == null) {
            squadRepoInstance = new SquadRepository(application);
        }
        return squadRepoInstance;
    }

    public void submitSquad(SelectedSquad selectedSquad, String type, DialogCallback dialogCallback) {
        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<SelectedSquadRes> squadResCall = apiService.submitSquad( selectedSquad,sessionManager.getSubId(), type);
        squadResCall.enqueue(new Callback<SelectedSquadRes>() {
            @Override
            public void onResponse(Call<SelectedSquadRes> call, Response<SelectedSquadRes> response) {
                Log.d(TAG, "onSelectedSquadResponse: " + response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<SelectedSquadRes> call, Throwable t) {
                Log.d(TAG, "onSelectedSquadFailure: " + t.getMessage());
                dialogCallback.onRequestCompleted(false);
            }
        });
    }
}
