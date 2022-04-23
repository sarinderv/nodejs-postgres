package com.cmpe277.hackathon.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cmpe277.hackathon.mainactivity.database.AppDBHelper;
import com.cmpe277.hackathon.mainactivity.database.AppDatabase;
import com.cmpe277.hackathon.mainactivity.database.MEFSDBAccess;
import com.cmpe277.hackathon.mainactivity.entities.UserInfo;
import com.cmpe277.hackathon.mainactivity.models.UserType;

public class MainActivity extends AppCompatActivity {
    MEFSDBAccess access;
    UserType userType;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.login_button);
        b.setVisibility(View.INVISIBLE);
        new Thread(()->{
            db= AppDBHelper.getDatabase(this);
            UserInfo usi=db.userInfoDao().findByName("usertype");
            runOnUiThread(()-> {
                b.setOnClickListener((view) -> onContinueClick(view));
                if (usi == null){
                    userType = UserType.None;
                TextView v = (TextView) findViewById(R.id.textView);
                v.setText(userType.getTitle());
                b.setVisibility(View.VISIBLE);
            }
                else{
                    userType=UserType.valueOfOrDefault(usi.usr_attr_value);
                    callIntent(userType);
                }

            });
        }).start();
    }
    public void onContinueClick(View view){
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
        if(access!=null)
            access.close();
    }
}