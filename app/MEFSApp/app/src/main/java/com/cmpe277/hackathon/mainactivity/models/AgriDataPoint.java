package com.cmpe277.hackathon.mainactivity.models;

public class AgriDataPoint {
    String country;
    int year;
    double manufactoringpercentageofgdp;
   double agrvalueadded;
    double fertilizerconsumptionperhectare;

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

    public double getManufactoringpercentageofgdp() {
        return manufactoringpercentageofgdp;
    }

    public void setManufactoringpercentageofgdp(double manufactoringpercentageofgdp) {
        this.manufactoringpercentageofgdp = manufactoringpercentageofgdp;
    }

    public double getAgrvalueadded() {
        return agrvalueadded;
    }

    public void setAgrvalueadded(double agrvalueadded) {
        this.agrvalueadded = agrvalueadded;
    }

    @Override
    public String toString() {
        return "AgriDataPoint{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", manufactoringpercentageofgdp=" + manufactoringpercentageofgdp +
                ", agrvalueadded=" + agrvalueadded +
                ", fertilizerconsumptionperhectare=" + fertilizerconsumptionperhectare +
                ", fertilizerconsumptionpercentage=" + fertilizerconsumptionpercentage +
                '}';
    }

    public double getFertilizerconsumptionperhectare() {
        return fertilizerconsumptionperhectare;
    }

    public void setFertilizerconsumptionperhectare(double fertilizerconsumptionperhectare) {
        this.fertilizerconsumptionperhectare = fertilizerconsumptionperhectare;
    }

    public double getFertilizerconsumptionpercentage() {
        return fertilizerconsumptionpercentage;
    }

    public void setFertilizerconsumptionpercentage(double fertilizerconsumptionpercentage) {
        this.fertilizerconsumptionpercentage = fertilizerconsumptionpercentage;
    }

    double  fertilizerconsumptionpercentage;
}
