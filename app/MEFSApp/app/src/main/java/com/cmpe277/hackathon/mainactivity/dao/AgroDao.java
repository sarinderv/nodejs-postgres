package com.cmpe277.hackathon.mainactivity.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.cmpe277.hackathon.mainactivity.entities.AgriData;
import com.cmpe277.hackathon.mainactivity.entities.MacroEco;

import java.util.List;

@Dao
public interface AgroDao {
    @Query("SELECT * FROM agricultural")
    List<AgriData> getAllData();

    @Query("SELECT * FROM agricultural WHERE year>=:from and year<=:to")
    List<AgriData> getDataBetweenYears(int from,int to);

}
