package com.example.rrvil.sqllite;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.List;

public class MainActivity extends ListActivity {

    private CitiesDataSource citiesDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citiesDataSource = new CitiesDataSource(this);
        citiesDataSource.open();

        List<City> cities = citiesDataSource.getAllCities();

        ArrayAdapter<City> adapter = new ArrayAdapter<City>(this,
                android.R.layout.simple_list_item_1, cities);
        setListAdapter(adapter);
    }
}
