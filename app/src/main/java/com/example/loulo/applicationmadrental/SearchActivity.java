package com.example.loulo.applicationmadrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SearchActivity extends AppCompatActivity {

    public static TextView data;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        data = (TextView) findViewById(R.id.text_view_result);

        data process = new data();
        process.execute();



    }

}


