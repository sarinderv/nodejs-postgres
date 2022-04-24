package com.cmpe277.hackathon.mainactivity.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.cmpe277.hackathon.mainactivity.Dashboard;
import com.cmpe277.hackathon.mainactivity.R;
import com.cmpe277.hackathon.mainactivity.adapter.MacroResponseConverter;
import com.cmpe277.hackathon.mainactivity.client.RetrofitClientInstance;
import com.cmpe277.hackathon.mainactivity.databinding.FragmentHomeBinding;
import com.cmpe277.hackathon.mainactivity.dto.MacroAPIResponse;
import com.cmpe277.hackathon.mainactivity.models.MacroEconomicDataPoint;
import com.cmpe277.hackathon.mainactivity.service.IMacroService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        AnyChartView anyChartView = root.findViewById(R.id.any_chart_view);

        // make REST call to retrieve data
        IMacroService service = RetrofitClientInstance.getRetrofitInstance().create(IMacroService.class);
        Call<MacroAPIResponse> call = service.getMacroDetails();
        Context context = getContext();
        call.enqueue(new Callback<MacroAPIResponse>() {
            @Override
            public void onResponse(Call<MacroAPIResponse> call, Response<MacroAPIResponse> response) {
                MacroResponseConverter converter=new MacroResponseConverter();
                List<MacroEconomicDataPoint> points=converter.getDataPoints(response.body().getData());

                List<DataEntry> data = new ArrayList<>();

                points.stream().filter(medp -> medp.getCountry() == "USA").forEach((obj)->{
                    //data.add(new ValueDataEntry(obj.getYear(), obj.getGdp_current_usd());
                });
                Toast.makeText(context, "Data loaded "+response.body().data.size(), Toast.LENGTH_SHORT).show();

                Cartesian cartesian = AnyChart.column();

                data.add(new ValueDataEntry("Rouge", 80540));
                data.add(new ValueDataEntry("Foundation", 94190));
                data.add(new ValueDataEntry("Mascara", 102610));
                data.add(new ValueDataEntry("Lip gloss", 110430));
                data.add(new ValueDataEntry("Lipstick", 128000));
                data.add(new ValueDataEntry("Nail polish", 143760));
                data.add(new ValueDataEntry("Eyebrow pencil", 170670));
                data.add(new ValueDataEntry("Eyeliner", 213210));
                data.add(new ValueDataEntry("Eyeshadows", 249980));

                System.out.println("data="+ data.size());
                Column column = cartesian.column(data);

                column.tooltip()
                        .titleFormat("{%X}")
                        .position(Position.CENTER_BOTTOM)
                        .anchor(Anchor.CENTER_BOTTOM)
                        .offsetX(0d)
                        .offsetY(5d)
                        .format("${%Value}{groupsSeparator: }");

                cartesian.animation(true);
                cartesian.title("GDP by Year");

                cartesian.yScale().minimum(0d);

                cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");

                cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
                cartesian.interactivity().hoverMode(HoverMode.BY_X);

                cartesian.xAxis(0).title("Product");
                cartesian.yAxis(0).title("Dollars");

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}