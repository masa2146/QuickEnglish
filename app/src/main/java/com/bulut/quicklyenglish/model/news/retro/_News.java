package com.bulut.quicklyenglish.model.news.retro;

import com.bulut.quicklyenglish.model.grammar.Adverbs;
import com.bulut.quicklyenglish.model.news.News;
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
