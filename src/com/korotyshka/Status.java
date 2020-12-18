package com.korotyshka;

public enum Status {
    UNWILLINGNESS("нежелание"), // нежелание
    UNTHINKABLE("немыслимость"), // немыслимо
    ANNOYANCE("досада"), // досада
    FATIGUE("усталость"), // усталость
    COLDLY("холод"), // холодно (действие низкой температуры)
    CHEERFULLY("бодрость"), // бодро
    SEEMS("неувереность (персонажу кажется)"), // кажется
    INTEREST("интерес"),
    UNUNFATIGUE("нет усталости"),
    UNCOLDLY("не холодно"),
    UNKNOWN("неизвестное чувство");

    private final  String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

}
