package com.example.loulo.applicationmadrental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Res2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res2);
    }

    public void MainActivity (View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
