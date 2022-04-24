package com.cmpe277.hackathon.mainactivity.dto;

//{"year":1960,"country":"China","manufactoringpercentageofgdp":null,"agrvalueadded":null,"fertilizerconsumptionperhectare":null,"fertilizerconsumptionpercentage":null}
public class AgriAPIData {
    public int year;
    public String country;
    public String manufactoringpercentageofgdp;
    public String agrvalueadded;
    public String fertilizerconsumptionperhectare;
    public String fertilizerconsumptionpercentage;

    public AgriAPIData(int year, String country, String manufactoringpercentageofgdp, String agrvalueadded, String fertilizerconsumptionperhectare, String fertilizerconsumptionpercentage) {
        this.year = year;
        this.country = country;
        this.manufactoringpercentageofgdp = manufactoringpercentageofgdp;
        this.agrvalueadded = agrvalueadded;
        this.fertilizerconsumptionperhectare = fertilizerconsumptionperhectare;
        this.fertilizerconsumptionpercentage = fertilizerconsumptionpercentage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufactoringpercentageofgdp() {
        return manufactoringpercentageofgdp;
    }

    public void setManufactoringpercentageofgdp(String manufactoringpercentageofgdp) {
        this.manufactoringpercentageofgdp = manufactoringpercentageofgdp;
    }

    public String getAgrvalueadded() {
        return agrvalueadded;
    }

    public void setAgrvalueadded(String agrvalueadded) {
        this.agrvalueadded = agrvalueadded;
    }

    public String getFertilizerconsumptionperhectare() {
        return fertilizerconsumptionperhectare;
    }

    public void setFertilizerconsumptionperhectare(String fertilizerconsumptionperhectare) {
        this.fertilizerconsumptionperhectare = fertilizerconsumptionperhectare;
    }

    public String getFertilizerconsumptionpercentage() {
        return fertilizerconsumptionpercentage;
    }

    public void setFertilizerconsumptionpercentage(String fertilizerconsumptionpercentage) {
        this.fertilizerconsumptionpercentage = fertilizerconsumptionpercentage;
    }
}
