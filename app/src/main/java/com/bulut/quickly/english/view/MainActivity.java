package com.bulut.quickly.english.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.ActivityMainBinding;
import com.bulut.quickly.english.adapter.MainPageAdapter;
import com.bulut.quickly.english.constant.PagesNames;
import com.bulut.quickly.english.model.grammar.retro._GrammarBaseModel;
import com.bulut.quickly.english.util.ApiClient;
import com.bulut.quickly.english.util.impl.ApiCalls;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Fatih Bulut
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    ApiCalls apiCalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = binding.rv;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        MainPageAdapter mainPageAdapter = new MainPageAdapter();


        mainPageAdapter.setMainPageData(PagesNames.mainPageDataArray);
        mainPageAdapter.setContext(this);

        recyclerView.setAdapter(mainPageAdapter);

        apiCalls = ApiClient.getClient().create(ApiCalls.class);

        Call<_GrammarBaseModel> call2 = apiCalls.getGrammar("grammar/adjectives", 1);

        call2.enqueue(new Callback<_GrammarBaseModel>() {
            @Override
            public void onResponse(@NonNull Call<_GrammarBaseModel> call, @NonNull Response<_GrammarBaseModel> response) {
                assert response.body() != null;
                System.out.println("NEWSSSSSS ---- RESPONSE gırdıı " + response.body().getContent().get(0).getContext_header());

                // Log.e("ON_RESPONSE", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<_GrammarBaseModel> call, @NonNull Throwable t) {
                // Log.e("HATA_VAR", t.getMessage());
                System.out.println("HATA VAR gırdıı " + t.getMessage());
            }
        });


    }
}
