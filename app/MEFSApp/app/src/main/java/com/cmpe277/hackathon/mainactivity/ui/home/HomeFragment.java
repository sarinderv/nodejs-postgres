package com.cmpe277.hackathon.mainactivity.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.cmpe277.hackathon.mainactivity.R;
import com.cmpe277.hackathon.mainactivity.adapter.MacroResponseConverter;
import com.cmpe277.hackathon.mainactivity.client.RetrofitClientInstance;
import com.cmpe277.hackathon.mainactivity.databinding.FragmentHomeBinding;
import com.cmpe277.hackathon.mainactivity.dto.MacroAPIResponse;
import com.cmpe277.hackathon.mainactivity.models.MacroEconomicDataPoint;
import com.cmpe277.hackathon.mainactivity.service.IMacroService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Cartesian cartesian;
Set set;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Context context = getContext();

        String[] items = new String[]{"USA", "India", "China"};
        Map<String, List<DataEntry>> countryData = new HashMap<>(); // country->data hashmap
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, items);
        Spinner dropdown = root.findViewById(R.id.country_spinner);
        dropdown.setAdapter(adapter);
        AnyChartView anyChartView = root.findViewById(R.id.any_chart_view);

        // make REST call to retrieve data
        IMacroService service = RetrofitClientInstance.getRetrofitInstance().create(IMacroService.class);
        Call<MacroAPIResponse> call = service.getMacroDetails();
        call.enqueue(new Callback<MacroAPIResponse>() {
            @Override
            public void onResponse(Call<MacroAPIResponse> call, Response<MacroAPIResponse> response) {
                MacroResponseConverter converter=new MacroResponseConverter();
                List<MacroEconomicDataPoint> points=converter.getDataPoints(response.body().getData());

                // on REST response, populate the country->data hashmap
                for (String country : items) {
                    List<DataEntry> data = new ArrayList<>();
                    points.stream().filter(medp -> medp.getCountry().equalsIgnoreCase(country)).forEach((obj)->{
                        data.add(new ValueDataEntry(obj.getYear(), obj.getGdp_current_usd()));
                    });
                    countryData.put(country, data);
                }
                Toast.makeText(context, "MacroEconomic data loaded "+response.body().data.size(), Toast.LENGTH_SHORT).show();

                dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                        // if country changed then get the new data and refresh the chart, only the y-axis needs to be refreshed
                        Toast.makeText(context, "Country: "+ items[position], Toast.LENGTH_SHORT).show();
                       // cartesian.column(countryData.get(items[position]));
                        List<DataEntry> entries=countryData.get(items[position]);
                        //cartesian = newCartesian(entries, "GDP by Year");
                        set.data(entries);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parentView) {
                    }

                });

                String country = dropdown.getSelectedItem().toString();
                List<DataEntry> data = countryData.get(country);
                set = Set.instantiate();
                set.data(data);
                Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");

                cartesian = newCartesian(series1Data, "GDP by Year");
                anyChartView.setChart(cartesian);
            }

            @Override
            public void onFailure(Call<MacroAPIResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private Cartesian newCartesian(Mapping seriesData, String title) {
        Cartesian cartesian =  AnyChart.column();
        Column column = cartesian.column(seriesData);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("${%Value}{groupsSeparator: }");
        cartesian.animation(true);
        cartesian.title(title);
        cartesian.yScale().minimum(0d);
        cartesian.yAxis(0).labels().format("{%seriesName}: {%value}{scale:(1)(1000)(1000)(1000)(1000)|( d)( th)( M)( B)( T)}");
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);
        cartesian.yAxis(0).title("$(USD)");

        return cartesian;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}