package com.bulut.quickly.english.model.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bulut.quickly.english.constant.GrammarType;
import com.bulut.quickly.english.constant.PodcastType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodcastPageData {

    private int contentImage;
    private String contextHeader;
    private String contentText;
    private PodcastType podcastType;

    @BindingAdapter({"imageResource"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
