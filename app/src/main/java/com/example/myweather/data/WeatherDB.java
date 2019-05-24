package com.example.myweather.data;

import android.content.Context;

import com.example.myweather.Day5Activity;
import com.example.myweather.data.entities.WeatherEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WeatherEntity.class}, version = 1,exportSchema = false)
public abstract class WeatherDB extends RoomDatabase {
    private static WeatherDB instance;
    public abstract WeatherDao weatherDao();
//    public static  synchronized  WeatherDB getInstance(Context context) {
//     //   if (context == Day5Activity.this) {
//            if (instance == null) {
//                instance = Room.databaseBuilder(context.getApplicationContext(), WeatherDB.class, "weatherDB").fallbackToDestructiveMigration().build();
//
//
//            }
//       // }
//            return instance;
//        }

}
