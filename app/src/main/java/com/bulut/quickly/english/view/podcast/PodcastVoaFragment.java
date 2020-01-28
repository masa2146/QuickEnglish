package com.bulut.quickly.english.view.podcast;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bulut.quickly.R;
import com.bulut.quickly.english.model.podcast.retro._PodcastVoa;
import com.bulut.quickly.english.util.impl.APICallBackListener;

import retrofit2.Call;
import retrofit2.Response;

public class PodcastVoaFragment extends Fragment implements APICallBackListener<_PodcastVoa> {

    public PodcastVoaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_podcast_voa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResponse(Call<_PodcastVoa> call, Response<_PodcastVoa> response) {

    }

    @Override
    public void onFailure(Call<_PodcastVoa> call, Throwable t) {

    }
}
