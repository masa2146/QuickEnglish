package com.bulut.quickly.english.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.CardGrammarPageBinding;
import com.bulut.quickly.english.adapter.impl.OnItemClickListener;
import com.bulut.quickly.english.constant.ResponseType;
import com.bulut.quickly.english.model.adapter.GrammarPageData;
import com.bulut.quickly.english.view.main.MainGrammarFragment;

public class GrammarPageAdapter extends RecyclerView.Adapter<GrammarPageAdapter.GrammarPageViewHolder> implements OnItemClickListener {

    private GrammarPageData[] grammarPageData;
    private LayoutInflater layoutInflater;
    private Fragment view;

    public void setGrammarPageData(GrammarPageData[] grammarPageData) {
        this.grammarPageData = grammarPageData;
        notifyDataSetChanged();
    }

    public void setMainView(Fragment view) {
        this.view = view;
    }

    @NonNull
    @Override
    public GrammarPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CardGrammarPageBinding cardGrammarPageBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_grammar_page, parent, false);
        return new GrammarPageViewHolder(cardGrammarPageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarPageViewHolder holder, int i) {
        holder.cardGrammarPageBinding.setModel(grammarPageData[i]);
        holder.cardGrammarPageBinding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return grammarPageData != null ? grammarPageData.length : 0;
    }

    @Override
    public void onItemClick(Object item) {
        GrammarPageData grammarPageData = (GrammarPageData) item;
        ((MainGrammarFragment) view).getDataByGrammarType(ResponseType.GRAMMAR, grammarPageData.getGrammarType(), 1);
    }

    class GrammarPageViewHolder extends RecyclerView.ViewHolder {

        private CardGrammarPageBinding cardGrammarPageBinding;

        GrammarPageViewHolder(@NonNull CardGrammarPageBinding cardGrammarPageBinding) {
            super(cardGrammarPageBinding.getRoot());
            this.cardGrammarPageBinding = cardGrammarPageBinding;
        }
    }
}
