package com.bulut.quicklyenglish.model.podcast.retro;

import com.bulut.quicklyenglish.model.grammar.Adjectives;
import com.bulut.quicklyenglish.model.podcast.PodcastLB;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _PodcastLB {

    @SerializedName("content")
    @Expose
    private List<PodcastLB> content = null;
}
