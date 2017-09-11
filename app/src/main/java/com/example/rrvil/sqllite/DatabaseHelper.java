package com.example.rrvil.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by rrvil on 06-Sep-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_CITIES = "cities";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_ID = "_id";

    public static final String TABLE_CLUBS = "clubs";
    public static final String COLUMN_CLUB_CITY = "city";

    private static final String DATABASE_NAME = "cities.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_CITIES + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_CITY
            + " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DATABASE_CREATE);

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_CITY, "London");

        db.insert(TABLE_CITIES, null, values);

        values.clear();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(DatabaseHelper.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIES);
        onCreate(db);
    }

}
