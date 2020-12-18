package com.korotyshka;

public enum StatusNature {
    UNKNOWN("неизвестная"),
    ACTIVE("деятельная"),
    STRONG("сильная"),
    FLIMSY("хлипкая");

    private final  String statusNature;

    StatusNature(String statusNature){
        this.statusNature = statusNature;
    }

    public String getStatusNature(){
        return statusNature;
    }
}
