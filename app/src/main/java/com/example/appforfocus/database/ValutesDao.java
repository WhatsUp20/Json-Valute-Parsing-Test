package com.example.appforfocus.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.appforfocus.Valutes;

import java.util.List;

@Dao
public interface ValutesDao {

    @Query("SELECT*FROM valutes")
    LiveData<List<Valutes>> getAllValutes();

    @Insert
    void insertValute(List<Valutes> valutes);

    @Query("delete from valutes")
    void removeAllValutes();
}
