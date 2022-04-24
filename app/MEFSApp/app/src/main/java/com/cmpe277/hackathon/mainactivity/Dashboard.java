package com.cmpe277.hackathon.mainactivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cmpe277.hackathon.mainactivity.adapter.AgriResponseConverter;
import com.cmpe277.hackathon.mainactivity.adapter.DebtResponseConverter;
import com.cmpe277.hackathon.mainactivity.adapter.MacroResponseConverter;
import com.cmpe277.hackathon.mainactivity.client.RetrofitClientInstance;
import com.cmpe277.hackathon.mainactivity.database.AppDBHelper;
import com.cmpe277.hackathon.mainactivity.database.AppDatabase;
import com.cmpe277.hackathon.mainactivity.dto.AgriAPIResponse;
import com.cmpe277.hackathon.mainactivity.dto.DebtAPIResponse;
import com.cmpe277.hackathon.mainactivity.dto.MacroAPIResponse;
import com.cmpe277.hackathon.mainactivity.entities.MacroEco;
import com.cmpe277.hackathon.mainactivity.models.AgriDataPoint;
import com.cmpe277.hackathon.mainactivity.models.DebtDataPoint;
import com.cmpe277.hackathon.mainactivity.models.MacroEconomicDataPoint;
import com.cmpe277.hackathon.mainactivity.service.IMacroService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cmpe277.hackathon.mainactivity.databinding.ActivityDashboardBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {

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

        //loading data
        /*Create handle for the RetrofitInstance interface*/
        IMacroService service = RetrofitClientInstance.getRetrofitInstance().create(IMacroService.class);
        Call<MacroAPIResponse> call = service.getMacroDetails();
        call.enqueue(new Callback<MacroAPIResponse>() {
            @Override
            public void onResponse(Call<MacroAPIResponse> call, Response<MacroAPIResponse> response) {
                MacroResponseConverter converter=new MacroResponseConverter();
                List<MacroEconomicDataPoint> points=converter.getDataPoints(response.body().getData());
                points.stream().forEach((obj)->{
                  //  System.out.println(obj.toString());
                });
                Toast.makeText(Dashboard.this, "macro Data loaded "+response.body().data.size(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<MacroAPIResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(Dashboard.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        Call<AgriAPIResponse> calla = service.getAgriDetails();
        calla.enqueue(new Callback<AgriAPIResponse>() {
            @Override
            public void onResponse(Call<AgriAPIResponse> call, Response<AgriAPIResponse> response) {
                AgriResponseConverter converter=new AgriResponseConverter();
                List<AgriDataPoint> points=converter.getDataPoints(response.body().getData());
                points.stream().forEach((obj)->{
                   // System.out.println(obj.toString());
                });
                Toast.makeText(Dashboard.this, "agri Data loaded "+response.body().data.size(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<AgriAPIResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(Dashboard.this, "agri Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        Call<DebtAPIResponse> calld = service.getDebtDetails();
        calld.enqueue(new Callback<DebtAPIResponse>() {
            @Override
            public void onResponse(Call<DebtAPIResponse> call, Response<DebtAPIResponse> response) {
                DebtResponseConverter converter=new DebtResponseConverter();
                List<DebtDataPoint> points=converter.getDataPoints(response.body().getData());
                points.stream().forEach((obj)->{
                    System.out.println(obj.toString());
                });
                Toast.makeText(Dashboard.this, "Debt Data loaded "+response.body().data.size(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<DebtAPIResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(Dashboard.this, "DEbt Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}