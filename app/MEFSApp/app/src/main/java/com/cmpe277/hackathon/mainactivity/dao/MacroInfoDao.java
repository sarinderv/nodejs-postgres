package com.cmpe277.hackathon.mainactivity.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.cmpe277.hackathon.mainactivity.entities.MacroEco;

import java.util.List;

@Dao
public interface MacroInfoDao {
    @Query("SELECT * FROM macroeconomic")
    List<MacroEco> getAllData();

    @Query("SELECT * FROM macroeconomic WHERE year>=:from and year<=:to")
    List<MacroEco> getDataBetweenYears(int from,int to);

}