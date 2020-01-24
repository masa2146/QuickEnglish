package com.bulut.quicklyenglish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quicklyenglish.R;
import com.bulut.quicklyenglish.adapter.impl.OnItemClickListener;
import com.bulut.quicklyenglish.databinding.MainCardContentBinding;
import com.bulut.quicklyenglish.model.MainPageData;

import java.util.ArrayList;

/**
 * @author fatih
 */

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainPageViewHolder> implements OnItemClickListener {

    private ArrayList<MainPageData> mainPageData;
    private LayoutInflater layoutInflater;
    private Context context;


    public void setMainPageData(ArrayList<MainPageData> mainPageData) {
        this.mainPageData = mainPageData;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public MainPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        MainCardContentBinding mainCardContentBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.main_card_content, parent, false);

        return new MainPageViewHolder(mainCardContentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainPageViewHolder holder, int i) {
        holder.mainCardContentBinding.setMyModel(mainPageData.get(i));
        holder.mainCardContentBinding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return mainPageData != null ? mainPageData.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onItemClick(Object item) {
        System.out.println((((MainPageData) item)).getContentText());
        ((FragmentActivity) context).
                getSupportFragmentManager().
                beginTransaction().
                replace(R.id.container_fragment, (((MainPageData) item)).getFragment(), (((MainPageData) item)).getClass().getSimpleName()).
                addToBackStack(null)
                .commit();
    }

    class MainPageViewHolder extends RecyclerView.ViewHolder {

        private MainCardContentBinding mainCardContentBinding;

        MainPageViewHolder(@NonNull MainCardContentBinding mainCardContentBinding) {
            super(mainCardContentBinding.getRoot());
            this.mainCardContentBinding = mainCardContentBinding;
        }
    }

}
