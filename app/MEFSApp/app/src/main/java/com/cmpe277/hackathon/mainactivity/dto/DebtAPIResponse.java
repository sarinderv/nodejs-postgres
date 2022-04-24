package com.cmpe277.hackathon.mainactivity.dto;

import java.util.List;

public class DebtAPIResponse {
    public List<DebtAPIData> data;
    public Meta meta;

    public List<DebtAPIData> getData() {
        return data;
    }

    public void setData(List<DebtAPIData> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public DebtAPIResponse(List<DebtAPIData> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }
}
