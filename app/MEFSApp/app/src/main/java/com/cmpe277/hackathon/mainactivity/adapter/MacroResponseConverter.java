package com.cmpe277.hackathon.mainactivity.adapter;

import com.cmpe277.hackathon.mainactivity.dto.MacroData;
import com.cmpe277.hackathon.mainactivity.models.MacroEconomicDataPoint;

import java.util.ArrayList;
import java.util.List;

public class MacroResponseConverter {
    public List<MacroEconomicDataPoint> getDataPoints(List<MacroData> inputs){
        List<MacroEconomicDataPoint> dataPoints=new ArrayList<>();

        for(MacroData macroData:inputs){
            try {
                MacroEconomicDataPoint dataPoint = new MacroEconomicDataPoint();
                dataPoint.setYear(macroData.getYear());
                dataPoint.setCountry(macroData.getCountry());
                if (macroData.gdpannualgrowthpercentage != null && !macroData.gdpannualgrowthpercentage.equals("")) {
                    dataPoint.setGdp_growth_rate(Double.parseDouble(macroData.gdpannualgrowthpercentage));
                }
                if (macroData.gdpcurrentusd != null && !macroData.gdpcurrentusd.equals("")) {
                    dataPoint.setGdp_current_usd(Double.parseDouble(macroData.gdpcurrentusd));
                }
                if (macroData.currentaccountbalance != null && !macroData.currentaccountbalance.equals("")) {
                    dataPoint.setCurrent_account_balance(Double.parseDouble(macroData.currentaccountbalance));
                }
                if (macroData.fdinetusd != null && !macroData.fdinetusd.equals("")) {
                    dataPoint.setFdi_net(Double.parseDouble(macroData.fdinetusd));
                }
                if (macroData.fdinetinflowspercentage != null && !macroData.fdinetinflowspercentage.equals("")) {
                    dataPoint.setFdi_net_in(Double.parseDouble(macroData.fdinetinflowspercentage));
                }
                if (macroData.fdinetoutflowspercentage != null && !macroData.fdinetoutflowspercentage.equals("")) {
                    dataPoint.setFdi_net_out(Double.parseDouble(macroData.fdinetoutflowspercentage));
                }
                dataPoints.add(dataPoint);
            }
            catch(Exception er){
                System.out.println(er.toString());
            }
        }
        return dataPoints;
    }
}
