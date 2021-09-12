package com.innovertech.gameon.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.innovertech.gameon.model.Match.MatchRes;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class HomeFragmentRepository {

    private MutableLiveData<MatchRes> matches;
    private SessionManager sessionManager;

    public HomeFragmentRepository(Application application) {
        this.matches = new MutableLiveData<>();
        this.sessionManager = SessionManager.getInstance(application);
    }

    public MutableLiveData<MatchRes> getMatches(DialogCallback dialogCallback) {
        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<MatchRes> matchCall = apiService.getMatches(sessionManager.getSubId());
        matchCall.enqueue(new Callback<MatchRes>() {
            @Override
            public void onResponse(Call<MatchRes> call, Response<MatchRes> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onMatchResponse: success " + response.body().getData());
                    matches.setValue(response.body());
                    dialogCallback.onRequestCompleted(true);
                }
            }

            @Override
            public void onFailure(Call<MatchRes> call, Throwable t) {
                Log.d(TAG, "onMatchFailure: fail " + t.getMessage());
                matches.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });

        return matches;
    }
}
