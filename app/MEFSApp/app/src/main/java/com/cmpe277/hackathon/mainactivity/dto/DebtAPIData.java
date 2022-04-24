package com.cmpe277.hackathon.mainactivity.dto;

import java.util.List;

public class DebtAPIData {
    public String country;
    public int year;
    public String totalreservesimonths;
    public String totalreserves;
    public String currentgni;
    public String totalreservespercentage;
    public String debtservicetotal;
    public String debtservicepercentage;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTotalreservesimonths() {
        return totalreservesimonths;
    }

    public void setTotalreservesimonths(String totalreservesimonths) {
        this.totalreservesimonths = totalreservesimonths;
    }

    public String getTotalreserves() {
        return totalreserves;
    }

    public void setTotalreserves(String totalreserves) {
        this.totalreserves = totalreserves;
    }

    public String getCurrentgni() {
        return currentgni;
    }

    public void setCurrentgni(String currentgni) {
        this.currentgni = currentgni;
    }

    public String getTotalreservespercentage() {
        return totalreservespercentage;
    }

    public void setTotalreservespercentage(String totalreservespercentage) {
        this.totalreservespercentage = totalreservespercentage;
    }

    public String getDebtservicetotal() {
        return debtservicetotal;
    }

    public void setDebtservicetotal(String debtservicetotal) {
        this.debtservicetotal = debtservicetotal;
    }

    public String getDebtservicepercentage() {
        return debtservicepercentage;
    }

    public void setDebtservicepercentage(String debtservicepercentage) {
        this.debtservicepercentage = debtservicepercentage;
    }

    public DebtAPIData(String country, int year, String totalreservesimonths, String totalreserves, String currentgni, String totalreservespercentage, String debtservicetotal, String debtservicepercentage) {
        this.country = country;
        this.year = year;
        this.totalreservesimonths = totalreservesimonths;
        this.totalreserves = totalreserves;
        this.currentgni = currentgni;
        this.totalreservespercentage = totalreservespercentage;
        this.debtservicetotal = debtservicetotal;
        this.debtservicepercentage = debtservicepercentage;
    }
}
