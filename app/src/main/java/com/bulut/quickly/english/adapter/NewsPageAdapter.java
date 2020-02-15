package com.bulut.quickly.english.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.CardNewsPageBinding;
import com.bulut.quickly.english.adapter.impl.OnItemClickListener;
import com.bulut.quickly.english.model.adapter.NewPageData;

import java.util.ArrayList;

public class NewsPageAdapter extends RecyclerView.Adapter<NewsPageAdapter.NewsPageViewHolder> implements OnItemClickListener {

    private ArrayList<NewPageData> newsPageData;
    private LayoutInflater layoutInflater;
    private Context context;

    public void setMainPageData(ArrayList<NewPageData> newsPageData) {
        this.newsPageData = newsPageData;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NewsPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater != null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CardNewsPageBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_news_page, parent, false);
        return new NewsPageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsPageViewHolder holder, int i) {
        holder.binding.setModel(newsPageData.get(i));
        holder.binding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return newsPageData != null ? newsPageData.size() : 0;
    }

    @Override
    public void onItemClick(Object item) {
        System.out.println("NEW ADAPTER CLICK");
    }

    public class NewsPageViewHolder extends RecyclerView.ViewHolder {
        private CardNewsPageBinding binding;

        public NewsPageViewHolder(@NonNull CardNewsPageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
