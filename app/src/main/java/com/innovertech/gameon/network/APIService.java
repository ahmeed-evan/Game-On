package com.innovertech.gameon.network;

import com.innovertech.gameon.model.AuthRequest;
import com.innovertech.gameon.model.CricketMatchHistory.CricketMatchHistoryRes;
import com.innovertech.gameon.model.FootballMatchHistory.FootballMatchHistoryRes;
import com.innovertech.gameon.model.Leaderboard;
import com.innovertech.gameon.model.Match.MatchRes;
import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderBoard;
import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderPoint;
import com.innovertech.gameon.model.MobileVerify.MobilePinVerify;
import com.innovertech.gameon.model.MobileVerify.MobileVerify;
import com.innovertech.gameon.model.MobileVerify.VerifyRes;
import com.innovertech.gameon.model.NumberLogin.NumberLogin;
import com.innovertech.gameon.model.NumberLogin.OtpNumber;
import com.innovertech.gameon.model.OtpVerification.Otp;
import com.innovertech.gameon.model.PointHistoryDetails.PointHistoryDetailsCricket;
import com.innovertech.gameon.model.PointHistoryDetails.PointHistoryDetailsFootball;
import com.innovertech.gameon.model.Profile;
import com.innovertech.gameon.model.Quiz.QuestionRes;
import com.innovertech.gameon.model.Quiz.QuizLeaderboard;
import com.innovertech.gameon.model.Quiz.QuizResult;
import com.innovertech.gameon.model.Quiz.QuizSubmitRes;
import com.innovertech.gameon.model.Squad.SelectedSquad;
import com.innovertech.gameon.model.Squad.SelectedSquadRes;
import com.innovertech.gameon.model.Squad.SquadRes;
import com.innovertech.gameon.model.SubscriptionRes;
import com.innovertech.gameon.model.User;
import com.innovertech.gameon.model.auth.AuthRes;
import com.innovertech.gameon.model.auth.SignInReq;
import com.innovertech.gameon.model.auth.SignUpReq;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Login/login")
    Call<AuthRes> signInUser(@Body SignInReq signInReq);

    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Login/addProfile")
    Call<AuthRes> signUpUser(@Body SignUpReq signUpReq);


    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Login/login")
    Call<User> getUser(@Body AuthRequest authRequest);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Get_matches/index/1/{subId}")
    Call<MatchRes> getMatches(@Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Leaderboard/index/1/{subId}")
    Call<List<Leaderboard>> getThisWeekLeaderboard(@Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Leaderboard/prev/1/{subId}")
    Call<List<Leaderboard>> getLastWeekLeaderboard(@Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Get_history/index/1/{subId}")
    Call<CricketMatchHistoryRes> getUserCricketHistory(@Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Get_history/getHistoryFootball/1/{subId}")
    Call<FootballMatchHistoryRes> getUserFootballHistory(@Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Get_point_rank/index/{matchId}/1/{subId}")
    Call<PointHistoryDetailsCricket> getPlayerPointDetails(@Path("matchId") int matchId, @Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Get_point_rank/getPointFootball/{matchId}/1/{subId}")
    Call<PointHistoryDetailsFootball> getPlayerPointDetailsFootball(@Path("matchId") int matchId, @Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Get_squad/index/{matchId}/{type}/1/{subId}")
    Call<SquadRes> getSquads(@Path("matchId") Integer matchId, @Path("type") String type, @Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Quiz/getQuestion/1/{subId}")
    Call<QuestionRes> getQuizQuestion(@Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Quiz/submitAnswer/{questionId}/{option}/1/{subId}")
    Call<QuizSubmitRes> submit(@Path("questionId") Integer questionId, @Path("option") int option, @Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Quiz/getQuizPoint/1/{subId}")
    Call<QuizResult> getResult(@Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Subscribe/subscribe/{package_type}/1/{subId}")
    Call<SubscriptionRes> getSubRes(@Path("package_type") String package_type, @Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Login/loginWithMobile")
    Call<NumberLogin> sendOTP(@Body OtpNumber otpNumber);

    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Login/loginWithMobile")
    Call<NumberLogin> reSendOTPToNumber(@Body OtpNumber otpNumber);


    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Login/verifyPin")
    Call<User> sendOtpForVerification(@Body Otp otp);

    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Get_squad/selectSquad/{subId}/{type}")
    Call<SelectedSquadRes> submitSquad(@Body SelectedSquad selectedSquad, @Path("subId") String subId, @Path("type") String type);


    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Login/verifyMobile/{subId}/1")
    Call<MobileVerify> verifyMobile(@Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Login/verifyProfilePin")
    Call<VerifyRes> verifyMobilePin(@Body MobilePinVerify mobilePinVerify);

    @Headers("Content-Type: text/html; charset=utf-8")
    @POST("Login/addProfile")
    Call<VerifyRes> addProfile(@Body Profile profile);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Leaderboard/matchLeaderboard/{matchId}/1/{subId}")
    Call<List<MatchPerLeaderBoard>> getMatchLeaders(@Path("matchId") String matchId, @Path("subId") String subId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Get_point_rank/getPointOfParticipantForAMatch/{matchId}/{participateId}/1}")
    Call<MatchPerLeaderPoint> getMatchPerLeaderPointDetails(@Path("matchId") String matchId, @Path("participateId") Integer participateId);

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("Quiz/quizLeaderboard/1")
    Call<List<QuizLeaderboard>> getQuizLeaderboard();

}
