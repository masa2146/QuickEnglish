package com.bulut.quicklyenglish.model;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MainPageData {

    private int contentImage;
    private String contextHeader;
    private String contentText;

    @BindingAdapter({"imageResource"})
    public static void setImageViewResource(ImageView imageView, int resource){
        imageView.setImageResource(resource);
    }

    @BindingAdapter({"imageResource"})
    public static void loadImage(ImageView view, String imageUrl) {

        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }
}

