package com.bulut.quicklyenglish.util;

import com.bulut.quicklyenglish.model.grammar.retro._Adjectives;
import com.bulut.quicklyenglish.model.grammar.retro._Adverbs;
import com.bulut.quicklyenglish.model.grammar.retro._Nouns;
import com.bulut.quicklyenglish.model.grammar.retro._Prepositions;
import com.bulut.quicklyenglish.model.grammar.retro._Pronouns;
import com.bulut.quicklyenglish.model.grammar.retro._Verbs;
import com.bulut.quicklyenglish.model.news.retro._News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCalls {

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
}
