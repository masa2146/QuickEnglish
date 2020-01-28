package com.bulut.quickly.english.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quickly.R;
import com.bulut.quickly.databinding.ActivityMainBinding;
import com.bulut.quickly.english.adapter.MainPageAdapter;
import com.bulut.quickly.english.model.adapter.MainPageData;
import com.bulut.quickly.english.view.main.MainChatBotFragment;
import com.bulut.quickly.english.view.main.MainGrammarFragment;
import com.bulut.quickly.english.view.main.MainPodcastFragment;
import com.bulut.quickly.english.view.main.MainTranslatorFragment;
import com.bulut.quickly.english.view.main.MainVocabularyFragment;

import java.util.ArrayList;

/**
 * @author fatih
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = binding.rv;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        MainPageAdapter mainPageAdapter = new MainPageAdapter();

        ArrayList<MainPageData> data = new ArrayList<>();
        data.add(new MainPageData(R.drawable.profile_img, "Vocabulary", "Learn vocabulary", new MainVocabularyFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Grammar", "Learn grammar", new MainGrammarFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Listening", "Learn listening", new MainPodcastFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "ChatBot", "Speaking with AI", new MainChatBotFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Translator", "Translate is any word", new MainTranslatorFragment()));


        mainPageAdapter.setMainPageData(data);
        mainPageAdapter.setContext(this);

        recyclerView.setAdapter(mainPageAdapter);



    }
}
