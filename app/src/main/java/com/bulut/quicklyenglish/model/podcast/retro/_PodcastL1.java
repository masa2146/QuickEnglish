package com.bulut.quicklyenglish.model.podcast.retro;

import com.bulut.quicklyenglish.model.podcast.PodcastL1;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _PodcastL1 {

    @SerializedName("content")
    @Expose
    private List<PodcastL1> content = null;
}
