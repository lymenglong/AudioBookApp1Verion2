package com.lymenglong.laptop.audiobookapp1verion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lymenglong.laptop.audiobookapp1verion2.customize.CustomActionBar;


public class ViewReading extends AppCompatActivity{
    private TextView tvReading;
    private String titleChapter, detailReadingHtml, detailReading;
    private CustomActionBar actionBar;
    private ScrollView scrollView;
    private final DisplayMetrics dm = new DisplayMetrics();
    int offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reading);
        getDataFromIntent();
        init();
    }

    /**
     * Lấy dữ liệu từ intent
     */
    private void getDataFromIntent() {
        titleChapter = getIntent().getStringExtra("titleChapter");
        detailReadingHtml = getIntent().getStringExtra("content");
        offset = getIntent().getIntExtra("offset", -1);
    }

    private void init() {
        actionBar = new CustomActionBar();
        detailReading = String.valueOf(Html.fromHtml(detailReadingHtml));
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        actionBar.eventToolbar(this, titleChapter, false);

        tvReading = (TextView) findViewById(R.id.tvDetailReading);
        tvReading.setText(detailReading);
        Log.d("scroll", String.valueOf(scrollView.getChildAt(0).getHeight()));
        Log.d("heightText", String.valueOf(getTextHeight(tvReading)) + " and " + String.valueOf(getScreenHeight())
                + " num " + String.valueOf(numPage(getTextHeight(tvReading), getScreenHeight() - 480)));

    }

    /**
     * Lấy độ cao của textview
     *
     * @param text
     * @return
     */
    private int getTextHeight(TextView text) {
        text.measure(0, 0);
        return text.getMeasuredHeight();
    }

    /**
     * Lấy độ cao của màn hình thiết bị
     *
     * @return
     */
    private int getScreenHeight() {
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * Lấy chiều rộng của thiết bị
     *
     * @return
     */
    private int getScreenWidth() {
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * Số trang của văn bản
     *
     * @param textHeight   chiều cao textview
     * @param screenHeight chiều cao màn hình
     * @return mỗi màn hình là 1 trang, dựa vào height xác định số trang của văn bản
     */
    private int numPage(int textHeight, int screenHeight) {
        int num = 0;
        num = textHeight / screenHeight;
        if (textHeight > screenHeight * num) {
            num += 1;
        }
        return num;
    }

}
