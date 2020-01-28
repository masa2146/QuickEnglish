package com.bulut.quickly.english.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.CardMainContentBinding;
import com.bulut.quickly.english.adapter.impl.OnItemClickListener;
import com.bulut.quickly.english.model.adapter.MainPageData;

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
        CardMainContentBinding cardMainContentBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_main_content, parent, false);

        return new MainPageViewHolder(cardMainContentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainPageViewHolder holder, int i) {
        holder.cardMainContentBinding.setModel(mainPageData.get(i));
        holder.cardMainContentBinding.setListener(this);
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

        private CardMainContentBinding cardMainContentBinding;

        MainPageViewHolder(@NonNull CardMainContentBinding cardMainContentBinding) {
            super(cardMainContentBinding.getRoot());
            this.cardMainContentBinding = cardMainContentBinding;
        }
    }

}
