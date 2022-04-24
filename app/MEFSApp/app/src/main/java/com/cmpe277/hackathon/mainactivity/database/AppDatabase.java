package com.cmpe277.hackathon.mainactivity.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cmpe277.hackathon.mainactivity.dao.AgroDao;
import com.cmpe277.hackathon.mainactivity.dao.MacroInfoDao;
import com.cmpe277.hackathon.mainactivity.dao.UserInfoDao;
import com.cmpe277.hackathon.mainactivity.entities.AgriData;
import com.cmpe277.hackathon.mainactivity.entities.MacroEco;
import com.cmpe277.hackathon.mainactivity.entities.UserInfo;

@Database(entities = {UserInfo.class, MacroEco.class, AgriData.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserInfoDao userInfoDao();
    public abstract MacroInfoDao macroInfoDao();
    public abstract AgroDao agroDao();
}
