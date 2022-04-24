package com.cmpe277.hackathon.mainactivity.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;

public class DebtDataPoint {
    public String country;
    public int year;
    public int totalReservesInMonths;
    public double totalReserves;
    public double currentGNI;
    public double totalReservesPercentage;
    public double debtServiceTotal;
    public double debtServicePercentage;

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

    public int getTotalReservesInMonths() {
        return totalReservesInMonths;
    }

    public void setTotalReservesInMonths(int totalReservesInMonths) {
        this.totalReservesInMonths = totalReservesInMonths;
    }

    public double getTotalReserves() {
        return totalReserves;
    }

    public void setTotalReserves(double totalReserves) {
        this.totalReserves = totalReserves;
    }

    public double getCurrentGNI() {
        return currentGNI;
    }

    public void setCurrentGNI(double currentGNI) {
        this.currentGNI = currentGNI;
    }

    public double getTotalReservesPercentage() {
        return totalReservesPercentage;
    }

    public void setTotalReservesPercentage(double totalReservesPercentage) {
        this.totalReservesPercentage = totalReservesPercentage;
    }

    public double getDebtServiceTotal() {
        return debtServiceTotal;
    }

    public void setDebtServiceTotal(double debtServiceTotal) {
        this.debtServiceTotal = debtServiceTotal;
    }

    public double getDebtServicePercentage() {
        return debtServicePercentage;
    }

    public void setDebtServicePercentage(double debtServicePercentage) {
        this.debtServicePercentage = debtServicePercentage;
    }

    @Override
    public String toString() {
        return "DebtDataPoint{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", totalReservesInMonths=" + totalReservesInMonths +
                ", totalReserves=" + totalReserves +
                ", currentGNI=" + currentGNI +
                ", totalReservesPercentage=" + totalReservesPercentage +
                ", debtServiceTotal=" + debtServiceTotal +
                ", debtServicePercentage=" + debtServicePercentage +
                '}';
    }
}
