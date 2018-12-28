package com.example.loulo.applicationmadrental;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    /* TextView tx; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* tx = findViewById(R.id.Main_Title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/RacingSansOne-Regular.ttf");
        tx.setTypeface(custom_font); */

    }


    public void ProfileActivity (View View) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void SearchActivity (View View) {
        startActivity(new Intent(this, SearchActivity.class));
    }

    public void VehiculeListActivity (View view) {
        startActivity(new Intent(this, VehiculeListActivity.class));
    }

}
