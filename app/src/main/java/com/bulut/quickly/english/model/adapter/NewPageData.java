package com.bulut.quickly.english.model.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPageData {

    private int contentImage;
    private String contextHeader;
    private String contentText;
    private Fragment fragment;

    @BindingAdapter({"imageResource"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
