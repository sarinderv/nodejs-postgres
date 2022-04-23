package com.cmpe277.hackathon.mainactivity.database;

import android.content.Context;

import androidx.room.Room;

public class AppDBHelper {
   private static AppDatabase db;
    private static AppDBHelper dbHelper;
   private AppDBHelper(Context context){
       db= Room.databaseBuilder(context, AppDatabase.class, "mefsinst.db")
               .createFromAsset("databases/mefs.db")
               .build();
   }
   public static AppDatabase getDatabase(Context context){
       if(db==null){
           synchronized (AppDBHelper.class){
               if(db==null)
               {
                   dbHelper=new AppDBHelper(context);
               }
           }
       }
       return db;
   }

}
