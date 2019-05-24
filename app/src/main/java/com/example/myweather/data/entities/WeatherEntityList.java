package com.example.myweather.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherEntityList {

        @SerializedName("list")
        private List<WeatherEntity> items;

        public WeatherEntityList(List<WeatherEntity> items) {
            this.items = items;
        }

        public List<WeatherEntity> getItems() {
            return items;
        }





}
