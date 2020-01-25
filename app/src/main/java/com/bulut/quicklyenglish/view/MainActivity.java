package com.bulut.quicklyenglish.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quicklyenglish.R;
import com.bulut.quicklyenglish.adapter.MainPageAdapter;
import com.bulut.quicklyenglish.databinding.ActivityMainBinding;
import com.bulut.quicklyenglish.model.MainPageData;
import com.bulut.quicklyenglish.model.grammar.retro._Adjectives;
import com.bulut.quicklyenglish.model.news.retro._News;
import com.bulut.quicklyenglish.model.podcast.retro._PodcastL1;
import com.bulut.quicklyenglish.util.ApiCalls;
import com.bulut.quicklyenglish.util.ApiClient;
import com.bulut.quicklyenglish.view.fragments.ChatBotFragment;
import com.bulut.quicklyenglish.view.fragments.GrammarFragment;
import com.bulut.quicklyenglish.view.fragments.ListeningFragment;
import com.bulut.quicklyenglish.view.fragments.TranslatorFragment;
import com.bulut.quicklyenglish.view.fragments.VocabularyFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author fatih
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

        ArrayList<MainPageData> data = new ArrayList<>();
        data.add(new MainPageData(R.drawable.profile_img, "Vocabulary", "Learn vocabulary", new VocabularyFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Grammar", "Learn grammar", new GrammarFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Listening", "Learn listening", new ListeningFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "ChatBot", "Speaking with AI", new ChatBotFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Translator", "Translate is any word", new TranslatorFragment()));


        mainPageAdapter.setMainPageData(data);
        mainPageAdapter.setContext(this);

        recyclerView.setAdapter(mainPageAdapter);

        apiCalls = ApiClient.getClient().create(ApiCalls.class);
        Call<_Adjectives> call = apiCalls.getAdjectives(1);

        call.enqueue(new Callback<_Adjectives>() {
            @Override
            public void onResponse(@NonNull Call<_Adjectives> call, @NonNull Response<_Adjectives> response) {
                assert response.body() != null;
                // System.out.println("RESPONSE gırdıı "+response.body().getContent().get(0).getContext_header());

                // Log.e("ON_RESPONSE",response.message());
            }

            @Override
            public void onFailure(@NonNull Call<_Adjectives> call, @NonNull Throwable t) {
                // Log.e("HATA_VAR",t.getMessage());
                //System.out.println("HATA VAR gırdıı");
            }
        });


        Call<_News> call2 = apiCalls.getNews(1);

        call2.enqueue(new Callback<_News>() {
            @Override
            public void onResponse(@NonNull Call<_News> call, @NonNull Response<_News> response) {
                assert response.body() != null;
               // System.out.println("NEWSSSSSS ---- RESPONSE gırdıı " + response.body().getContent().get(0).getLevel_1().get(0).getTitle());

               // Log.e("ON_RESPONSE", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<_News> call, @NonNull Throwable t) {
               // Log.e("HATA_VAR", t.getMessage());
                //System.out.println("HATA VAR gırdıı");
            }
        });


        Call<_PodcastL1> call3 = apiCalls.getPodcastL1(1);

        call3.enqueue(new Callback<_PodcastL1>() {
            @Override
            public void onResponse(@NonNull Call<_PodcastL1> call, @NonNull Response<_PodcastL1> response) {
                assert response.body() != null;
                System.out.println("PODCASSTTT ---- RESPONSE gırdıı " + response.body().getContent().get(0).getTitle());

                Log.e("ON_RESPONSE", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<_PodcastL1> call, @NonNull Throwable t) {
                Log.e("HATA_VAR", t.getMessage());
                System.out.println("HATA VAR gırdıı");
            }
        });


    }
}
