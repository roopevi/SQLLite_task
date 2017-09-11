package com.example.rrvil.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrvil on 06-Sep-17.
 */

public class CitiesDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allCities = {
            DatabaseHelper.COLUMN_ID,
            DatabaseHelper.COLUMN_CITY
    };

    public CitiesDataSource (Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public City createCity (String city) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_CITY, city);

        long insertId = database.insert(DatabaseHelper.TABLE_CITIES, null, values);

        Cursor cursor = database.query(DatabaseHelper.TABLE_CITIES, allCities, DatabaseHelper.COLUMN_ID
                + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();

        City newCity = cursorToCity(cursor);
        cursor.close();

        return newCity;
    }

    public void deleteCity (City city) {
        long id = city.getId();

        System.out.println("Comment deleted by id");

        database.delete(DatabaseHelper.TABLE_CITIES, DatabaseHelper.COLUMN_ID + " = " + id, null);
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<City>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_CITIES,
                allCities, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            City city = cursorToCity(cursor);
            cities.add(city);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return cities;
    }

    private City cursorToCity(Cursor cursor) {
        City city = new City();
        city.setId(cursor.getLong(0));
        city.setCity(cursor.getString(1));
        return city;
    }

}





