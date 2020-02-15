package com.bulut.quickly.english.model.adapter;

import androidx.fragment.app.Fragment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fatih Bulut
 * This class is for card_main_page.xml file.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainPageData {

    private int contentImage;
    private String contextHeader;
    private String contentText;
    private Fragment fragment;

//    @BindingAdapter({"imageResource"})
//    public static void setImageViewResource(ImageView imageView, int resource) {
//        imageView.setImageResource(resource);
//    }
//
//    @BindingAdapter({"imageResource"})
//    public static void loadImage(ImageView view, String imageUrl) {
//
//        Glide.with(view.getContext())
//                .load(imageUrl)
//                .apply(RequestOptions.circleCropTransform())
//                .into(view);
//    }
}

