package com.bulut.quickly.english.view.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.FragmentMainGrammarBinding;
import com.bulut.quickly.english.adapter.GrammarPageAdapter;
import com.bulut.quickly.english.constant.PagesNames;
import com.bulut.quickly.english.constant.ResponseType;
import com.bulut.quickly.english.model.grammar.retro._GrammarBaseModel;
import com.bulut.quickly.english.util.CallbackMethods;
import com.bulut.quickly.english.util.impl.APICallBackListener;

import retrofit2.Call;
import retrofit2.Response;

public class MainGrammarFragment extends Fragment implements APICallBackListener<_GrammarBaseModel> {

    private View view;
    private FragmentMainGrammarBinding binding;

    public MainGrammarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_grammar, container, false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @SuppressWarnings("unchecked")
    private void selectPage(ResponseType responseType, int page) {
        CallbackMethods callbackMethods = new CallbackMethods(this, responseType);
        callbackMethods.callData(PagesNames.GRAMMAR_ADJECTIVES_WITH_PAGE, page);
    }

    @Override
    public void onResponse(Call<_GrammarBaseModel> call, Response<_GrammarBaseModel> response) {

    }

    @Override
    public void onFailure(Call<_GrammarBaseModel> call, Throwable t) {

    }

    private void init() {
        RecyclerView recyclerView = binding.mainGrammar;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(true);

        GrammarPageAdapter grammarPageAdapter = new GrammarPageAdapter();
        grammarPageAdapter.setContext(view.getContext());
        grammarPageAdapter.setGrammarPageData(PagesNames.grammarPageDataArray);

        recyclerView.setAdapter(grammarPageAdapter);
    }
}
