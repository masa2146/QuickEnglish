package com.bulut.quickly.english.view.main;

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
import com.bulut.quickly.databinding.FragmentMainGrammarBinding;
import com.bulut.quickly.databinding.FragmentMainPodcastBinding;
import com.bulut.quickly.english.adapter.GrammarPageAdapter;
import com.bulut.quickly.english.adapter.PodcastPageAdapter;
import com.bulut.quickly.english.constant.PagesNames;
import com.bulut.quickly.english.util.impl.APICallBackListener;

public class MainPodcastFragment extends Fragment {

    private View view;
    private FragmentMainPodcastBinding binding;

    public MainPodcastFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_podcast, container, false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        RecyclerView recyclerView = binding.mainPodcast;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(true);

        PodcastPageAdapter podcastPageAdapter = new PodcastPageAdapter();
        podcastPageAdapter.setContext(view.getContext());
        podcastPageAdapter.setPodcastPageData(PagesNames.podcastPageDataArray);

        recyclerView.setAdapter(podcastPageAdapter);
    }
}
