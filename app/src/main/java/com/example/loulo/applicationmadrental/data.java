package com.example.loulo.applicationmadrental;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class data extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    String secondParsed = "";
    String promoParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for (int  i =0; i < JA.length(); i++) {

                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  JO.get("nom") + "\n"
                        + JO.get("prixjournalierbase") + " € / jour" + "\n"
                        + "Catégorie CO2 : "+ JO.get("categorieco2") + "\n";
                promoParsed = "Promotion : " + JO.get("promotion") + "%" + "\n";

                dataParsed = dataParsed + singleParsed + promoParsed + "\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        SearchActivity.data.setText(this.dataParsed);
    }
}
