package com.example.myweather;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myweather.data.entities.WeatherEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder>{

    //private String[] data;
    //private WeatherForecast weatherForecast;
//
//    public WeatherAdapter(WeatherForecast incomeData){
//        this.weatherForecast = incomeData;
//    //    this.data=incomeData;
//    }
    private LiveData<List<WeatherEntity>> weatherEntityList;

    public WeatherAdapter(LiveData<List<WeatherEntity>> incomeData){
        this.weatherEntityList = (LiveData<List<WeatherEntity>>) incomeData;
        //    this.data=incomeData;
    }


//    public void changeData(WeatherForecast newData){
//        this.weatherForecast = newData;
//        notifyDataSetChanged();
//    }

    class WeatherHolder extends RecyclerView.ViewHolder{
        private TextView text1;
        private TextView text2;
        private TextView tempreture;
        private TextView wind;
        private TextView temp_min;
        private TextView temp_maх;
        private TextView pressure;

        public WeatherHolder(View view){
            super(view);
            text1 = view.findViewById(R.id.text1);
            text2 = view.findViewById(R.id.text2);
            tempreture = view.findViewById(R.id.tempreture);
            temp_min=view.findViewById(R.id.temp_min);
            temp_maх=view.findViewById(R.id.temp_max);
            pressure=view.findViewById(R.id.pressure);
            wind=view.findViewById(R.id.wind);
        }

        public void setData(WeatherEntity content){
            text1.setText("Date "+content.dateTime);
            text2.setText(String.valueOf("pressure   "+((int)(content.pressure/1.33))));
            tempreture.setText("tempreture " +((int)( content.temp-273)));
            temp_maх.setText("max_temp   "+((int)(content.tempMax-273)));
            temp_min.setText("min_temp   "+((int)(content.tempMin-273)));
            wind.setText("wind       "+((int)content.wind));

        }



//        public void setData(ForecastDay content){
//            text1.setText("Date "+content.getDt_txt());
//            text2.setText(String.valueOf("pressure   "+String.valueOf((int)(content.getMain().getPressure()/1.33))));
//           tempreture.setText("tempreture " +String.valueOf((int)content.getMain().getTemp()-273));
//            temp_maх.setText("max_temp   "+String.valueOf((int)content.getMain().getTemp_max()-273));
//            temp_min.setText("min_temp   "+String.valueOf((int)content.getMain().getTemp_min()-273));
//            wind.setText("wind       "+String.valueOf((int)content.getWind().getSpeed()));
//
//        }
//        public void setData(String info){
//            text1.setText(info);
//            text2.setText(info);
//        }
    }


    @Override
    public WeatherHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.weather_item, viewGroup, false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherHolder weatherHolder, int i) {

        weatherHolder.setData(weatherEntityList.getValue().get(i));

    }

    @Override
    public int getItemCount() {
                return this.weatherEntityList.getValue().size();
    }
}
