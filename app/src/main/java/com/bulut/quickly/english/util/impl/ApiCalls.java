package com.bulut.quickly.english.util.impl;

import com.bulut.quickly.english.model.grammar.retro._Adjectives;
import com.bulut.quickly.english.model.grammar.retro._Adverbs;
import com.bulut.quickly.english.model.grammar.retro._Nouns;
import com.bulut.quickly.english.model.grammar.retro._Prepositions;
import com.bulut.quickly.english.model.grammar.retro._Pronouns;
import com.bulut.quickly.english.model.grammar.retro._Verbs;
import com.bulut.quickly.english.model.news.retro._News;
import com.bulut.quickly.english.model.podcast.retro._PodcastLevel;
import com.bulut.quickly.english.model.podcast.retro._PodcastVoa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCalls<T> {

    @GET("grammar/adjectives")
    Call<_Adjectives> getAdjectives(@Query("page") int page);

    @GET("grammar/adverbs")
    Call<_Adverbs> getAdverbs(@Query("page") int page);

    @GET("grammar/nouns")
    Call<_Nouns> getNouns(@Query("page") int page);

    @GET("grammar/prepositions")
    Call<_Prepositions> getPrepositions(@Query("page") int page);

    @GET("grammar/pronouns")
    Call<_Pronouns> getPronouns(@Query("page") int page);

    @GET("grammar/verbs")
    Call<_Verbs> getVerbs(@Query("page") int page);

    @GET("news")
    Call<_News> getNews(@Query("page") int page);

    @GET("podcast/level_1")
    Call<_PodcastLevel> getPodcastLevel1(@Query("page") int page);

    @GET("podcast/level_2")
    Call<_PodcastLevel> getPodcastLevel2(@Query("page") int page);

    @GET("podcast/level_3")
    Call<_PodcastLevel> getPodcastLevel3(@Query("page") int page);

    @GET("podcast/level_business")
    Call<_PodcastLevel> getPodcastLevelBusiness(@Query("page") int page);

    @GET("podcast/level_voa_level_1")
    Call<_PodcastVoa> getPodcastVoa1(@Query("page") int page);

    @GET("podcast/level_voa_level_2")
    Call<_PodcastVoa> getPodcastVoa2(@Query("page") int page);
}
