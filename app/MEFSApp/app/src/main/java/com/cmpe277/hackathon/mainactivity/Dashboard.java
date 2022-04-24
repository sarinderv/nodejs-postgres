package com.cmpe277.hackathon.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cmpe277.hackathon.mainactivity.database.AppDBHelper;
import com.cmpe277.hackathon.mainactivity.database.AppDatabase;
import com.cmpe277.hackathon.mainactivity.databinding.ActivityDashboardBinding;
import com.cmpe277.hackathon.mainactivity.entities.MacroEco;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Dashboard extends AppCompatActivity  {

    private ActivityDashboardBinding binding;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("userType");
            System.out.println(value);
            //The key argument here must match that used in the other activity
        }
        new Thread(()->{
            System.out.println("Calling db");
            db= AppDBHelper.getDatabase(this);
            List<MacroEco> datapoints=db.macroInfoDao().getAllData();
            runOnUiThread(()-> {
                System.out.println("size db : "+datapoints.size());
                datapoints.stream().forEach((obj)->{
                    System.out.println("db : "+obj.toString());
                });


            });
        });

    }

}