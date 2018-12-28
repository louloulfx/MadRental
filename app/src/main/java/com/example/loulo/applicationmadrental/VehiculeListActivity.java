package com.example.loulo.applicationmadrental;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VehiculeListActivity extends AppCompatActivity {

    private final String JSON_URL = "http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Vehicule> listVehicule = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_list);

        listVehicule = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Vehicule vehicule = new Vehicule();
                        vehicule.setNom(jsonObject.getString("nom"));
                        vehicule.setPrixjournalierbase(jsonObject.getInt("prixjournalierbase"));
                        vehicule.setCategorieco2(jsonObject.getString("categorieco2"));
                        vehicule.setPromotion(jsonObject.getInt("promotion"));
                        vehicule.setImage("http://s519716619.onlinehome.fr/exchange/madrental/images/"+jsonObject.getString("image"));
                        listVehicule.add(vehicule);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setuprecyclerview(listVehicule);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(VehiculeListActivity.this);
        requestQueue.add(request);

    }

    private void setuprecyclerview(List<Vehicule> listVehicule) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, listVehicule);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);

    }


}
