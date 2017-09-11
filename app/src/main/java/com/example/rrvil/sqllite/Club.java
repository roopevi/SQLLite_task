package com.example.rrvil.sqllite;

/**
 * Created by rrvil on 06-Sep-17.
 */

public class Club {
    private long id;
    private String club;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String city) {
        this.club = city;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return club;
    }
}
