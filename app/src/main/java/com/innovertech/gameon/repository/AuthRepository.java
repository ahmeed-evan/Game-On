package com.innovertech.gameon.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.innovertech.gameon.model.auth.AuthRes;
import com.innovertech.gameon.model.auth.SignInReq;
import com.innovertech.gameon.model.auth.SignUpReq;
import com.innovertech.gameon.network.APIService;
import com.innovertech.gameon.network.RetrofitInstance;
import com.innovertech.gameon.utils.DialogCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class AuthRepository {

    private static AuthRepository authRepoInstance;

    public static AuthRepository getInstance() {
        if (authRepoInstance == null) {
            authRepoInstance = new AuthRepository();
        }
        return authRepoInstance;
    }


    public MutableLiveData<AuthRes> signInUser(SignInReq signInReq, DialogCallback dialogCallback) {
        MutableLiveData<AuthRes> authResMutableLiveData = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<AuthRes> authResCall = apiService.signInUser(signInReq);
        authResCall.enqueue(new Callback<AuthRes>() {
            @Override
            public void onResponse(Call<AuthRes> call, Response<AuthRes> response) {
                Log.d(TAG, "onAuthResponse: " + response.body());
                authResMutableLiveData.setValue(response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<AuthRes> call, Throwable t) {
                Log.d(TAG, "onAuthResFailure: " + t.getMessage());
                authResMutableLiveData.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });
        return authResMutableLiveData;
    }

    public MutableLiveData<AuthRes> signUpUser(SignUpReq signUpReq, DialogCallback dialogCallback) {
        MutableLiveData<AuthRes> liveDataMutableLiveData = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getInstance().getApiService();
        Call<AuthRes> authResCall = apiService.signUpUser(signUpReq);
        authResCall.enqueue(new Callback<AuthRes>() {
            @Override
            public void onResponse(Call<AuthRes> call, Response<AuthRes> response) {
                Log.d(TAG, "onSignUpResponse: " + response.body());
                liveDataMutableLiveData.setValue(response.body());
                dialogCallback.onRequestCompleted(true);
            }

            @Override
            public void onFailure(Call<AuthRes> call, Throwable t) {
                Log.d(TAG, "onSignUpFailure: " + t.getMessage());
                liveDataMutableLiveData.postValue(null);
                dialogCallback.onRequestCompleted(true);
            }
        });
        return liveDataMutableLiveData;
    }
}
