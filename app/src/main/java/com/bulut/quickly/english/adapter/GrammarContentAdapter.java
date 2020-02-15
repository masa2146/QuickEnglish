package com.bulut.quickly.english.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.CardGrammarContentBinding;
import com.bulut.quickly.english.adapter.impl.OnItemClickListener;
import com.bulut.quickly.english.model.adapter.GrammarContentData;

public class GrammarContentAdapter extends RecyclerView.Adapter<GrammarContentAdapter.GrammarContentViewHolder> implements OnItemClickListener {

    private GrammarContentData[] grammarContentData;
    private LayoutInflater layoutInflater;
    private Fragment view;

    public void setGrammarContentData(GrammarContentData[] grammarContentData) {
        this.grammarContentData = grammarContentData;
        notifyDataSetChanged();
    }

    public void setMainView(Fragment view) {
        this.view = view;
    }

    @NonNull
    @Override
    public GrammarContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CardGrammarContentBinding cardGrammarContentBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_grammar_content, parent, false);
        return new GrammarContentViewHolder(cardGrammarContentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarContentViewHolder holder, int position) {
        holder.cardGrammarContentBinding.setModel(grammarContentData[position]);
        holder.cardGrammarContentBinding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return grammarContentData.length;
    }

    @Override
    public void onItemClick(Object item) {

    }

    class GrammarContentViewHolder extends RecyclerView.ViewHolder {
        private CardGrammarContentBinding cardGrammarContentBinding;

        public GrammarContentViewHolder(@NonNull CardGrammarContentBinding cardGrammarContentBinding) {
            super(cardGrammarContentBinding.getRoot());
            this.cardGrammarContentBinding = cardGrammarContentBinding;
        }
    }
}
