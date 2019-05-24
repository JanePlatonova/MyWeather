package com.example.myweather.data.entities;

import com.example.myweather.data.entities.ForecastDay;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecast
{
    @SerializedName("list")
    private List<ForecastDay> items;

    public WeatherForecast(List<ForecastDay> items) {
        this.items = items;
    }

    public List<ForecastDay> getItems() {
        return items;
    }
}