package com.example.loulo.applicationmadrental;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private EditText editText;
    private Button profileButton;
    private EditText editText1;
    private EditText editText2;

    private String text;
    private String text1;
    private String text2;


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String TEXT1 = "text1";
    public static final String TEXT2 = "text2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editText = (EditText) findViewById(R.id.profile_edit_text_1);
        editText1 = (EditText) findViewById(R.id.profile_edit_text_2);
        editText2 = (EditText) findViewById(R.id.profile_edit_text_3);
        profileButton = (Button) findViewById(R.id.profile_button);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent1);

                saveData();

            }
        });

        loadData();
        updateView();

    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, editText.getText().toString());
        editor.putString(TEXT1, editText1.getText().toString());
        editor.putString(TEXT2, editText2.getText().toString());
        editor.apply();


    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        text1 = sharedPreferences.getString(TEXT1, "");
        text2 = sharedPreferences.getString(TEXT2, "");


    }

    public void updateView() {
        editText.setText(text);
        editText1.setText(text1);
        editText2.setText(text2);

    }


}
