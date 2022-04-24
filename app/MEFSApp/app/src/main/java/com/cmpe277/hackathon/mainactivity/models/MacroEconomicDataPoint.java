package com.cmpe277.hackathon.mainactivity.models;

public class MacroEconomicDataPoint {
    String country;
    int year;
    //GDP parameters
    double gdp_growth_rate;
    double gdp_current_usd;
    double current_account_balance;
    double fdi_net;
    double fdi_net_in;
    double fdi_net_out;

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

    public double getGdp_growth_rate() {
        return gdp_growth_rate;
    }

    public void setGdp_growth_rate(double gdp_growth_rate) {
        this.gdp_growth_rate = gdp_growth_rate;
    }

    public double getGdp_current_usd() {
        return gdp_current_usd;
    }

    public void setGdp_current_usd(double gdp_current_usd) {
        this.gdp_current_usd = gdp_current_usd;
    }

    public double getCurrent_account_balance() {
        return current_account_balance;
    }

    public void setCurrent_account_balance(double current_account_balance) {
        this.current_account_balance = current_account_balance;
    }

    public double getFdi_net() {
        return fdi_net;
    }

    public void setFdi_net(double fdi_net) {
        this.fdi_net = fdi_net;
    }

    public double getFdi_net_in() {
        return fdi_net_in;
    }

    public void setFdi_net_in(double fdi_net_in) {
        this.fdi_net_in = fdi_net_in;
    }

    public double getFdi_net_out() {
        return fdi_net_out;
    }

    public void setFdi_net_out(double fdi_net_out) {
        this.fdi_net_out = fdi_net_out;
    }

    @Override
    public String toString() {
        return "MacroEconomicDataPoint{" +
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
}
