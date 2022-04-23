package com.cmpe277.hackathon.mainactivity;

import static com.cmpe277.hackathon.mainactivity.models.UserType.ECON_RES;
import static com.cmpe277.hackathon.mainactivity.models.UserType.GOVT_REP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.cmpe277.hackathon.mainactivity.models.UserType;

public class MainActivity extends AppCompatActivity {

    public UserType userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton macro_button=(ImageButton)findViewById(R.id.macroeconomic_researcher_button);
        macro_button.setOnClickListener((view)->macroUserClick(view));
        ImageButton gov_button =(ImageButton)findViewById(R.id.government_official_button);
        gov_button.setOnClickListener((view)->govUserClick(view));
    }
    public void macroUserClick(View view){
        Intent i=new Intent(this,Dashboard.class);
        userType = ECON_RES;
        startActivity(i);
    }

    public void govUserClick(View view){
        Intent i=new Intent(this,Dashboard.class);
        userType = GOVT_REP;
        startActivity(i);
    }
}