package com.innovertech.gameon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.innovertech.gameon.model.auth.AuthRes;
import com.innovertech.gameon.model.auth.SignInReq;
import com.innovertech.gameon.model.auth.SignUpReq;
import com.innovertech.gameon.repository.AuthRepository;
import com.innovertech.gameon.utils.DialogCallback;

public class AuthViewmodel extends AndroidViewModel {

    public LiveData<AuthRes> signInResLiveData;
    public LiveData<AuthRes> signUpResLiveData;
    private AuthRepository authRepository;

    public AuthViewmodel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getInstance();
    }

    public void signInUser(SignInReq signInReq, DialogCallback dialogCallback) {
        signInResLiveData = authRepository.signInUser(signInReq, dialogCallback);
    }

    public void signUpUser(SignUpReq signUpReq, DialogCallback dialogCallback) {
        signUpResLiveData = authRepository.signUpUser(signUpReq, dialogCallback);
    }

}
