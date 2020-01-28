package com.bulut.quickly.english.view.grammar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bulut.quickly.R;
import com.bulut.quickly.english.model.grammar.retro._Adjectives;
import com.bulut.quickly.english.util.CallbackMethods;
import com.bulut.quickly.english.util.ResponseType;
import com.bulut.quickly.english.util.impl.APICallBackListener;

import retrofit2.Call;
import retrofit2.Response;


public class GrammarAdjectiveFragment extends Fragment implements APICallBackListener<_Adjectives> {

    public GrammarAdjectiveFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grammar_adjective, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CallbackMethods<_Adjectives> callbackMethods = new CallbackMethods<>(this, ResponseType.ADJECTIVES);
        callbackMethods.callData(1);
    }

    @Override
    public void onResponse(Call<_Adjectives> call, Response<_Adjectives> response) {

    }

    @Override
    public void onFailure(Call<_Adjectives> call, Throwable t) {

    }
}
