package com.bulut.quickly.english.model.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;

import com.bulut.quickly.english.constant.GrammarType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrammarPageData {

    private int contentImage;
    private String contextHeader;
    private String contentText;
    private GrammarType grammarType;

    @BindingAdapter({"imageResource"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
