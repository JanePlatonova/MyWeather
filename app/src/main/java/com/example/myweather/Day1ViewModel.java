package com.example.myweather;

import android.content.Context;

import com.example.myweather.data.Repository;
import com.example.myweather.data.entities.WeatherEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class Day1ViewModel extends ViewModel {
    public Day1ViewModel(){

    }
    private Repository repository;
    private LiveData<WeatherEntity> weatherData;

    public void loadData(Repository repository){
        if(weatherData == null){
            this.repository = repository;
            weatherData = repository.getOneDayWeatherData();
        }
    }
    public LiveData<WeatherEntity> getWeatherData(){
        return weatherData;
    }

}
