package com.innovertech.gameon.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.innovertech.gameon.model.Squad.SquadRes;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class CreateTeamRepository {

    private static CreateTeamRepository createTeamRepoInstance;
    private MutableLiveData<SquadRes> resMutableLiveData;
    private SessionManager sessionManager;

    public CreateTeamRepository(Context context) {
        resMutableLiveData = new MutableLiveData<>();
        sessionManager = SessionManager.getInstance(context);
    }

    public static CreateTeamRepository getInstance(Application application) {
        if (createTeamRepoInstance == null) {
            createTeamRepoInstance = new CreateTeamRepository(application);
        }
        return createTeamRepoInstance;
    }

    public MutableLiveData<SquadRes> getSquad(int matchId, String type, DialogCallback dialogCallback) {

        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<SquadRes> squadResCall = apiService.getSquads(matchId, type, sessionManager.getSubId());
        squadResCall.enqueue(new Callback<SquadRes>() {
            @Override
            public void onResponse(Call<SquadRes> call, Response<SquadRes> response) {
                Log.d(TAG, "onSquadResponse: " + response.body());
                resMutableLiveData.setValue(response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<SquadRes> call, Throwable t) {
                Log.d(TAG, "onSquadFailure: " + t.getMessage());
                resMutableLiveData.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });
        return resMutableLiveData;
    }
}
