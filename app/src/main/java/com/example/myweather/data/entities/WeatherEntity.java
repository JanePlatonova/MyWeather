package com.example.myweather.data.entities;

import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity//(tableName = "weather_forecast")
public class WeatherEntity  {
    @PrimaryKey
    public Integer key;
    public Double tempMin;
    public Double tempMax;
    public String dateTime;
    public Double temp;
    public float wind;
    public Double pressure;
}
