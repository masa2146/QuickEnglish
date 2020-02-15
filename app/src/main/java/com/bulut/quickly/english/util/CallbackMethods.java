package com.bulut.quickly.english.util;

import androidx.annotation.NonNull;

import com.bulut.quickly.english.constant.ResponseType;
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
    private String url = "";


    public CallbackMethods(APICallBackListener<T> apiCallBackListener) {
        this.apiCallBackListener = apiCallBackListener;
    }

    @SuppressWarnings("unchecked")
    private void setResponseType(ResponseType responseType) {
        switch (responseType) {
            case GRAMMAR:
                call = apiCalls.getGrammar(url,page);
                break;
            case PODCAST_LEVEL:
                call = apiCalls.getPodcastLevel(url,page);
                break;
            case PODCAST_VOA:
                call = apiCalls.getPodcastVoa(url,page);
                break;
            case NEWS:
                call = apiCalls.getNews(url,page);
                break;

        }
    }

    public void callData(ResponseType responseType,String url ,int page) {
        this.page = page;
        this.url = url;
        this.responseType = responseType;
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
