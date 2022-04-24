package com.cmpe277.hackathon.mainactivity.ui.macroeconomic;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cmpe277.hackathon.mainactivity.R;
import com.cmpe277.hackathon.mainactivity.databinding.FragmentAgricultureBinding;
import com.cmpe277.hackathon.mainactivity.databinding.FragmentMacroeconomicBinding;
import com.cmpe277.hackathon.mainactivity.ui.agriculture.AgricultureViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MacroeconomicFragment extends Fragment {
    CheckBox checkbox_gdp_growth_rage, checkbox_gdp_current_usd, checkbox_current_account_balance,checkbox_fdi_net,checkbox_fdi_net_in, checkbox_fdi_net_out ;
    private LineChart lineChart;
    private FragmentMacroeconomicBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MacroeconomicViewModel macroeconomicViewModel =
                new ViewModelProvider(this).get(MacroeconomicViewModel.class);

        binding = FragmentMacroeconomicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        lineChart = root.findViewById(R.id.activity_linechart);

        checkbox_gdp_growth_rage =(CheckBox)root.findViewById(R.id.checkbox_gdp_growth_rage);
        checkbox_gdp_current_usd =(CheckBox)root.findViewById(R.id.checkbox_gdp_current_usd);
        checkbox_current_account_balance =(CheckBox)root.findViewById(R.id.checkbox_current_account_balance);
        checkbox_fdi_net =(CheckBox)root.findViewById(R.id.checkbox_fdi_net);
        checkbox_fdi_net_in =(CheckBox)root.findViewById(R.id.checkbox_fdi_net_in);
        checkbox_fdi_net_out =(CheckBox)root.findViewById(R.id.checkbox_fdi_net_out);
        configureLineChart();
        return root;
    }

    public void Check(View v)
    {
      ArrayList<Entry> gdp = new ArrayList<>();
      for(int i=0; i<10; i++){
          Entry entry = new Entry(i, i*i);
          gdp.add(entry);
      }

        setLineChartData(gdp, null, null, null, null, null);


    }

    private void configureLineChart() {
        Description desc = new Description();
        desc.setText("Chart");
        desc.setTextSize(28);
        lineChart.setDescription(desc);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            private final SimpleDateFormat mFormat = new SimpleDateFormat("dd MMM", Locale.ENGLISH);

            @Override
            public String getFormattedValue(float value) {
                long millis = (long) value * 1000L;
                return mFormat.format(new Date(millis));
            }
        });
    }

    private void setLineChartData(ArrayList<Entry> gdpGrowthRage, ArrayList<Entry> gdpCurrentUsd, ArrayList<Entry> gdpAccountBalance, ArrayList<Entry> fdiNet, ArrayList<Entry> fdiNetIn, ArrayList<Entry> fdiNetOut) {
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        if(checkbox_gdp_growth_rage.isChecked()) {
            LineDataSet gdpGrowthRageDataSet = new LineDataSet(gdpGrowthRage, "GDP Growth Rate");
            gdpGrowthRageDataSet.setDrawCircles(true);
            gdpGrowthRageDataSet.setCircleRadius(4);
            gdpGrowthRageDataSet.setDrawValues(false);
            gdpGrowthRageDataSet.setLineWidth(3);
            gdpGrowthRageDataSet.setColor(Color.GREEN);
            gdpGrowthRageDataSet.setCircleColor(Color.GREEN);
            dataSets.add(gdpGrowthRageDataSet);
        }

        if(checkbox_gdp_current_usd.isChecked()) {
            LineDataSet gdpCurrentUsdDataSet = new LineDataSet(gdpCurrentUsd, "GDP USD ");
            gdpCurrentUsdDataSet.setDrawCircles(true);
            gdpCurrentUsdDataSet.setCircleRadius(4);
            gdpCurrentUsdDataSet.setDrawValues(false);
            gdpCurrentUsdDataSet.setLineWidth(3);
            gdpCurrentUsdDataSet.setColor(Color.RED);
            gdpCurrentUsdDataSet.setCircleColor(Color.RED);
            dataSets.add(gdpCurrentUsdDataSet);
        }

        if(checkbox_current_account_balance.isChecked()) {
            LineDataSet gdpCurrentAccountBalance = new LineDataSet(gdpAccountBalance,  " GDP Current Account Balance");
            gdpCurrentAccountBalance.setDrawCircles(true);
            gdpCurrentAccountBalance.setCircleRadius(4);
            gdpCurrentAccountBalance.setDrawValues(false);
            gdpCurrentAccountBalance.setLineWidth(3);
            gdpCurrentAccountBalance.setColor(Color.YELLOW);
            gdpCurrentAccountBalance.setCircleColor(Color.YELLOW);
            dataSets.add(gdpCurrentAccountBalance);
        }

        if(checkbox_fdi_net.isChecked()) {
            LineDataSet fdiNetDataSet = new LineDataSet(fdiNet,  "FDI Net");
            fdiNetDataSet.setDrawCircles(true);
            fdiNetDataSet.setCircleRadius(4);
            fdiNetDataSet.setDrawValues(false);
            fdiNetDataSet.setLineWidth(3);
            fdiNetDataSet.setColor(Color.CYAN);
            fdiNetDataSet.setCircleColor(Color.CYAN);
            dataSets.add(fdiNetDataSet);
        }

        if(checkbox_fdi_net_in.isChecked()) {
            LineDataSet fdiNetInDataSet = new LineDataSet(fdiNetIn, "FDI Net In");
            fdiNetInDataSet.setDrawCircles(true);
            fdiNetInDataSet.setCircleRadius(4);
            fdiNetInDataSet.setDrawValues(false);
            fdiNetInDataSet.setLineWidth(3);
            fdiNetInDataSet.setColor(Color.MAGENTA);
            fdiNetInDataSet.setCircleColor(Color.MAGENTA);
            dataSets.add(fdiNetInDataSet);
        }

        if(checkbox_fdi_net_out.isChecked()){
            LineDataSet fdiNetOutDataSet = new LineDataSet(fdiNetOut, "FDI Net Out");
            fdiNetOutDataSet.setDrawCircles(true);
            fdiNetOutDataSet.setCircleRadius(4);
            fdiNetOutDataSet.setDrawValues(false);
            fdiNetOutDataSet.setLineWidth(3);
            fdiNetOutDataSet.setColor(Color.BLUE);
            fdiNetOutDataSet.setCircleColor(Color.BLUE);
            dataSets.add(fdiNetOutDataSet);
        }

        LineData lineData = new LineData(dataSets);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
