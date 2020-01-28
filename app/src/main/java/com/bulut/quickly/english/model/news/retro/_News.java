package com.bulut.quickly.english.model.news.retro;

import com.bulut.quickly.english.model.news.News;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _News {

    @SerializedName("content")
    @Expose
    private List<News> content = null;
}
