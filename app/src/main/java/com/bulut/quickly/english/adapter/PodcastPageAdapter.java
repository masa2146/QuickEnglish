package com.bulut.quickly.english.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.CardPodcastPageBinding;
import com.bulut.quickly.english.adapter.impl.OnItemClickListener;
import com.bulut.quickly.english.model.adapter.PodcastPageData;
import com.bulut.quickly.english.view.main.MainPodcastFragment;
import com.bulut.quickly.english.view.podcast.PodcastLevelFragment;
import com.bulut.quickly.english.view.podcast.PodcastVoaFragment;

public class PodcastPageAdapter extends RecyclerView.Adapter<PodcastPageAdapter.PodcastPageViewHolder> implements OnItemClickListener {

    private PodcastPageData[] podcastPageData;
    private LayoutInflater layoutInflater;
    private Fragment view;

    public void setPodcastPageData(PodcastPageData[] grammarPageData) {
        this.podcastPageData = grammarPageData;
        notifyDataSetChanged();
    }

    public void setMainView(Fragment view) {
        this.view = view;
    }

    @NonNull
    @Override
    public PodcastPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CardPodcastPageBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_podcast_page, parent, false);
        return new PodcastPageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastPageViewHolder holder, int i) {
        holder.binding.setModel(podcastPageData[i]);
        holder.binding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return podcastPageData != null ? podcastPageData.length : 0;
    }

    @Override
    public void onItemClick(Object item) {
        PodcastPageData podcastPageData = (PodcastPageData) item;
        ((MainPodcastFragment)view).connectPageWithResponseType(podcastPageData);
    }

    class PodcastPageViewHolder extends RecyclerView.ViewHolder {

        private CardPodcastPageBinding binding;

        PodcastPageViewHolder(@NonNull CardPodcastPageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
