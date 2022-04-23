package com.cmpe277.hackathon.mainactivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;
import com.cmpe277.hackathon.mainactivity.models.UserType;
import android.widget.TextView;


import com.cmpe277.hackathon.mainactivity.database.AppDBHelper;
import com.cmpe277.hackathon.mainactivity.database.AppDatabase;
import com.cmpe277.hackathon.mainactivity.entities.UserInfo;


public class MainActivity extends AppCompatActivity {

    UserType userType;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //access db and see if user should be able to login

        new Thread(()->{
            db= AppDBHelper.getDatabase(this);
            UserInfo usi=db.userInfoDao().findByName("usertype");
            runOnUiThread(()-> {


                if (usi == null){
                    userType = UserType.None;
                    TextView v = (TextView) findViewById(R.id.textView);
                    v.setText(userType.getTitle());
                    ImageButton macro_button=(ImageButton)findViewById(R.id.macroeconomic_researcher_button);
                    macro_button.setOnClickListener((view)->macroUserClick(view));
                    ImageButton gov_button =(ImageButton)findViewById(R.id.government_official_button);
                    gov_button.setOnClickListener((view)->govUserClick(view));
                }
                else{
                    userType=UserType.valueOfOrDefault(usi.usr_attr_value);
                    callIntent(userType);
                }

            });
        }).start();




    }
    public void macroUserClick(View view){
        this.userType= UserType.ECON_RES;
        login();
    }

    public void govUserClick(View view){
        this.userType= UserType.GOVT_REP;
        login();

    }
    public void login(){
        UserType l=this.userType;
        if(l==UserType.None){
            l=UserType.ECON_RES;
            UserInfo usi=new UserInfo();
            usi.usr_attr="usertype";
            usi.usr_attr_value=l.toString();
            final UserType t=l;
            new Thread(()->{
                db.userInfoDao().insertUser(usi);
                runOnUiThread(()->{
                    callIntent(t);
                });
            }).start();


          //  access.createUserType(UserType.ECON_RES);
        }
        else{
            callIntent(l);
        }

    }
    public void callIntent(UserType l){
        Intent i=new Intent(this,Dashboard.class);
        i.putExtra("userType",l.toString());
        startActivity(i);
    }
    public void onDestroy() {
        super.onDestroy();
    }
}