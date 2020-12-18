package com.korotyshka.certainKorotyshka;

import com.korotyshka.*;
import com.korotyshka.*;
import com.researches.Researches;

import java.util.Objects;

public class Neznaika extends Korotyshka {
    private Location location = Location.CAVE;
    private Status status = Status.INTEREST;
    private Status statusSecond = Status.UNUNFATIGUE;
    private String name = "Незнайка";
    private ConditionKorotyshka conditionKorotyshka = ConditionKorotyshka.WITH_PLEASURE;
    private StatusNature statusNature = StatusNature.ACTIVE;

    public Neznaika(Location location, Status status, Status statusSecond,
                    String name, ConditionKorotyshka conditionKorotyshka, StatusNature statusNature) {
        super(location, status, statusSecond , name, conditionKorotyshka, statusNature);
    }

    public void speech(Korotyshka korotyshka, Researches researches){
        System.out.println(this.getName() + " говорит , что необходимо провести " +
                researches.getName() + " персонажем " + korotyshka.getName());
    }

}