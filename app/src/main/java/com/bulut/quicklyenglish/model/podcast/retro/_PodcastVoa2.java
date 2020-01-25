package com.bulut.quicklyenglish.model.podcast.retro;

import com.bulut.quicklyenglish.model.podcast.PodcastVoa2;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _PodcastVoa2 {

    @SerializedName("content")
    @Expose
    private List<PodcastVoa2> content = null;
}
