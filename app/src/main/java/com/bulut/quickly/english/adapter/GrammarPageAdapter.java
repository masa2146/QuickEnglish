package com.bulut.quickly.english.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.CardGrammarContentBinding;
import com.bulut.quickly.english.adapter.impl.OnItemClickListener;
import com.bulut.quickly.english.model.adapter.GrammarPageData;
import com.bulut.quickly.english.model.adapter.MainPageData;

public class GrammarPageAdapter extends RecyclerView.Adapter<GrammarPageAdapter.GrammarPageViewHolder> implements OnItemClickListener {

    private GrammarPageData[] grammarPageData;
    private LayoutInflater layoutInflater;
    private Context context;

    public void setGrammarPageData(GrammarPageData[] grammarPageData) {
        this.grammarPageData = grammarPageData;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GrammarPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CardGrammarContentBinding cardGrammarContentBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_grammar_content, parent, false);
        return new GrammarPageViewHolder(cardGrammarContentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarPageViewHolder holder, int i) {
        holder.cardGrammarContentBinding.setModel(grammarPageData[i]);
        holder.cardGrammarContentBinding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return grammarPageData != null ? grammarPageData.length : 0;
    }

    @Override
    public void onItemClick(Object item) {
        System.out.println((((GrammarPageData) item)).getContentText());
        //TODO: secilen grammar ile ilgili verileri ilgili urlden cekip sayfada göstermesi gerekiyor.
    }

    class GrammarPageViewHolder extends RecyclerView.ViewHolder {

        private CardGrammarContentBinding cardGrammarContentBinding;

        GrammarPageViewHolder(@NonNull CardGrammarContentBinding cardGrammarContentBinding) {
            super(cardGrammarContentBinding.getRoot());
            this.cardGrammarContentBinding = cardGrammarContentBinding;
        }
    }
}
