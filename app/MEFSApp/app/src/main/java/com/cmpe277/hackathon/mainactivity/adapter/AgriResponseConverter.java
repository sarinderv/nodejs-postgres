package com.cmpe277.hackathon.mainactivity.adapter;

import com.cmpe277.hackathon.mainactivity.dto.AgriAPIData;
import com.cmpe277.hackathon.mainactivity.dto.MacroData;
import com.cmpe277.hackathon.mainactivity.models.AgriDataPoint;
import com.cmpe277.hackathon.mainactivity.models.MacroEconomicDataPoint;

import java.util.ArrayList;
import java.util.List;

public class AgriResponseConverter {
    public List<AgriDataPoint> getDataPoints(List<AgriAPIData> inputs){
        List<AgriDataPoint> dataPoints=new ArrayList<>();

        for(AgriAPIData macroData:inputs){
            try {
                AgriDataPoint dataPoint = new AgriDataPoint();
                dataPoint.setYear(macroData.getYear());
                dataPoint.setCountry(macroData.getCountry());
                if (macroData.fertilizerconsumptionpercentage != null && !macroData.fertilizerconsumptionpercentage.equals("")) {
                    dataPoint.setFertilizerconsumptionpercentage(Double.parseDouble(macroData.fertilizerconsumptionpercentage));
                }
                if (macroData.manufactoringpercentageofgdp != null && !macroData.manufactoringpercentageofgdp.equals("")) {
                    dataPoint.setManufactoringpercentageofgdp(Double.parseDouble(macroData.manufactoringpercentageofgdp));
                }
                if (macroData.agrvalueadded != null && !macroData.agrvalueadded.equals("")) {
                    dataPoint.setAgrvalueadded(Double.parseDouble(macroData.agrvalueadded));
                }
                if (macroData.fertilizerconsumptionperhectare != null && !macroData.fertilizerconsumptionperhectare.equals("")) {
                    dataPoint.setFertilizerconsumptionperhectare(Double.parseDouble(macroData.fertilizerconsumptionperhectare));
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
