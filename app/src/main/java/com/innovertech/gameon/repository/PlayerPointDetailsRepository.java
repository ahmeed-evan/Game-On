package com.innovertech.gameon.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.innovertech.gameon.model.PointHistoryDetails.PointHistoryDetailsCricket;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;
import com.innovertech.gameon.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class PlayerPointDetailsRepository {
    private MutableLiveData<PointHistoryDetailsCricket> liveData;
    private static PlayerPointDetailsRepository pointDetailsRepositoryInstance;
    private SessionManager sessionManager;

    public PlayerPointDetailsRepository(Context context) {
        liveData = new MutableLiveData<>();
        sessionManager = SessionManager.getInstance(context);
    }

    public static PlayerPointDetailsRepository getInstance(Application application) {
        if (pointDetailsRepositoryInstance == null) {
            pointDetailsRepositoryInstance = new PlayerPointDetailsRepository(application);
        }
        return pointDetailsRepositoryInstance;
    }

    public MutableLiveData<PointHistoryDetailsCricket> getPlayerPointDetails(Integer matchId, DialogCallback dialogCallback) {
        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Log.d(TAG, "getPlayerPointDetails: " + matchId);
        Call<PointHistoryDetailsCricket> detailsCall = apiService.getPlayerPointDetails(matchId, sessionManager.getSubId());
        detailsCall.enqueue(new Callback<PointHistoryDetailsCricket>() {
            @Override
            public void onResponse(Call<PointHistoryDetailsCricket> call, Response<PointHistoryDetailsCricket> response) {
                liveData.setValue(response.body());
                Log.d(TAG, "onPointHistoryResponse: " + response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<PointHistoryDetailsCricket> call, Throwable t) {
                liveData.postValue(null);
                Log.d(TAG, "onPlayerPointFailure: " + t.getMessage());
                dialogCallback.onRequestCompleted(true);
            }
        });
        return liveData;
    }
}
