package com.example.myweather.data.entities;

import com.example.myweather.data.entities.City;

import java.util.List;
public class Root
{
    private String cod;

    private double message;

    private int cnt;

    private List<List> list;

    private City city;

    public void setCod(String cod){
        this.cod = cod;
    }
    public String getCod(){
        return this.cod;
    }
    public void setMessage(double message){
        this.message = message;
    }
    public double getMessage(){
        return this.message;
    }
    public void setCnt(int cnt){
        this.cnt = cnt;
    }
    public int getCnt(){
        return this.cnt;
    }
    public void setList(List<List> list){
        this.list = list;
    }
    public List<List> getList(){
        return this.list;
    }
    public void setCity(City city){
        this.city = city;
    }
    public City getCity(){
        return this.city;
    }
}

