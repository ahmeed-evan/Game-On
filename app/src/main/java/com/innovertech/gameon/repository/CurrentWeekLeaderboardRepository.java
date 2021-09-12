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

public class CurrentWeekLeaderboardRepository {
    private SessionManager sessionManager;
    private static CurrentWeekLeaderboardRepository repositoryInstance;

    public CurrentWeekLeaderboardRepository(Context context) {
        this.sessionManager = SessionManager.getInstance(context);
    }

    public static CurrentWeekLeaderboardRepository getInstance(Application application) {
        if (repositoryInstance == null) {
            repositoryInstance = new CurrentWeekLeaderboardRepository(application);
        }
        return repositoryInstance;
    }

    public MutableLiveData<List<Leaderboard>> getThisWeekLeaderboard(DialogCallback dialogCallback) {
        MutableLiveData<List<Leaderboard>> leaderboardData = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<List<Leaderboard>> leaderboardCall = apiService
                .getThisWeekLeaderboard(sessionManager.getSubId());

        leaderboardCall.enqueue(new Callback<List<Leaderboard>>() {
            @Override
            public void onResponse(Call<List<Leaderboard>> call, Response<List<Leaderboard>> response) {
                Log.d(TAG, "onThisWeekLeaderboardResponse: Success " + response.body());
                leaderboardData.setValue(response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<List<Leaderboard>> call, Throwable t) {
                Log.d(TAG, "onThisWeekLeaderboardFailed: fail " + t.getMessage());
                leaderboardData.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });

        return leaderboardData;
    }

}
