package com.cmpe277.hackathon.mainactivity.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.cmpe277.hackathon.mainactivity.entities.AgriData;
import com.cmpe277.hackathon.mainactivity.entities.DebtData;

import java.util.List;

@Dao
public interface DebtDao {
    @Query("SELECT * FROM debt")
    List<DebtData> getAllData();

    @Query("SELECT * FROM debt WHERE year>=:from and year<=:to")
    List<DebtData> getDataBetweenYears(int from,int to);

}
