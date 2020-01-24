package com.bulut.quicklyenglish.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bulut.quicklyenglish.R;
import com.bulut.quicklyenglish.adapter.MainPageAdapter;
import com.bulut.quicklyenglish.databinding.ActivityMainBinding;
import com.bulut.quicklyenglish.model.MainPageData;
import com.bulut.quicklyenglish.view.fragments.ChatBotFragment;
import com.bulut.quicklyenglish.view.fragments.GrammarFragment;
import com.bulut.quicklyenglish.view.fragments.ListeningFragment;
import com.bulut.quicklyenglish.view.fragments.TranslatorFragment;
import com.bulut.quicklyenglish.view.fragments.VocabularyFragment;

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
        data.add(new MainPageData(R.drawable.profile_img, "Vocabulary", "Learn vocabulary", new VocabularyFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Grammar", "Learn grammar", new GrammarFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Listening", "Learn listening", new ListeningFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "ChatBot", "Speaking with AI", new ChatBotFragment()));
        data.add(new MainPageData(R.drawable.profile_img, "Translator", "Translate is any word", new TranslatorFragment()));


        mainPageAdapter.setMainPageData(data);
        mainPageAdapter.setContext(this);

        recyclerView.setAdapter(mainPageAdapter);


    }
}
