package com.example.appforfocus.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appforfocus.Valutes;

@Database(entities = {Valutes.class}, version = 1, exportSchema = false)
public abstract class ValutesDatabase extends RoomDatabase {

    private static ValutesDatabase database;
    private static final String DB_NAME = "valutes.db";
    private static Object LOCK = new Object();

    public static ValutesDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, ValutesDatabase.class, DB_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
            return database;
        }
    }

    public abstract ValutesDao valutesDao();
}
