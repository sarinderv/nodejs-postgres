package com.cmpe277.hackathon.mainactivity.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

//year,country,totalReservesInMonths,totalReserves,currentGNI,totalReservesPercentage,debtServiceTotal,debtServicePercentage
@Entity(tableName = "debt",primaryKeys = {"year","country"})
public class DebtData {
    @ColumnInfo(name = "country")
    @NonNull
    public String country;
    @ColumnInfo(name = "year")
    @NonNull
    public int year;
    @ColumnInfo(name = "totalReservesInMonths")
    public Integer totalReservesInMonths;


    @ColumnInfo(name="totalReserves")
    @Nullable
    public Double totalReserves;
    @ColumnInfo(name="currentGNI")
    @Nullable
    public Double currentGNI;
    @ColumnInfo(name="totalReservesPercentage")
    @Nullable
    public Double totalReservesPercentage;
    @ColumnInfo(name="debtServiceTotal")
    @Nullable
    public Double debtServiceTotal;
    @ColumnInfo(name="debtServicePercentage")
    @Nullable
    public Double debtServicePercentage;

    @Override
    public String toString() {
        return "DebtData{" +
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
