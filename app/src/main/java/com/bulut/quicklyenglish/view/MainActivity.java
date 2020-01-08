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
        data.add(new MainPageData(R.drawable.profile_img, "Vocabulary", "Learn vocabulary"));
        data.add(new MainPageData(R.drawable.profile_img, "Grammar", "Learn grammar"));
        data.add(new MainPageData(R.drawable.profile_img, "Speaking", "Learn speaking"));

        mainPageAdapter.setMainPageData(data);

        recyclerView.setAdapter(mainPageAdapter);

    }
}
