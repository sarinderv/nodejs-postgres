package com.cmpe277.hackathon.mainactivity.dto;


import java.util.List;

/*
{"year":1960,"country":"India","gdpcurrentusd":"37029883875","gdpannualgrowthpercentage":"3.722743","currentaccountbalance":null,"fdinetusd":null,"fdinetinflowspercentage":null,"fdinetoutflowspercentage":null}
*/
public class MacroAPIResponse {

    public List<MacroData> data;
    public Meta meta;

    public List<MacroData> getData() {
        return data;
    }

    public MacroAPIResponse(List<MacroData> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public void setData(List<MacroData> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
class MacroData{
    public int year;
    public String country;
    public String gdpcurrentusd;
    public String gdpannualgrowthpercentage;
    public String currentaccountbalance;
    public String fdinetusd;
    public String fdinetinflowspercentage;
    public String fdinetoutflowspercentage;

    public MacroData(int year, String country, String gdpcurrentusd, String gdpannualgrowthpercentage, String currentaccountbalance, String fdinetusd, String fdinetinflowspercentage, String fdinetoutflowspercentage) {
        this.year = year;
        this.country = country;
        this.gdpcurrentusd = gdpcurrentusd;
        this.gdpannualgrowthpercentage = gdpannualgrowthpercentage;
        this.currentaccountbalance = currentaccountbalance;
        this.fdinetusd = fdinetusd;
        this.fdinetinflowspercentage = fdinetinflowspercentage;
        this.fdinetoutflowspercentage = fdinetoutflowspercentage;
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

    public String getGdpcurrentusd() {
        return gdpcurrentusd;
    }

    public void setGdpcurrentusd(String gdpcurrentusd) {
        this.gdpcurrentusd = gdpcurrentusd;
    }

    public String getGdpannualgrowthpercentage() {
        return gdpannualgrowthpercentage;
    }

    public void setGdpannualgrowthpercentage(String gdpannualgrowthpercentage) {
        this.gdpannualgrowthpercentage = gdpannualgrowthpercentage;
    }

    public String getCurrentaccountbalance() {
        return currentaccountbalance;
    }

    public void setCurrentaccountbalance(String currentaccountbalance) {
        this.currentaccountbalance = currentaccountbalance;
    }

    public String getFdinetusd() {
        return fdinetusd;
    }

    public void setFdinetusd(String fdinetusd) {
        this.fdinetusd = fdinetusd;
    }

    public String getFdinetinflowspercentage() {
        return fdinetinflowspercentage;
    }

    public void setFdinetinflowspercentage(String fdinetinflowspercentage) {
        this.fdinetinflowspercentage = fdinetinflowspercentage;
    }

    public String getFdinetoutflowspercentage() {
        return fdinetoutflowspercentage;
    }

    public void setFdinetoutflowspercentage(String fdinetoutflowspercentage) {
        this.fdinetoutflowspercentage = fdinetoutflowspercentage;
    }
}
class Meta{
    public int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Meta(int page) {
        this.page = page;
    }
}