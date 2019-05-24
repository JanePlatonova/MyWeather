package com.example.myweather;

import android.content.Context;

import com.example.myweather.data.Repository;
import com.example.myweather.data.entities.WeatherDay;
import com.example.myweather.data.entities.WeatherEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MainViewModel(){}
    private Repository repository;
    private LiveData<List<WeatherEntity>> weatherData;

    public void loadData(Repository repository){
        if(weatherData == null){
            this.repository = repository;
            weatherData = repository.getWeatherDataDay();
        }
    }

    public LiveData<List<WeatherEntity>> getWeatherData(){
        return weatherData;
    }
}
