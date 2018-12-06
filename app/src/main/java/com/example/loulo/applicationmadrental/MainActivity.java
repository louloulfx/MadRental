package com.example.loulo.applicationmadrental;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tx = (TextView)findViewById(R.id.Main_Title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/RacingSansOne-Regular.ttf");
        tx.setTypeface(custom_font);
    }

}
