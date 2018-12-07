package com.example.loulo.applicationmadrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    Button click;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        click = findViewById(R.id.btn);
        data = (TextView) findViewById(R.id.text_view_result);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data process = new data();
                process.execute();

            }
        });
    }
}
