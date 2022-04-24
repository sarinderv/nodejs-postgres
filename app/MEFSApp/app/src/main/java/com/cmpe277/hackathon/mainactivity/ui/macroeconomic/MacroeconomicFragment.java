package com.cmpe277.hackathon.mainactivity.ui.macroeconomic;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.cmpe277.hackathon.mainactivity.R;
import com.cmpe277.hackathon.mainactivity.database.AppDBHelper;
import com.cmpe277.hackathon.mainactivity.database.AppDatabase;
import com.cmpe277.hackathon.mainactivity.entities.MacroEco;
import com.cmpe277.hackathon.mainactivity.entities.UserInfo;
import com.cmpe277.hackathon.mainactivity.models.UserType;

import java.util.List;

public class MacroeconomicFragment extends AppCompatActivity {
    CheckBox checkbox_gdp_growth_rage, checkbox_gdp_current_usd, checkbox_current_account_balance,checkbox_fdi_net,checkbox_fdi_net_in, checkbox_fdi_net_out ;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




        checkbox_gdp_growth_rage =(CheckBox)findViewById(R.id.checkbox_gdp_growth_rage);
        checkbox_gdp_current_usd =(CheckBox)findViewById(R.id.checkbox_gdp_current_usd);
        checkbox_current_account_balance =(CheckBox)findViewById(R.id.checkbox_current_account_balance);
        checkbox_fdi_net =(CheckBox)findViewById(R.id.checkbox_fdi_net);
        checkbox_fdi_net_in =(CheckBox)findViewById(R.id.checkbox_fdi_net_in);
        checkbox_fdi_net_out =(CheckBox)findViewById(R.id.checkbox_fdi_net_out);
    }

    public void Check(View v)
    {
        if(checkbox_gdp_growth_rage.isChecked()) {

        }

        if(checkbox_gdp_current_usd.isChecked()) {

        }

        if(checkbox_current_account_balance.isChecked()) {

        }

        if(checkbox_fdi_net.isChecked()) {

        }

        if(checkbox_fdi_net_in.isChecked()) {

        }

        if(checkbox_fdi_net_out.isChecked()){

        }

    }
}
