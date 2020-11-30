package com.example.appforfocus.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.appforfocus.Valutes;

import java.util.List;

@Dao
public interface ValutesDao {

    @Query("SELECT*FROM valutes")
    List<Valutes> getAllValutes();

    @Delete
    void deleteValute(Valutes valutes);
}
