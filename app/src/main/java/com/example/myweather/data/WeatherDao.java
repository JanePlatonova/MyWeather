package com.example.myweather.data;


import com.example.myweather.data.entities.WeatherEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertWeather(WeatherEntity weatherEntity);

    @Query("SELECT * FROM WeatherEntity where dateTime='1'")
    public LiveData<WeatherEntity> getOneDayWeather();

    @Query("SELECT * FROM WeatherEntity where dateTime!='1'")
    public LiveData<List<WeatherEntity>> getWeatherForecast();
}
