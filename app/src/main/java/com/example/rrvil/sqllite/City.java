package com.example.rrvil.sqllite;

/**
 * Created by rrvil on 06-Sep-17.
 */

public class City {

    private long id;
    private String city;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return city;
    }
}
