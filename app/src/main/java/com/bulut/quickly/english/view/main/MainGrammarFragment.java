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
import com.bulut.quickly.english.adapter.GrammarContentAdapter;
import com.bulut.quickly.english.adapter.GrammarPageAdapter;
import com.bulut.quickly.english.constant.GrammarType;
import com.bulut.quickly.english.constant.PagesNames;
import com.bulut.quickly.english.constant.ResponseType;
import com.bulut.quickly.english.model.adapter.GrammarContentData;
import com.bulut.quickly.english.model.grammar.GrammarBaseModel;
import com.bulut.quickly.english.model.grammar.retro._GrammarBaseModel;
import com.bulut.quickly.english.util.CallbackMethods;
import com.bulut.quickly.english.util.impl.APICallBackListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author Fatih Bulut
 * */
public class MainGrammarFragment extends Fragment implements APICallBackListener<_GrammarBaseModel> {

    private View view;
    private RecyclerView recyclerView;
    private FragmentMainGrammarBinding binding;
    private CallbackMethods<_GrammarBaseModel> callbackMethods;
    private ArrayList<GrammarContentData> contentData;

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

    private void init() {

        contentData = new ArrayList<>();

        //noinspection unchecked
        callbackMethods = new CallbackMethods(this);

        recyclerView = binding.mainGrammar;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(true);

        initHomePage();
    }

    private void initHomePage() {
        GrammarPageAdapter grammarPageAdapter = new GrammarPageAdapter();
        grammarPageAdapter.setMainView(this);
        grammarPageAdapter.setGrammarPageData(PagesNames.grammarPageDataArray);

        recyclerView.setAdapter(grammarPageAdapter);
    }

    public void getDataByGrammarType(ResponseType responseType, GrammarType grammarType, int page) {
        String tempUrl = "";
        switch (grammarType) {
            case ADJECTIVES:
                tempUrl = PagesNames.GRAMMAR_ADJECTIVES_WITH_PAGE;
                break;
            case ADVERBS:
                tempUrl = PagesNames.GRAMMAR_ADVERBS_WITH_PAGE;
                break;
            case NOUNS:
                tempUrl = PagesNames.GRAMMAR_NOUNS_WITH_PAGE;
                break;
            case PREPOSITIONS:
                tempUrl = PagesNames.GRAMMAR_PREPOSTIONS_WITH_PAGE;
                break;
            case PRONOUNS:
                tempUrl = PagesNames.GRAMMAR_PRONOUNS_WITH_PAGE;
                break;
            case VERBS:
                tempUrl = PagesNames.GRAMMAR_VERBS_WITH_PAGE;
                break;
        }
        callbackMethods.callData(responseType, "grammar/" + tempUrl, page);
    }

    @Override
    public void onResponse(Call<_GrammarBaseModel> call, Response<_GrammarBaseModel> response) {
        assert response.body() != null;
        convertToContentDataFromBaseModel(response.body().getContent());
        this.setContentDataToAdapter();
    }

    @Override
    public void onFailure(Call<_GrammarBaseModel> call, Throwable t) {
        System.out.println("GRAMMAR HATASI VAR " + t.getMessage());
    }

    private void convertToContentDataFromBaseModel(List<GrammarBaseModel> baseModels) {
        for (GrammarBaseModel model : baseModels) {
            this.contentData.add(new GrammarContentData(R.drawable.profile_img, model.getContext_header(), model.getContext_text()));
            System.out.println("MODELLER " + model.getContext_header());
        }
    }

    private void setContentDataToAdapter() {
        GrammarContentAdapter grammarContentAdapter = new GrammarContentAdapter();
        grammarContentAdapter.setMainView(this);
        grammarContentAdapter.setGrammarContentData(this.contentData.toArray(new GrammarContentData[contentData.size()]));

        recyclerView.setAdapter(grammarContentAdapter);
    }
}
