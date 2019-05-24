package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myweather.data.Repository;
import com.example.myweather.data.entities.WeatherDay;
import com.example.myweather.data.entities.WeatherEntity;

import java.util.List;

public class Day5Activity extends AppCompatActivity{

    private static String API_KEY = "3d822b9dce4e57f12b9b3400d480a358";
    private WeatherAdapter weatherAdapter;
    private TextView tempmin;
    private TextView tempmax;
    private TextView wind;
    private TextView pressure;
    private TextView temp;

   List<WeatherEntity> weatherList;
    LiveData<List<WeatherEntity>> weatherData;
    private Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5);

       // repository = new Repository(this);
       //weatherData= repository.getWeatherDataDay();

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        Repository repository = ((WeatherApp)getApplication()).getRepository();
        mainViewModel.loadData(repository);
        weatherData = mainViewModel.getWeatherData();
      //weatherData.observe(this, this);

       // Log.d("Day5",weatherEntities.get(0).dateTime);
        wind = findViewById(R.id.wind);
        pressure = findViewById(R.id.pressure);
        temp = findViewById(R.id.tempreture);
        tempmin = findViewById(R.id.temp_min);
        tempmax = findViewById(R.id.temp_max);
        final RecyclerView recyclerView = findViewById(R.id.weather5_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);


        weatherData.observe(this, new Observer<List<WeatherEntity>>() {
            @Override
            public void onChanged(List<WeatherEntity> weatherEntities) {
                if (weatherData!=null) {
                    weatherAdapter = new WeatherAdapter(weatherData);
                    recyclerView.setAdapter(weatherAdapter);
                }
            }
        });




        //weatherAdapter = new WeatherAdapter(weatherData);
        //        recyclerView.setAdapter(weatherAdapter);



    }
   // @Override
   // public void onChanged(WeatherEntity[] weatherEntities) {
//        if (weather1Day != null) {
//            tempmin.setText("" + (int) (weather1Day.getMain().getTemp_min() - 273));
//            tempmax.setText("" + (int) (weather1Day.getMain().getTemp_max() - 273));
//            temp.setText("" + (int) (weather1Day.getMain().getTemp() - 273));
//            pressure.setText("" + (int) (weather1Day.getMain().getPressure() / 1.33));
//            wind.setText("" + (int) weather1Day.getWind().getSpeed());
//        }
    //}

}
