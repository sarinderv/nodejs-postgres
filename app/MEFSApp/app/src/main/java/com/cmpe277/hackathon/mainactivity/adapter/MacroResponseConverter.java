package com.cmpe277.hackathon.mainactivity.adapter;

import com.cmpe277.hackathon.mainactivity.dto.MacroData;
import com.cmpe277.hackathon.mainactivity.entities.MacroEco;
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

    public List<MacroEconomicDataPoint> getDBDataPoints(List<MacroEco> inputs) {
        List<MacroEconomicDataPoint> dataPoints=new ArrayList<>();

        for(MacroEco macroData:inputs){
            try {
                MacroEconomicDataPoint dataPoint = new MacroEconomicDataPoint();
                dataPoint.setYear(macroData.year);
                dataPoint.setCountry(macroData.country);
                if (macroData.gdp_growth_rate != null ) {
                    dataPoint.setGdp_growth_rate(macroData.gdp_growth_rate);
                }
                if (macroData.gdp_current_usd != null ) {
                    dataPoint.setGdp_current_usd(macroData.gdp_current_usd);
                }
                if (macroData.current_account_balance != null ) {
                    dataPoint.setCurrent_account_balance(macroData.current_account_balance);
                }
                if (macroData.fdi_net != null ) {
                    dataPoint.setFdi_net(macroData.fdi_net);
                }
                if (macroData.fdi_net_in != null ) {
                    dataPoint.setFdi_net_in(macroData.fdi_net_in);
                }
                if (macroData.fdi_net_out != null ) {
                    dataPoint.setFdi_net_out(macroData.fdi_net_out);
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
