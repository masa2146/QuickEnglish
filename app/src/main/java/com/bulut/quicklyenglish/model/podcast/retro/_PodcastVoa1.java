package com.bulut.quicklyenglish.model.podcast.retro;

import com.bulut.quicklyenglish.model.podcast.PodcastVoa1;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _PodcastVoa1 {

    @SerializedName("content")
    @Expose
    private List<PodcastVoa1> content = null;
}
