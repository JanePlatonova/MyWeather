package com.example.myweather.data.entities;

public class ForecastDay
{
    private int dt;

    private Main main;

    private java.util.List<Weather5> weather;

    private Clouds clouds;

    private Wind wind;

    private Sys sys;

    private String dt_txt;//DateTime

    public void setDt(int dt){
        this.dt = dt;
    }
    public int getDt(){
        return this.dt;
    }
    public void setMain(Main main){
        this.main = main;
    }
    public Main getMain(){
        return this.main;
    }
    public void setWeather(java.util.List<Weather5> weather){
        this.weather = weather;
    }
    public java.util.List<Weather5> getWeather(){
        return this.weather;
    }
    public void setClouds(Clouds clouds){
        this.clouds = clouds;
    }
    public Clouds getClouds(){
        return this.clouds;
    }
    public void setWind(Wind wind){
        this.wind = wind;
    }
    public Wind getWind(){
        return this.wind;
    }
    public void setSys(Sys sys){
        this.sys = sys;
    }
    public Sys getSys(){
        return this.sys;
    }
    public void setDt_txt(String dt_txt){//DateTime
        this.dt_txt = dt_txt;
    }
    public String getDt_txt(){//DateTime
        return this.dt_txt;
    }
}

