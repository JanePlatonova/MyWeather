package com.example.myweather;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ListDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.list_detail_activity);
        int orientaion = getResources().getConfiguration().orientation;
        FragmentManager fragmentManager = getSupportFragmentManager();

        Log.e("LDA", "LOGGG");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(orientaion == Configuration.ORIENTATION_PORTRAIT){
            Log.e("LDA", "Portrait");
            fragmentTransaction.add(R.id.layout_list, new ListFragment());
        } else {
            Log.e("LDA", "Landscape");

            fragmentTransaction.add(R.id.layout_list, new ListFragment());
            fragmentTransaction.add(R.id.layout_detail, new DetailFragment());
        }
        fragmentTransaction.commit();
    }
}
