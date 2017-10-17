package com.lymenglong.laptop.audiobookapp1verion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lymenglong.laptop.audiobookapp1verion2.adapter.HomeAdapter;
import com.lymenglong.laptop.audiobookapp1verion2.databases.DatabaseHelper;
import com.lymenglong.laptop.audiobookapp1verion2.model.Home;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView homeList;
    private ArrayList<Home> homes;
    private HomeAdapter homeAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        homeList = (RecyclerView) findViewById(R.id.listView);
        databaseHelper = new DatabaseHelper(this);
        homes = databaseHelper.getHomeList();

        homeAdapter = new HomeAdapter(MainActivity.this, homes);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        homeList.setLayoutManager(mLinearLayoutManager);
        homeList.setAdapter(homeAdapter);
    }
}
