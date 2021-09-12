package com.innovertech.gameon.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.innovertech.gameon.model.Leaderboard;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class PreviousWeekLeaderboardRepository {

    private SessionManager sessionManager;
    private static PreviousWeekLeaderboardRepository previousWeekLeaderboardRepositoryInstance;

    public PreviousWeekLeaderboardRepository(Context context) {
        this.sessionManager = SessionManager.getInstance(context);
    }


    public static PreviousWeekLeaderboardRepository getInstance(Application application) {
        if (previousWeekLeaderboardRepositoryInstance == null) {
            previousWeekLeaderboardRepositoryInstance = new PreviousWeekLeaderboardRepository(application);
        }
        return previousWeekLeaderboardRepositoryInstance;
    }

    public MutableLiveData<List<Leaderboard>> getPreWeekData(DialogCallback dialogCallback) {
        MutableLiveData<List<Leaderboard>> preWeekData = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<List<Leaderboard>> listCall = apiService.getLastWeekLeaderboard(sessionManager.getSubId());
        listCall.enqueue(new Callback<List<Leaderboard>>() {
            @Override
            public void onResponse(Call<List<Leaderboard>> call, Response<List<Leaderboard>> response) {
                Log.d(TAG, "onLastWeekLeaderboardResponse: Success " + response.body());
                preWeekData.setValue(response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<List<Leaderboard>> call, Throwable t) {
                Log.d(TAG, "onLastWeekLeaderboardFailed: fail " + t.getMessage());
                preWeekData.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });

        return preWeekData;
    }
}
