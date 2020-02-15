package com.bulut.quickly.english.util.impl;

import com.bulut.quickly.english.model.grammar.retro._GrammarBaseModel;
import com.bulut.quickly.english.model.news.retro._News;
import com.bulut.quickly.english.model.podcast.retro._PodcastLevel;
import com.bulut.quickly.english.model.podcast.retro._PodcastVoa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiCalls<T> {

    @GET
    Call<_GrammarBaseModel> getGrammar(@Url String url, @Query("page") int page);

    @GET
    Call<_News> getNews(@Url String url, @Query("page") int page);

    @GET
    Call<_PodcastLevel> getPodcastLevel(@Url String url, @Query("page") int page);

    @GET
    Call<_PodcastVoa> getPodcastVoa(@Url String url, @Query("page") int page);
}
