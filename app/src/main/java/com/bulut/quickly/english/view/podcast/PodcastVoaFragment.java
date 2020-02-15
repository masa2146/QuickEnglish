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
import com.bulut.quickly.english.adapter.PodcastVoaContentAdapter;
import com.bulut.quickly.english.constant.PagesNames;
import com.bulut.quickly.english.constant.PodcastType;
import com.bulut.quickly.english.constant.ResponseType;
import com.bulut.quickly.english.model.adapter.PodcastVoaContentData;
import com.bulut.quickly.english.model.podcast.PodcastVoa;
import com.bulut.quickly.english.model.podcast.retro._PodcastVoa;
import com.bulut.quickly.english.util.CallbackMethods;
import com.bulut.quickly.english.util.impl.APICallBackListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class PodcastVoaFragment extends Fragment implements APICallBackListener<_PodcastVoa> {

    private View view;
    private RecyclerView recyclerView;
    private FragmentPodcastVoaBinding binding;
    private CallbackMethods<_PodcastVoa> callbackMethods;
    private ArrayList<PodcastVoaContentData> contentData;

    public PodcastVoaFragment() {
        //noinspection unchecked
        callbackMethods = new CallbackMethods(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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
            case PODCAST_VOA_1:
                tempUrl = PagesNames.PODCAST_VOA1_WITH_PAGE;
                break;
            case PODCAST_VOA_2:
                tempUrl = PagesNames.PODCAST_VOA2_WITH_PAGE;
                break;
        }
        callbackMethods.callData(responseType, "podcast/" + tempUrl, page);

    }


    @Override
    public void onResponse(Call<_PodcastVoa> call, Response<_PodcastVoa> response) {
        assert response.body() != null;
        convertToContentDataFromBaseModel(response.body().getContent());
        this.setContentDataToAdapter();
    }

    @Override
    public void onFailure(Call<_PodcastVoa> call, Throwable t) {
        System.out.println("PODCAST_VOA HATASI VAR " + t.getMessage());
    }

    private void convertToContentDataFromBaseModel(List<PodcastVoa> baseModels) {
        for (PodcastVoa model : baseModels) {
            this.contentData.add(new PodcastVoaContentData(R.drawable.profile_img, model.getTitle(), model.getDialog(), model.getUrl()));
            System.out.println("PODCAST VOA MODEL: "+model.getTitle());
        }
    }

    private void setContentDataToAdapter() {
        PodcastVoaContentAdapter podcastVoaContentAdapter = new PodcastVoaContentAdapter();
        podcastVoaContentAdapter.setMainView(this);
        podcastVoaContentAdapter.setPodcastVoaContentData(this.contentData.toArray(new PodcastVoaContentData[contentData.size()]));

        recyclerView.setAdapter(podcastVoaContentAdapter);
    }
}
