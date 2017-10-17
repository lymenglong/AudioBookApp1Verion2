package com.lymenglong.laptop.audiobookapp1verion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.lymenglong.laptop.audiobookapp1verion2.adapter.AllChapterAdapter;
import com.lymenglong.laptop.audiobookapp1verion2.adapter.ChapterAdapter;
import com.lymenglong.laptop.audiobookapp1verion2.customize.CustomActionBar;
import com.lymenglong.laptop.audiobookapp1verion2.databases.DatabaseHelper;
import com.lymenglong.laptop.audiobookapp1verion2.model.Chapter;

import java.util.ArrayList;

public class ListALLChapter extends AppCompatActivity{
    private RecyclerView listChapter;
    private ArrayList<Chapter> chapters;
    private AllChapterAdapter adapter;
    private CustomActionBar actionBar;
    private DatabaseHelper databaseHelper;
    private String titleChapter;
    private int idChapter;
    private TextView tvStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chapter);
        getDataFromIntent();
        init();
    }

    /**
     * Lấy dữ liệu thông qua intent
     */
    private void getDataFromIntent() {
        titleChapter = getIntent().getStringExtra("titleChapter");
        idChapter = getIntent().getIntExtra("idChapter", -1);
    }

    /**
     * Khai báo các view và khởi tạo giá trị
     */
    private void init() {
        actionBar = new CustomActionBar();
        actionBar.eventToolbar(this, titleChapter, true);
        listChapter = (RecyclerView) findViewById(R.id.list_chapter);

        databaseHelper = new DatabaseHelper(this);
        chapters = databaseHelper.getListAllChapter(idChapter);
        adapter = new AllChapterAdapter(ListALLChapter.this, chapters);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        listChapter.setLayoutManager(mLinearLayoutManager);
        listChapter.setAdapter(adapter);

    }
}
