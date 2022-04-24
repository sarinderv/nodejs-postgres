package com.cmpe277.hackathon.mainactivity.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
/*
CREATE TABLE agricultural (
        year                             INTEGER NOT NULL
        ,country                          VARCHAR(5)
        ,manufactoringPercentageOfGDP     NUMERIC(9,6)
        ,agrValueAdded                    NUMERIC(9,6)
        ,fertilizerConsumptionPerHectare  NUMERIC(9,6)
        ,fertilizerConsumptionPercentage  NUMERIC(9,6)
        ,created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
        ,updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
        ,PRIMARY KEY(year, country)
        );
*/
@Entity(tableName = "agricultural",primaryKeys = {"year","country"})
public class AgriData {
    @ColumnInfo(name = "country")
    @NonNull
    public String country;
    @ColumnInfo(name = "year")
    @NonNull
    public int year;
    //GDP parameters
    @ColumnInfo(name = "manufactoringPercentageOfGDP")
    public Double manufactoringPercentageOfGDP;
    @ColumnInfo(name = "agrValueAdded")
    public Double agrValueAdded;
    @ColumnInfo(name = "fertilizerConsumptionPerHectare")
    public Double fertilizerConsumptionPerHectare;
    @ColumnInfo(name = "fertilizerConsumptionPercentage")
    public Double fertilizerConsumptionPercentage;

    @Override
    public String toString() {
        return "AgriData{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", manufactoringPercentageOfGDP=" + manufactoringPercentageOfGDP +
                ", agrValueAdded=" + agrValueAdded +
                ", fertilizerConsumptionPerHectare=" + fertilizerConsumptionPerHectare +
                ", fertilizerConsumptionPercentage=" + fertilizerConsumptionPercentage +
                '}';
    }
}
