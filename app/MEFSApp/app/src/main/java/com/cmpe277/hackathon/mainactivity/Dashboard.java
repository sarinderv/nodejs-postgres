package com.cmpe277.hackathon.mainactivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cmpe277.hackathon.mainactivity.client.RetrofitClientInstance;
import com.cmpe277.hackathon.mainactivity.dto.MacroAPIResponse;
import com.cmpe277.hackathon.mainactivity.service.IMacroService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cmpe277.hackathon.mainactivity.databinding.ActivityDashboardBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {

    private ActivityDashboardBinding binding;

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
        //loading data
        /*Create handle for the RetrofitInstance interface*/
        IMacroService service = RetrofitClientInstance.getRetrofitInstance().create(IMacroService.class);
        Call<MacroAPIResponse> call = service.getMacroDetails();
        call.enqueue(new Callback<MacroAPIResponse>() {
            @Override
            public void onResponse(Call<MacroAPIResponse> call, Response<MacroAPIResponse> response) {
                Toast.makeText(Dashboard.this, "Data loaded "+response.body().data.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MacroAPIResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(Dashboard.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}