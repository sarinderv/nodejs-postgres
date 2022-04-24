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

