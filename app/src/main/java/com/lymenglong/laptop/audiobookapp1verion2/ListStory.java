package com.lymenglong.laptop.audiobookapp1verion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lymenglong.laptop.audiobookapp1verion2.adapter.StoryAdapter;
import com.lymenglong.laptop.audiobookapp1verion2.databases.DatabaseHelper;
import com.lymenglong.laptop.audiobookapp1verion2.model.Story;

import java.util.ArrayList;


public class ListStory extends AppCompatActivity {
    private RecyclerView listStory;
    private ArrayList<Story> stories;
    private StoryAdapter adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        listStory = (RecyclerView) findViewById(R.id.listView);
        databaseHelper = new DatabaseHelper(this);
        stories = databaseHelper.getListStory();

        adapter = new StoryAdapter(this, stories);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        listStory.setLayoutManager(mLinearLayoutManager);
        listStory.setAdapter(adapter);
    }
}
