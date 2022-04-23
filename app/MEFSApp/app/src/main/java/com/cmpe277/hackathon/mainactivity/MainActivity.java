package com.cmpe277.hackathon.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.login_button);
        b.setOnClickListener((view)->onContinueClick(view));
    }
    public void onContinueClick(View view){
        Intent i=new Intent(this,Dashboard.class);
        startActivity(i);
    }
}