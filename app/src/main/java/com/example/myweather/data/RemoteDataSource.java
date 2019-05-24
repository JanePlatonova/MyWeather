package com.example.myweather.data;

import android.util.Log;

import com.example.myweather.data.entities.WeatherDay;
import com.example.myweather.data.entities.WeatherForecast;

import java.io.IOException;

import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private WeatherService weatherService;

    public RemoteDataSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }

    public WeatherForecast getWeatherDay(){
        Call<WeatherForecast> call = weatherService.getWeatherForWeek("Kiev,ua","3d822b9dce4e57f12b9b3400d480a358");
        try {
            Response<WeatherForecast> response = call.execute();
            if(response.isSuccessful()){
                Log.d("item 0", String.valueOf(response.body().getItems().get(0).getDt_txt()));
                return response.body();

            }
        }catch(IOException ioex){
            Log.e("Remote", "IOEX: " + ioex.toString());
        }

        return null;
    }
    public WeatherDay getWeatherOneDay(){
        Call<WeatherDay> call = weatherService.getWeatherByCityName("Kiev,ua","3d822b9dce4e57f12b9b3400d480a358");
        try {
            Response<WeatherDay> response = call.execute();
            if(response.isSuccessful()){
                Log.d("Ветер 0", String.valueOf(response.body().getWind().getSpeed()));
                return response.body();

            }
        }catch(IOException ioex){
            Log.e("Remote", "IOEX: " + ioex.toString());
        }

        return null;
    }

//    public WeatherForecast getWeatherWeek(){
//    }
}
