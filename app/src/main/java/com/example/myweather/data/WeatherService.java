package com.example.myweather.data;

import com.example.myweather.data.entities.WeatherDay;
import com.example.myweather.data.entities.WeatherForecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("/data/2.5/weather")
    Call<WeatherDay> getWeatherByCityName(@Query("q") String city, @Query("appid") String appID);
    @GET("/data/2.5/forecast")
    Call<WeatherForecast> getWeatherForWeek(@Query("q") String city, @Query("appid") String appID);

}
