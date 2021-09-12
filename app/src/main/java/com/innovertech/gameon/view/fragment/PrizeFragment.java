package com.innovertech.gameon.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.innovertech.gameon.R;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrizeFragment extends Fragment {

    @BindView(R.id.prizeImageIV)
    ImageView prizeImageIV;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prize, container, false);
        ButterKnife.bind(this, view);
        loadPrizeImage();
        return view;
    }

    private void loadPrizeImage() {
//        try {
//            Glide.with(getActivity()).load("http://128.199.192.87/Content/bf11purno/prize.jpg").into(prizeImageIV);
//        } catch (Exception e) {
//
//        }
    }


    @OnClick(R.id.backArrow)
    void backArrowClicked() {
        getActivity().onBackPressed();
    }
}
