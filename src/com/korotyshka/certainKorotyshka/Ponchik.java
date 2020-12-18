package com.korotyshka.certainKorotyshka;

import com.researches.*;
import com.korotyshka.*;
import com.korotyshka.*;
import com.place.tunnel.*;

import java.util.Objects;

public class Ponchik extends Korotyshka {
    private Location location = Location.CAVE;
    private Status status = Status.UNWILLINGNESS;
    private Status statusSecond = Status.UNUNFATIGUE;
    private ConditionKorotyshka conditionKorotyshka = ConditionKorotyshka.UNDESIRABLY;
    private String name = "Пончик";
    private StatusNature statusNature = StatusNature.FLIMSY;

    public Ponchik(Location location, Status status, Status statusSecond,
                   String name, ConditionKorotyshka conditionKorotyshka, StatusNature statusNature) {
        super(location, status, statusSecond ,name, conditionKorotyshka, statusNature);
    }

    public void speech(Tunnel.Darkness darkness, Researches researches){
        System.out.println(getName() + " сказал, что " + researches.getName() + " проводить нельзя в такой " + darkness.getName());
    }

    public void goes(int howMuch, Korotyshka korotyshka){
        String howMuchString;
        if (howMuch == 1){
            howMuchString = "";
        }
        else if (howMuch == 2){
            howMuchString = "Вдвойне ";
        }
        else if (howMuch == 3){
            howMuchString = "Втройне ";
        }
        else if (howMuch <= 0){
            howMuchString = "Error ";
        }
        else {
            howMuchString = "Неимоверно ";
        }
        System.out.println(howMuchString + conditionKorotyshka.getConditionKorotyshka()
                + " " + this.getName() + " продолжает идти за " + korotyshka.getName());
    }

}
