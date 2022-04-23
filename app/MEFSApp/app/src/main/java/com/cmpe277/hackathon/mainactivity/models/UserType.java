package com.cmpe277.hackathon.mainactivity.models;



public enum UserType {
    None("None"),
    ECON_RES("ECON Researcher"),
    GOVT_REP("Government Representative");

    private String title;
    UserType(String title){
        this.title=title;
    }
    public static UserType valueOfOrDefault(String myValue) {
        for(UserType type : UserType.class.getEnumConstants()) {
            if(type.toString().equals(myValue)) {
                return type;
            }
        }
        return UserType.None;
    }
    public String toString() {
        return title;
    }
    public String getTitle() {
        return title;
    }
}
