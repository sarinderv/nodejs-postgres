package com.cmpe277.hackathon.mainactivity.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.cmpe277.hackathon.mainactivity.entities.UserInfo;

import java.util.List;

@Dao
public interface UserInfoDao {
    @Query("SELECT * FROM userinfo")
    List<UserInfo> getAllUserInfo();



    @Query("SELECT * FROM userinfo WHERE usr_attr LIKE :usertype  LIMIT 1")

    UserInfo findByName(String usertype);

    @Insert
    void insertUser(UserInfo users);

}
