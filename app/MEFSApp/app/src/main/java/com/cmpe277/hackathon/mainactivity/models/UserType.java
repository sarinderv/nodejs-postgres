package com.cmpe277.hackathon.mainactivity.models;

public enum UserType {
    ECON_RES("ECON Researcher"),
    GOVT_REP("Government Representative");
    private String title;
    UserType(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }
}
