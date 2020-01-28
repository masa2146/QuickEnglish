package com.bulut.quickly.english.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.CardPodcastContentBinding;
import com.bulut.quickly.english.adapter.impl.OnItemClickListener;
import com.bulut.quickly.english.model.adapter.PodcastPageData;

public class PodcastPageAdapter extends RecyclerView.Adapter<PodcastPageAdapter.PodcastPageViewHolder> implements OnItemClickListener {

    private PodcastPageData[] podcastPageData;
    private LayoutInflater layoutInflater;
    private Context context;

    public void setPodcastPageData(PodcastPageData[] grammarPageData) {
        this.podcastPageData = grammarPageData;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PodcastPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CardPodcastContentBinding cardPodcastContentBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_podcast_content, parent, false);
        return new PodcastPageViewHolder(cardPodcastContentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastPageViewHolder holder, int i) {
        holder.cardPodcastContentBinding.setModel(podcastPageData[i]);
        holder.cardPodcastContentBinding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return podcastPageData != null ? podcastPageData.length : 0;
    }

    @Override
    public void onItemClick(Object item) {
        System.out.println("GRAMMAR CLICK ISLEMI");
    }

    class PodcastPageViewHolder extends RecyclerView.ViewHolder {

        private CardPodcastContentBinding cardPodcastContentBinding;

        PodcastPageViewHolder(@NonNull CardPodcastContentBinding cardPodcastContentBinding) {
            super(cardPodcastContentBinding.getRoot());
            this.cardPodcastContentBinding = cardPodcastContentBinding;
        }
    }
}
