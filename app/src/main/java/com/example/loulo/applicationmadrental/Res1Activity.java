package com.example.loulo.applicationmadrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.loulo.applicationmadrental.R;

public class Res1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res1);

        String nom = getIntent().getExtras().getString("vehicule_name");
        String image = getIntent().getExtras().getString("vehicule_image");
        int prixjournalierbase = getIntent().getExtras().getInt("vehicule_price");
        String categorieco2 = getIntent().getExtras().getString("vehicule_category");


        TextView tv_nom = findViewById(R.id.r_vehicule_name);
        ImageView iv_image = findViewById(R.id.r_vehicule_image);
        TextView tv_prix = findViewById(R.id.r_vehicule_price);
        TextView tv_categorie = findViewById(R.id.r_vehicule_category);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        tv_nom.setText(nom);
        Glide.with(this).load(image).apply(requestOptions).into(iv_image);
        tv_prix.setText(prixjournalierbase+" € / jour");
        tv_categorie.setText(categorieco2);

    }

}
