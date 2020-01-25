package com.bulut.quicklyenglish.model.podcast.retro;

import com.bulut.quicklyenglish.model.podcast.PodcastL3;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _PodcastL3 {

    @SerializedName("content")
    @Expose
    private List<PodcastL3> content = null;
}
