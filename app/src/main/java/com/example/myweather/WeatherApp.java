package com.example.myweather;

import android.app.Application;

import com.example.myweather.data.Repository;

public class WeatherApp extends Application {

    private Repository repository;
    @Override
    public void onCreate() {
        super.onCreate();
        repository = new Repository(this);
    }

    public Repository getRepository(){
        return repository;
    }

}
