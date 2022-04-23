package com.cmpe277.hackathon.mainactivity.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cmpe277.hackathon.mainactivity.dao.UserInfoDao;
import com.cmpe277.hackathon.mainactivity.entities.UserInfo;

@Database(entities = {UserInfo.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserInfoDao userInfoDao();
}
