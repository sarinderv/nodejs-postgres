package com.cmpe277.hackathon.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cmpe277.hackathon.mainactivity.database.MEFSDBAccess;
import com.cmpe277.hackathon.mainactivity.models.UserType;

public class MainActivity extends AppCompatActivity {
    MEFSDBAccess access;
    UserType userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.login_button);
        b.setOnClickListener((view)->onContinueClick(view));
        access=MEFSDBAccess.getInstance(this);
        access.open();
        userType=access.getUserType();
        TextView v=(TextView) findViewById(R.id.textView);
        v.setText(userType.getTitle());


    }
    public void onContinueClick(View view){
        UserType l=this.userType;
        if(l==UserType.None){
            l=UserType.ECON_RES;
            access.createUserType(UserType.ECON_RES);
        }

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