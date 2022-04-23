package com.cmpe277.hackathon.mainactivity.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.Date;
/*
year integer,
        country character varying(255) NOT NULL,
        gdpCurrentUSD bigint,
        gdpAnnualGrowthPercentage integer,
        currentAccountBalance bigint,
        fdiNetUSD bigint,
        fdiNetInflowsPercentage integer,
        fdiNetOutflowsPercentage integer,
        created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
        updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
        PRIMARY KEY(year, country)
*/

@Entity(tableName = "macroeconomic",primaryKeys = {"year","country"})
public class MacroEco {

    String country;
    int year;
    //GDP parameters
    @ColumnInfo(name = "gdpAnnualGrowthPercentage")
    double gdp_growth_rate;
    @ColumnInfo(name="gdpCurrentUSD")
    double gdp_current_usd;
    @ColumnInfo(name="currentAccountBalance")
    double current_account_balance;
    double fdi_net;
    double fdi_net_in;
    double fdi_net_out;
    Date create_at;
    Date updated_at;
}
