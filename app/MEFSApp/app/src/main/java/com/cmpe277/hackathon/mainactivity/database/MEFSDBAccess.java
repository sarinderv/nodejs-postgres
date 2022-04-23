package com.cmpe277.hackathon.mainactivity.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.cmpe277.hackathon.mainactivity.models.UserType;

import java.sql.PreparedStatement;

public class MEFSDBAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static MEFSDBAccess instance;
    private MEFSDBAccess(Context context){
        this.openHelper=new DatabaseHelper(context);
    }
    public static MEFSDBAccess getInstance(Context context){
        if(instance==null){
            synchronized(MEFSDBAccess.class){
                if(instance==null)
                    instance=new MEFSDBAccess(context);
            }
        }
        return  instance;
    }
    public void open(){
        this.database=openHelper.getWritableDatabase();
    }
    public void close(){
        if(database!=null)
            this.database.close();
    }
    public UserType getUserType(){
        UserType test=UserType.None;
        Cursor cur=database.rawQuery("SELECT * from userinfo where usr_attr='usertype'",null);
        int result = cur.getCount();
        System.out.println(result);
        if(result!=0)
        {
            cur.moveToFirst();
            while (!cur.isAfterLast()) {
               String data=cur.getString(2);
                test=UserType.valueOfOrDefault(data);
                break;
            }
        }
        cur.close();
        return test;
    }
    private static final String INSERT_USERTYPE_SQL = "INSERT INTO userinfo(usr_attr,usr_attr_value) VALUES('usertype', ?)";


    public long createUserType(UserType userType){

        long numRowsInserted = 0;
        SQLiteStatement statement=null;
        try {
            statement=this.database.compileStatement(INSERT_USERTYPE_SQL);
            statement.bindString(1,userType.getTitle());
            numRowsInserted=statement.executeInsert();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement!=null)
                statement.close();
        }
        return numRowsInserted;
    }
}
