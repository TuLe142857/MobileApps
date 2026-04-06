package vn.edu.ptithcm.networkingandroid.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ptithcm.networkingandroid.R;
import vn.edu.ptithcm.networkingandroid.adapter.WeatherAdapter;
import vn.edu.ptithcm.networkingandroid.model.WeatherForecastModel;

public class MainActivity extends AppCompatActivity {

    TextView txtCityName, txtTemperature, txtCityTemperature;
    EditText editTextTextPersonName;
    ImageView imgSearch, imgSeasonForecast;
    ListView lvWeatherForecast;
    List<WeatherForecastModel> weatherForecastModelList;
    WeatherAdapter weatherAdapter;

    private void GetData(String cityName) {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=b26ad635f646454184392417260404&q=" + cityName + "&days=1&aqi=no&alerts=no";

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        Log.d("BBB", url.toString());
        txtCityName.setText(cityName);

        weatherForecastModelList.clear();

        JsonObjectRequest jsonObjectRequest = new
                JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            response.getJSONObject("current").getString("temp_c");
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            String temperature =
                                    response.getJSONObject("current").getString("temp_c");
                            txtTemperature.setText(temperature + "°C");
                            String condition =
                                    response.getJSONObject("current").getJSONObject("condition").getString("text");
                            String conditionicon =
                                    response.getJSONObject("current").getJSONObject("condition").getString("icon");
                            txtCityTemperature.setText(condition);
                            Picasso.get().load("https:" + conditionicon).into(imgSeasonForecast);

                            JSONObject forecastObj =
                                    response.getJSONObject("forecast");
                            JSONObject forecast0 =
                                    forecastObj.getJSONArray("forecastday").getJSONObject(0);
                            JSONArray hourArray =
                                    forecast0.getJSONArray("hour");
                            for (int i = 0; i < hourArray.length(); i++) {
                                JSONObject hourObj =
                                        hourArray.getJSONObject(i);
                                String time = hourObj.getString("time");
                                String temper =
                                        hourObj.getString("temp_c");
                                String img =
                                        hourObj.getJSONObject("condition").getString("icon");
                                String wind =
                                        hourObj.getString("wind_kph");
                                Log.d("AAA", " " + time + " " + temper + " " + img + " " + wind);
                                weatherForecastModelList.add(new WeatherForecastModel(time, temper, img, wind));
                            }
                            weatherAdapter.notifyDataSetChanged();
                            Toast.makeText(MainActivity.this, "" + temperature, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("AAA", "Có lổi xảy ra" + url.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtCityName = findViewById(R.id.txtCityName);
        txtTemperature = findViewById(R.id.txtTemperature);
        txtCityTemperature = findViewById(R.id.txtCityTemperature);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);


        imgSearch = findViewById(R.id.imgSearch);
        imgSeasonForecast = findViewById(R.id.imgSeasonForecast);
        lvWeatherForecast = findViewById(R.id.lvWeatherForecast);
        lvWeatherForecast.setAdapter(weatherAdapter);

        weatherForecastModelList = new ArrayList<>();
        weatherAdapter = new WeatherAdapter(this, weatherForecastModelList);
        lvWeatherForecast.setAdapter(weatherAdapter);
        GetData("Hanoi");

        imgSearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GetData(editTextTextPersonName.getText().toString());
                    }
                }
        );


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}