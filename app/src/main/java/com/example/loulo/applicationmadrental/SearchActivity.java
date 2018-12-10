package com.example.loulo.applicationmadrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    public static TextView data;
    public static ImageView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        data = (TextView) findViewById(R.id.text_view_result);
        /* dataView = (ImageView) findViewById(R.id.img_view_result); */
        
        data process = new data();
        process.execute();

    }
}

