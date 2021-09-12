package com.innovertech.gameon.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.innovertech.gameon.model.BannerSlider;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private final Context context;
    private final List<BannerSlider> sliderList;

    public SliderAdapter(Context context, List<BannerSlider> sliderList) {
        this.context = context;
        this.sliderList = sliderList;
    }

    @Override
    public int getCount() {
        return sliderList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.hasOverlappingRendering();
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(sliderList.get(position).getImageId());
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((ImageView)object);
    }
}
