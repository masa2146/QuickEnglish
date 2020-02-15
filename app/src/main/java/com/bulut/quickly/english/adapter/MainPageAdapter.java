package com.bulut.quickly.english.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.CardMainPageBinding;
import com.bulut.quickly.english.adapter.impl.OnItemClickListener;
import com.bulut.quickly.english.model.adapter.MainPageData;

/**
 * @author Fatih Bulut
 */

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainPageViewHolder> implements OnItemClickListener {

    private MainPageData[] mainPageData;
    private LayoutInflater layoutInflater;
    private Context context;


    public void setMainPageData(MainPageData[] mainPageData) {
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
        CardMainPageBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_main_page, parent, false);

        return new MainPageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainPageViewHolder holder, int i) {
        holder.binding.setModel(mainPageData[i]);
        holder.binding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return mainPageData != null ? mainPageData.length : 0;
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

        private CardMainPageBinding binding;

        MainPageViewHolder(@NonNull CardMainPageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
