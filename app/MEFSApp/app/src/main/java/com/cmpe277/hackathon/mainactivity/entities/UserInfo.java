package com.cmpe277.hackathon.mainactivity.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userinfo")
public class UserInfo {
    @PrimaryKey
    public int row_id;
    @ColumnInfo(name = "usr_attr")
    public String usr_attr;
    @ColumnInfo(name = "usr_attr_value")
    public String usr_attr_value;
}
