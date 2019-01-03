package com.example.loulo.applicationmadrental;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

   private static final String TAG = "MainActivity";
   private TextView mDisplayDate;
    private TextView mDisplayDate1;
   private DatePickerDialog.OnDateSetListener mDateSetListenerStart;
   private DatePickerDialog.OnDateSetListener getmDateSetListenerEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* tx = findViewById(R.id.Main_Title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/RacingSansOne-Regular.ttf");
        tx.setTypeface(custom_font); */

        mDisplayDate = (TextView) findViewById(R.id.Start_Date);
        mDisplayDate1 = (TextView) findViewById(R.id.End_Date);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListenerStart, day, month, year);
                // Choisir une date seulement à partir du jour actuel
                dialog.getDatePicker().setMinDate(new Date().getTime());
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, getmDateSetListenerEnd, day, month, year);
                // Choisir une date seulement à partir du jour actuel
                dialog.getDatePicker().setMinDate(new Date().getTime());
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListenerStart = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Janvier commence à 0 donc on ajoute 1 au mois pour que ça convienne lors de l'affichage
                month += 1;
                //Concaténation des valeur pour obtenir une date
                String startDate = dayOfMonth + "/" + month + "/" + year;
                // Ajout de la date au TextView Start_Date
                mDisplayDate.setText(startDate);
            }
        };

        getmDateSetListenerEnd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Janvier commence à 0 donc on ajoute 1 au mois pour que ça convienne lors de l'affichage
                month += 1;
                //Concaténation des valeur pour obtenir une date
                String endDate = dayOfMonth + "/" + month + "/" + year;
                // Ajout de la date au TextView End_Date
                mDisplayDate1.setText(endDate);
            }
        };

    }

    // LAUNCH THE ACTIVITY WITH THE PROFILE ACCOUNT OF THE USER
    public void ProfileActivity (View View) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    // LAUNCH THE ACTIVITY WITH ALL THE VEHICULES AVAILABLE
    public void VehiculeListActivity (View view) {
        startActivity(new Intent(this, VehiculeListActivity.class));
    }

}