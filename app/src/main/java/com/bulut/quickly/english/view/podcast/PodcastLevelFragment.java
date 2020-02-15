package com.bulut.quickly.english.view.podcast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.FragmentPodcastVoaBinding;
import com.bulut.quickly.english.adapter.PodcastLevelContentAdapter;
import com.bulut.quickly.english.constant.PagesNames;
import com.bulut.quickly.english.constant.PodcastType;
import com.bulut.quickly.english.constant.ResponseType;
import com.bulut.quickly.english.model.adapter.PodcastLevelContentData;
import com.bulut.quickly.english.model.podcast.PodcastLevel;
import com.bulut.quickly.english.model.podcast.retro._PodcastLevel;
import com.bulut.quickly.english.util.CallbackMethods;
import com.bulut.quickly.english.util.impl.APICallBackListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class PodcastLevelFragment extends Fragment implements APICallBackListener<_PodcastLevel> {

    private View view;
    private RecyclerView recyclerView;
    private FragmentPodcastVoaBinding binding;
    private CallbackMethods<_PodcastLevel> callbackMethods;
    private ArrayList<PodcastLevelContentData> contentData;

    public PodcastLevelFragment() {
        //noinspection unchecked
        callbackMethods = new CallbackMethods(this);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_podcast_voa, container, false);
        view = binding.getRoot();
        init();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {
        contentData = new ArrayList<>();

        recyclerView = binding.mainPodcastVoa;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(true);

    }

    public void getDataByPodcastType(ResponseType responseType, PodcastType podcastType, int page) {
        String tempUrl = "";
        switch (podcastType) {
            case PODCAST_LEVEL_1:
                tempUrl = PagesNames.PODCAST_LEVEL1_WITH_PAGE;
                break;
            case PODCAST_LEVEL_2:
                tempUrl = PagesNames.PODCAST_LEVEL2_WITH_PAGE;
                break;
            case PODCAST_LEVEL_3:
                tempUrl = PagesNames.PODCAST_LEVEL3_WITH_PAGE;
                break;
            case PODCAST_LEVEL_BUSINESS:
                tempUrl = PagesNames.PODCAST_LEVEL_BUSINESS_WITH_PAGE;
                break;
        }
        callbackMethods.callData(responseType, "podcast/" + tempUrl, page);
    }

    @Override
    public void onResponse(Call<_PodcastLevel> call, Response<_PodcastLevel> response) {
        assert response.body() != null;
        convertToContentDataFromBaseModel(response.body().getContent());
        this.setContentDataToAdapter();
    }

    @Override
    public void onFailure(Call<_PodcastLevel> call, Throwable t) {

    }

    private void convertToContentDataFromBaseModel(List<PodcastLevel> baseModels) {
        for (PodcastLevel model : baseModels) {
            this.contentData.add(new PodcastLevelContentData(R.drawable.profile_img, model.getTitle(), model.getDescription(), model.getUrl()));
            System.out.println("PODCAST LEVEL MODEL: " + model.getTitle());
        }
    }

    private void setContentDataToAdapter() {
        PodcastLevelContentAdapter podcastLevelContentAdapter = new PodcastLevelContentAdapter();
        podcastLevelContentAdapter.setMainView(this);
        podcastLevelContentAdapter.setPodcastLevelContentData(this.contentData.toArray(new PodcastLevelContentData[contentData.size()]));

        recyclerView.setAdapter(podcastLevelContentAdapter);
    }
}
