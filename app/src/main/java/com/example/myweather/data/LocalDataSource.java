package com.example.myweather.data;

import android.content.Context;
import android.util.Log;
import com.example.myweather.data.entities.WeatherDay;
import com.example.myweather.data.entities.WeatherEntity;
import com.example.myweather.data.entities.WeatherForecast;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

public class LocalDataSource {
    final WeatherDB db;

    public LocalDataSource(Context context){
        db = Room.databaseBuilder(context, WeatherDB.class,"weather").build();
    }
    public void StoreWeather(WeatherEntity we) {
            db.weatherDao().insertWeather(we);
        ;
    }

//    public void storeWeatherforDay(WeatherForecast weatherForecast){
//        List<WeatherEntity> weatherEntitieslist = new ArrayList<WeatherEntity>(1);
//        WeatherEntity we=new WeatherEntity();
//        Log.d("item 0", String.valueOf(weatherForecast.getItems().get(0).getMain()));
//        for(int i=0;i<weatherForecast.getItems().size();i++){
//                    we.key=i;
//                    we.tempMin = weatherForecast.getItems().get(i).getMain().getTemp_min();
//                    we.tempMax = weatherForecast.getItems().get(i).getMain().getTemp_max();
//                    we.temp=weatherForecast.getItems().get(i).getMain().getTemp();
//                    we.pressure=weatherForecast.getItems().get(i).getMain().getPressure();
//                    we.wind=weatherForecast.getItems().get(i).getWind().getSpeed();
//                    we.dateTime=weatherForecast.getItems().get(i).getDt_txt();
//                    weatherEntitieslist.add(we);
//                    db.weatherDao().insertWeather(we);
//            Log.d("Лежит в базе", String.valueOf(db.weatherDao().getWeatherForecast().getValue().get(i).dateTime));
//        }
//        Log.d("Кладём в базу", weatherEntitieslist.get(0).dateTime);
//       // db.weatherDao().insertWeather(weatherEntitieslist);
//        Log.d("Кладём в базууу", String.valueOf(weatherEntitieslist.size()));
//        Log.d("Лежит в базе", String.valueOf(db.weatherDao().getWeatherForecast().getValue().size()));
//    }


//    }

    //public List<WeatherEntity> getWeatherforDay(){
    public LiveData<List<WeatherEntity>> getWeatherforDay(){
       // Log.d("Запрос из базы", String.valueOf(db.weatherDao().getWeatherForecast().getValue()));
        return db.weatherDao().getWeatherForecast();
    }
    public LiveData<WeatherEntity> getWeatherforOneDay(){
        // Log.d("Запрос из базы", String.valueOf(db.weatherDao().getWeatherForecast().getValue()));
        return db.weatherDao().getOneDayWeather();
    }

//    public WeatherForecast getWeatherforWeek() {
//        return ;
//    }


}
