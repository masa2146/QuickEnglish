package com.bulut.quicklyenglish.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quicklyenglish.R;
import com.bulut.quicklyenglish.databinding.MainCardContentBinding;
import com.bulut.quicklyenglish.model.MainPageData;

import java.util.ArrayList;


public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainPageViewHolder> {

    private ArrayList<MainPageData> mainPageDatas;


    @NonNull
    @Override
    public MainPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainCardContentBinding mainCardContentBinding =
                DataBindingUtil.inflate(LayoutInflater.from(
                        parent.getContext()),
                        R.layout.main_card_content, parent,
                        false);

        return new MainPageViewHolder(mainCardContentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainPageViewHolder holder, int i) {
        MainPageData currentData = mainPageDatas.get(i);
        holder.mainCardContentBinding.setMyModel(currentData);
    }

    @Override
    public int getItemCount() {
        return mainPageDatas != null ? mainPageDatas.size() : 0;
    }

    public void setMainPageData(ArrayList<MainPageData> mainPageDatas) {
        this.mainPageDatas = mainPageDatas;
        notifyDataSetChanged();
    }

    class MainPageViewHolder extends RecyclerView.ViewHolder {

        private MainCardContentBinding mainCardContentBinding;

        public MainPageViewHolder(@NonNull MainCardContentBinding mainCardContentBinding) {
            super(mainCardContentBinding.getRoot());
            this.mainCardContentBinding = mainCardContentBinding;
        }
    }

}
