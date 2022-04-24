package com.cmpe277.hackathon.mainactivity.dto;

import java.util.List;

public class AgriAPIResponse {

    public List<AgriAPIData> data;
    public Meta meta;

    public List<AgriAPIData> getData() {
        return data;
    }

    public AgriAPIResponse(List<AgriAPIData> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public void setData(List<AgriAPIData> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
