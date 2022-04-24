package com.cmpe277.hackathon.mainactivity.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;


@Entity(tableName = "macroeconomic",primaryKeys = {"year","country"})
public class MacroEco {
    @ColumnInfo(name = "country")
    @NonNull
    public String country;
    @ColumnInfo(name = "year")
    @NonNull
    public int year;
    //GDP parameters
    @ColumnInfo(name = "gdpAnnualGrowthPercentage")
    public Double gdp_growth_rate;

    @Override
    public String toString() {
        return "MacroEco{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", gdp_growth_rate=" + gdp_growth_rate +
                ", gdp_current_usd=" + gdp_current_usd +
                ", current_account_balance=" + current_account_balance +
                ", fdi_net=" + fdi_net +
                ", fdi_net_in=" + fdi_net_in +
                ", fdi_net_out=" + fdi_net_out +
                '}';
    }

    @ColumnInfo(name="gdpCurrentUSD")
    @Nullable
    public Double gdp_current_usd;
    @ColumnInfo(name="currentAccountBalance")
    @Nullable
    public Double current_account_balance;
    @ColumnInfo(name="fdiNetUSD")
    @Nullable
    public Double fdi_net;
    @ColumnInfo(name="fdiNetInflowsPercentage")
    @Nullable
    public Double fdi_net_in;
    @ColumnInfo(name="fdiNetOutflowsPercentage")
    @Nullable
    public Double fdi_net_out;
}
