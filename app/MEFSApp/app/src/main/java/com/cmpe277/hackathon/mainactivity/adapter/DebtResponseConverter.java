package com.cmpe277.hackathon.mainactivity.adapter;

import com.cmpe277.hackathon.mainactivity.dto.AgriAPIData;
import com.cmpe277.hackathon.mainactivity.dto.DebtAPIData;
import com.cmpe277.hackathon.mainactivity.models.AgriDataPoint;
import com.cmpe277.hackathon.mainactivity.models.DebtDataPoint;

import java.util.ArrayList;
import java.util.List;

public class DebtResponseConverter {
    public List<DebtDataPoint> getDataPoints(List<DebtAPIData> inputs) {
        List<DebtDataPoint> dataPoints=new ArrayList<>();

        for(DebtAPIData macroData:inputs){
            try {
                DebtDataPoint dataPoint = new DebtDataPoint();
                dataPoint.setYear(macroData.getYear());
                dataPoint.setCountry(macroData.getCountry());
                if (macroData.totalreserves != null && !macroData.totalreserves.equals("")) {
                    dataPoint.setTotalReserves(Double.parseDouble(macroData.totalreserves));
                }
                if (macroData.totalreservesimonths != null && !macroData.totalreservesimonths.equals("")) {
                    dataPoint.setTotalReservesInMonths(Integer.parseInt(macroData.totalreservesimonths));
                }
                if (macroData.totalreservespercentage != null && !macroData.totalreservespercentage.equals("")) {
                    dataPoint.setTotalReservesPercentage(Double.parseDouble(macroData.totalreservespercentage));
                }
                if (macroData.currentgni != null && !macroData.currentgni.equals("")) {
                    dataPoint.setCurrentGNI(Double.parseDouble(macroData.currentgni));
                }

                if (macroData.debtservicetotal != null && !macroData.debtservicetotal.equals("")) {
                    dataPoint.setDebtServiceTotal(Double.parseDouble(macroData.debtservicetotal));
                }
                if (macroData.debtservicepercentage != null && !macroData.debtservicepercentage.equals("")) {
                    dataPoint.setDebtServicePercentage(Double.parseDouble(macroData.debtservicepercentage));
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
