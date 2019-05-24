package com.example.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myweather.data.WeatherService;
import com.example.myweather.data.entities.WeatherDay;
import com.example.myweather.data.entities.WeatherEntity;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class MainActivity extends AppCompatActivity implements Observer<List<WeatherEntity>>, View.OnClickListener {
    private static String API_KEY = "3d822b9dce4e57f12b9b3400d480a358";
    private WeatherAdapter weatherAdapter;
    private TextView tempmin;
    private TextView tempmax;
    private TextView wind;
    private TextView pressure;
    private TextView temp;

//    LiveData<WeatherEntity> weatherEntities;
    private LiveData<List<WeatherEntity>> weatherData;


    Button btn5DaysForecast;
    Button btnOneDayWeather;


    @Override
    public void onChanged(List<WeatherEntity> weatherList) {
//        if(weatherEntities != null) {
//            tempmin.setText("" + (int) (weatherEntities[0].tempMin - 273));
//            tempmax.setText("" + (int) (weatherEntities[0].tempMax - 273));
//            temp.setText("" + (int) (weatherEntities[0].temp - 273));
//            pressure.setText("" + (int) (weatherEntities[0].pressure / 1.33));
//            wind.setText("" + (int) weatherEntities[0].wind);
//        }
    }

//    @Override
//    public void onChanged(WeatherEntity[] weatherEntities) {
//        if (weather1Day != null) {
//            tempmin.setText("" + (int) (weather1Day.getMain().getTemp_min() - 273));
//            tempmax.setText("" + (int) (weather1Day.getMain().getTemp_max() - 273));
//            temp.setText("" + (int) (weather1Day.getMain().getTemp() - 273));
//            pressure.setText("" + (int) (weather1Day.getMain().getPressure() / 1.33));
//            wind.setText("" + (int) weather1Day.getWind().getSpeed());
//        }
   // }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn5DaysForecast=(Button)findViewById(R.id.forecast_btn);
        btn5DaysForecast.setOnClickListener(this);
        btnOneDayWeather=(Button)findViewById(R.id.weather_btn);
        btnOneDayWeather.setOnClickListener(this);
//        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//        mainViewModel.loadData(this);
//        weatherData = mainViewModel.getWeatherData();
//        weatherData.observe(this, this);



       // weatherEntities= repository.getWeatherDataDay();

        wind = findViewById(R.id.wind);
        pressure = findViewById(R.id.pressure);
        temp = findViewById(R.id.tempreture);
        tempmin = findViewById(R.id.temp_min);
        tempmax = findViewById(R.id.temp_max);

       // weatherEntities.observe(this, this);

//        final RecyclerView recyclerView = findViewById(R.id.rec_list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
//                RecyclerView.VERTICAL,
//                false);
//        recyclerView.setLayoutManager(layoutManager);

        WeatherService weatherService;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherService = retrofit.create(WeatherService.class);


       weatherService.getWeatherByCityName("Kiev,ua", "3d822b9dce4e57f12b9b3400d480a358")
                .enqueue(new Callback<WeatherDay>() {
                    @Override
                    public void onResponse(Call<WeatherDay> call, Response<WeatherDay> response) {
                        if (response.isSuccessful()) {
                            WeatherDay weatherDay = response.body();
                            wind.setText(String.valueOf(weatherDay.getWind().getSpeed()));
                           pressure.setText(String.valueOf((int)(weatherDay.getMain().getPressure()/1.33)));
                            temp.setText(String.valueOf((int)(weatherDay.getMain().getTemp()-273)));
                            tempmin.setText(String.valueOf((int)(weatherDay.getMain().getTemp_min()-273)));
                            tempmax.setText(String.valueOf((int)(weatherDay.getMain().getTemp_max()-273)));
                            Log.e("Main", "Wind speed" + weatherDay.getWind().getSpeed());
                        } else {

                            Log.e("Main", "NOt success: " + response.code() +
                                    " " + response.raw().request().url().toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<WeatherDay> call, Throwable t) {
                        Log.e("Main", "Exception: " + t.toString() );
                    }

                });
    }

//    public interface WeatherService1 {
//        @GET("/data/2.5/weather")
//        Call<WeatherDay> getWeatherByCityName(@Query("q") String city, @Query("appid") String appID);
//    }

//        weatherService.getWeatherByCityName("London", "3d822b9dce4e57f12b9b3400d480a358")
//        .enqueue(new Callback<WeatherForecast>() {
//        @Override
//        public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
//            if (response.isSuccessful()) {
//                WeatherForecast weatherForecast = response.body();
//                Log.d("Main", "OK");
//                Log.d("Main", String.valueOf(weatherForecast.getItems().size()));
//
//                String[][] weatherList1=new String[weatherForecast.getItems().size()][4];
//                int i=0;
//
//                Log.d("item 0", String.valueOf(weatherForecast.getItems().get(0).getDt_txt()));
//                final List<WeatherEntity> weatherList = new ArrayList<>();
//                for (ForecastDay day : weatherForecast.getItems()) {
//                    Log.d("Main", String.valueOf(day.getDt_txt()));
//                    Log.d("temp", String.valueOf(day.getMain().getTemp()));
//                    final WeatherEntity weatherEntity = new WeatherEntity();
//                    weatherEntity.tempMin = day.getMain().getTemp_min();
//                    weatherEntity.tempMax = day.getMain().getTemp_max();
//                    weatherEntity.temp=day.getMain().getTemp();
//                    weatherEntity.pressure=day.getMain().getPressure();
//                    weatherEntity.wind=day.getWind().getSpeed();
//                    weatherEntity.dateTime=day.getDt_txt();
//                    weatherList.add(weatherEntity);
//                }
//
//                //weatherAdapter = new WeatherAdapter(weatherList);
//                //recyclerView.setAdapter(weatherAdapter);
//
//
//
//
//
//                //                weatherAdapter = new WeatherAdapter(weatherForecast);
////                recyclerView.setAdapter(weatherAdapter);
//                //weatherAdapter = new WeatherAdapter(weatherList);
//                //recyclerView.setAdapter(weatherAdapter);
//
//            } else {
//                Log.e("Main", "NOt success: " + response.code() +
//                        " " + response.raw().request().url().toString());
//            }
//        }
//        @Override
//        public void onFailure(Call<WeatherForecast> call, Throwable t) {
//            Log.e("Main", "Exception: " + t.toString() );
//        }
//
//    });



    @Override
    public void onClick(View v) {
        Button btnforecast=findViewById(R.id.forecast_btn);
        Button btnweather=findViewById(R.id.weather_btn);
        if (v == (View) btnforecast) {
            Log.d("запуск"," первого");
            Intent intent = new Intent(this, Day5Activity.class);
            startActivity(intent);
        }
        if (v==(View)btnweather){
            Intent intent = new Intent(this, Activityday1.class);
            startActivity(intent);
            Log.d("запуск","второго");
        }
        Log.d("пишем","в лог");

    }


}