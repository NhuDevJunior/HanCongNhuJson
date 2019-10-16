package com.vpbank.webapisimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonWebAPI extends AppCompatActivity {
    String weather;
    String json = "{ \"temp\": 289.92, \"pressure\": 1009, \"humidity\": 92, \"temp_min\": 288.71, \"temp_max\": 290.93 }";
    String jsonArray = "[ { \"id\": 300, \"main\": \"Drizzle\", \"description\": \"light intensity drizzle\", \"icon\": \"09d\" }, { \"id\": 200, \"main\": \"Manh\", \"description\": \"light intensity drizzle\", \"icon\": \"09d\" } ]";
    String jsondm="{\"coord\": { \"lon\": 139,\"lat\": 35},\"weather\": [" +
            "{" +
            "\"id\": 800," +
            "\"main\": \"Clear\"," +
            "\"description\": \"clear sky\"," +
            "\"icon\": \"01n\"" +
            "}" +
            "]," +
            "\"base\": \"stations\"," +
            "\"main\": {" +
            "\"temp\": 289.92," +
            "\"pressure\": 1009," +
            "\"humidity\": 92," +
            "\"temp_min\": 288.71," +
            "\"temp_max\": 290.93" +
            "}," +
            "\"wind\": {" +
            "\"speed\": 0.47," +
            "\"deg\": 107.538" +
            "}," +
            "\"clouds\": {" +
            "\"all\": 2" +
            "}," +
            "\"dt\": 1560350192," +
            "\"sys\": {" +
            "\"type\": 3," +
            "\"id\": 2019346," +
            "\"message\": 0.0065," +
            "\"country\": \"JP\"," +
            "\"sunrise\": 1560281377," +
            "\"sunset\": 1560333478" +
            "}," +
            "\"timezone\": 32400," +
            "\"id\": 1851632," +
            "\"name\": \"Shuzenji\"," +
            "\"cod\": 200" +
            "}";
    TextView tvJson;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_web_api);
        tvJson = findViewById(R.id.tvJson);


       getJson();



    }

    private void getJson() {
        try {

            JSONObject jsonObject = new JSONObject(jsondm);

            //String coord = jsonObject.getString("coord");
            JSONObject coord=jsonObject.getJSONObject("coord");
            int lon=coord.getInt("lon");
            int lat=coord.getInt("lat");


            weather = jsonObject.getString("weather");




            String base = jsonObject.getString("base");



            JSONObject main=jsonObject.getJSONObject("main");
            double temp=main.getDouble("temp");
            int pressure=main.getInt("pressure");
            int humidity=main.getInt("humidity");
            double temp_min=main.getDouble("temp_min");
            double temp_max=main.getDouble("temp_max");


            JSONObject wind=jsonObject.getJSONObject("wind");
            double speed=wind.getDouble("speed");
            double deg=wind.getDouble("deg");




            JSONObject clouds=jsonObject.getJSONObject("clouds");
            int all=clouds.getInt("all");



            JSONObject sys=jsonObject.getJSONObject("sys");
            int type=sys.getInt("type");
            String id=sys.getString("id");
            String message=sys.getString("message");
            String sunset=sys.getString("sunset");
            String sunrise=sys.getString("sunrise");

            String name = jsonObject.getString("name");

            int dt=jsonObject.getInt("dt");

            String timezone = jsonObject.getString("timezone");

            String id1 = jsonObject.getString("id");

            int cod=jsonObject.getInt("cod");
           tvJson.setText(id + "\n" + weather + "\n" + pressure + "\n" + temp_max + "\n" + speed);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonArray() {
        try {
            JSONArray jArray = new JSONArray(weather);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String main = jsonObject.getString("main");
                String des = jsonObject.getString("description");
                String icon = jsonObject.getString("icon");

                result += "\nid: " + id + " main: " + main + " des: " +
                        des + " icon: " + icon;
            }
            tvJson.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
