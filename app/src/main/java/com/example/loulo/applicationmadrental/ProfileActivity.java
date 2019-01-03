package com.example.loulo.applicationmadrental;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {
    private EditText editText;
    private Button profileButton;
    private EditText editText1;
    private TextView TextView2;

    private static final String TAG = "ProfileActivity";
    private TextView mDateBirth;
    private DatePickerDialog.OnDateSetListener mDateSetListenerBirth;

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
        TextView2 = (TextView) findViewById(R.id.profile_edit_text_3);
        profileButton = (Button) findViewById(R.id.profile_button);

        mDateBirth = (TextView) findViewById(R.id.profile_edit_text_3);

        mDateBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(ProfileActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListenerBirth, day, month, year);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListenerBirth = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Janvier commence à 0 donc on ajoute 1 au mois pour que ça convienne lors de l'affichage
                month += 1;
                //Concaténation des valeur pour obtenir une date
                String birthDate = dayOfMonth + "/" + month + "/" + year;
                // Ajout de la date au TextView profile_edit_text_3
                mDateBirth.setText(birthDate);
            }
        };

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
        editor.putString(TEXT2, TextView2.getText().toString());
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
        TextView2.setText(text2);

    }


}
