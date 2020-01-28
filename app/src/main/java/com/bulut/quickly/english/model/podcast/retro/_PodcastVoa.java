package com.bulut.quickly.english.model.podcast.retro;

import com.bulut.quickly.english.model.podcast.PodcastVoa;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _PodcastVoa {

    @SerializedName("content")
    @Expose
    private List<PodcastVoa> content = null;
}
