package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myweather.data.RemoteDataSource;
import com.example.myweather.data.Repository;
import com.example.myweather.data.entities.WeatherDay;
import com.example.myweather.data.entities.WeatherEntity;
import com.example.myweather.data.entities.WeatherForecast;

import java.util.List;

public class Activityday1 extends AppCompatActivity {

    private static String API_KEY = "3d822b9dce4e57f12b9b3400d480a358";
    private WeatherAdapter weatherAdapter;
    private TextView tempmin;
    private TextView tempmax;
    private TextView wind;
    private TextView pressure;
    private TextView temp;

    private RemoteDataSource remoteDataSource;

    List<WeatherEntity> weatherList;
    WeatherEntity we;
    LiveData<WeatherEntity> weatherData;
    private Repository repository;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1);
        wind = findViewById(R.id.wind);
        pressure = findViewById(R.id.pressure);
        temp = findViewById(R.id.tempreture);
        tempmin = findViewById(R.id.temp_min);
        tempmax = findViewById(R.id.temp_max);
        repository = new Repository(this);

        weatherData= repository.getOneDayWeatherData();


        weatherData.observe(this, new Observer<WeatherEntity>() {
            @Override
            public void onChanged(WeatherEntity weatherEntity) {
                if (weatherEntity != null) {
                    wind.setText(String.valueOf(weatherEntity.wind));
                    pressure.setText(String.valueOf((int) (weatherEntity.pressure / 1.33)));
                    temp.setText(String.valueOf((int) (weatherEntity.temp - 273)));
                    tempmin.setText(String.valueOf((int) (weatherEntity.tempMin - 273)));
                    tempmax.setText(String.valueOf((int) (weatherEntity.tempMax - 273)));

                }
            }
        });

    }


}