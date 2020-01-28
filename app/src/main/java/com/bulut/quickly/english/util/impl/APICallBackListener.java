package com.bulut.quickly.english.util.impl;

import retrofit2.Call;
import retrofit2.Response;

public interface APICallBackListener<T> {
    void onResponse(Call<T> call, Response<T> response);
    void onFailure(Call<T> call, Throwable t);
}
