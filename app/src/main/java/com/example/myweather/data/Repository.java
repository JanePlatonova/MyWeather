package com.example.myweather.data;

import android.content.Context;
import android.util.Log;

import com.example.myweather.data.entities.WeatherDay;
import com.example.myweather.data.entities.WeatherEntity;
import com.example.myweather.data.entities.WeatherForecast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;

public class Repository {
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;

    public Repository(Context context){
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();
    }


    public LiveData<List<WeatherEntity>> getWeatherDataDay(){//5 дней
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                WeatherForecast weatherForecast = remoteDataSource.getWeatherDay();
                storeWeatherforDay(weatherForecast);
            }
        });
        return localDataSource.getWeatherforDay();
    }
    public LiveData<WeatherEntity> getOneDayWeatherData(){// 1 день
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                WeatherDay weatherForecast = remoteDataSource.getWeatherOneDay();
                storeWeatherforOneDay(weatherForecast);
            }
        });
        return localDataSource.getWeatherforOneDay();
    }
    public void storeWeatherforDay(WeatherForecast weatherForecast){// 5 дней
        List<WeatherEntity> weatherEntitieslist = new ArrayList<WeatherEntity>(1);
        WeatherEntity we=new WeatherEntity();
        for(int i=0;i<weatherForecast.getItems().size();i++){
            we.key=i;
            we.tempMin = weatherForecast.getItems().get(i).getMain().getTemp_min();
            we.tempMax = weatherForecast.getItems().get(i).getMain().getTemp_max();
            we.temp=weatherForecast.getItems().get(i).getMain().getTemp();
            we.pressure=weatherForecast.getItems().get(i).getMain().getPressure();
            we.wind=weatherForecast.getItems().get(i).getWind().getSpeed();
            we.dateTime=weatherForecast.getItems().get(i).getDt_txt();
            weatherEntitieslist.add(we);
            localDataSource.StoreWeather(we);

        }

    }
    public void storeWeatherforOneDay(WeatherDay weatherForecast){// 1 день
        List<WeatherEntity> weatherEntitieslist = new ArrayList<WeatherEntity>(1);
        WeatherEntity we=new WeatherEntity();
        we.key=41;
            we.tempMin = weatherForecast.getMain().getTemp_min();
            we.tempMax = weatherForecast.getMain().getTemp_max();
            we.temp=weatherForecast.getMain().getTemp();
            we.pressure=weatherForecast.getMain().getPressure();
            we.wind=weatherForecast.getWind().getSpeed();
            we.dateTime="1";
            weatherEntitieslist.add(we);
            localDataSource.StoreWeather(we);

    }

}



