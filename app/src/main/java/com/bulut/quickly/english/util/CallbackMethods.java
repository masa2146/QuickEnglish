package com.bulut.quickly.english.util;

import androidx.annotation.NonNull;

import com.bulut.quickly.english.util.impl.APICallBackListener;
import com.bulut.quickly.english.util.impl.ApiCalls;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackMethods<T> {

    private ApiCalls apiCalls = ApiClient.getClient().create(ApiCalls.class);
    private APICallBackListener<T> apiCallBackListener;
    private Call<T> call;
    private ResponseType responseType;

    private int page = 1;

    public CallbackMethods(APICallBackListener<T> apiCallBackListener, ResponseType responseType) {
        this.apiCallBackListener = apiCallBackListener;
        this.responseType = responseType;
    }

    @SuppressWarnings("unchecked")
    private void setResponseType(ResponseType responseType) {
        switch (responseType) {
            case ADJECTIVES:
                call = apiCalls.getAdjectives(page);
                break;
            case ADVERBS:
                call = apiCalls.getAdverbs(page);
                break;
            case NOUNS:
                call = apiCalls.getNouns(page);
                break;
            case PREPOSITIONS:
                call = apiCalls.getPrepositions(page);
                break;
            case PRONOUNS:
                call = apiCalls.getPronouns(page);
                break;
            case VERBS:
                call = apiCalls.getVerbs(page);
                break;
            case NEWS:
                call = apiCalls.getNews(page);
                break;
            case PODCAST_LEVEL_1:
                call = apiCalls.getPodcastLevel1(page);
                break;
            case PODCAST_LEVEL_2:
                call = apiCalls.getPodcastLevel2(page);
                break;
            case PODCAST_LEVEL_3:
                call = apiCalls.getPodcastLevel3(page);
                break;
            case PODCAST_LEVEL_BUSINESS:
                call = apiCalls.getPodcastLevelBusiness(page);
                break;
            case PODCAST_VOA_1:
                call = apiCalls.getPodcastVoa1(page);
                break;
            case PODCAST_VOA_2:
                call = apiCalls.getPodcastVoa2(page);
                break;
        }
    }

    public void callData(int page) {
        this.page = page;
        setResponseType(responseType);
        call.enqueue(new Callback<T>() {

            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                assert response.body() != null;
                apiCallBackListener.onResponse(call, response);
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                apiCallBackListener.onFailure(call, t);
            }
        });
    }
}
