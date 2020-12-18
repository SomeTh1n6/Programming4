package com.korotyshka;

import java.util.Scanner;
import com.exceptions.*;
import com.shoes.*;
import com.flashlight.*;
import com.interfaces.*;
import java.util.Objects;

public abstract class Korotyshka implements Movement {
    private Location location;
    private Status status;
    private Status statusSecond;
    private String name;
    private StatusNature statusNature;
    private ConditionKorotyshka conditionKorotyshka;

    public Korotyshka(Location location, Status status, Status statusSecond ,
                      String name, ConditionKorotyshka conditionKorotyshka, StatusNature statusNature){
        this.location = location;
        this.status = status;
        this.statusSecond = statusSecond;
        this.name = name;
        this.conditionKorotyshka = conditionKorotyshka;
        this.statusNature = statusNature;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String Name) throws NameCheck {
        try {
            if (Name.equals("")) {
                throw new NameCheck("Внимание! Имя не может быть пустой строкой");
            }
            this.name = Name;
        } catch (NameCheck nameCheck) {
            System.out.println(nameCheck.getMessage());
            System.out.println("Введите корректное имя персонажа: ");
            Scanner in = new Scanner(System.in);
            String newName = in.nextLine();
            if (newName.equals("")) {
                System.out.println("Имя не было введено. Используется имя по умолчанию - Unknown Person \n");
                this.name = "Unknown Person";
            }
        }
    }


    public void changeLocation(Location location){
        this.location = location;
        System.out.println(this.getName() + " перемещается на локацию " + location.getLocation());
    }

    public void changeStatusNature(StatusNature statusNature){
        this.statusNature = statusNature;
        System.out.println(this.getName() + " теперь натура " + statusNature.getStatusNature());
    }

    public String getStatusNature(){
        return this.statusNature.getStatusNature();
    }

    public void folowExample(Korotyshka korotyshka){
        System.out.println(this.getName() + " следует примеру персонажа " + korotyshka.getName());
    }

    public void getUp(){ // встает
        System.out.println(this.getName() + " встает на локации "
                + this.location.getLocation() + " испытывая " + this.status.getStatus());
    }

    public void groan(){ // кряхтит
        System.out.println(this.getName() + " кряхтит на локации " + this.location.getLocation() +
                " испытывая " + this.status.getStatus());
    }

    public void grunt(){ // крякнул
        System.out.println(this.getName() + " крякает на локации " + this.location.getLocation() +
                " испытывая " + this.status.getStatus());
    }

    public void goesFor(Korotyshka korotyshka) {
        System.out.println(this.getName() + " идет за " + korotyshka.getName() + " на локации " +  this.location.getLocation() +
                " испытывая " + this.status.getStatus());
    }

    public void sitBeside(Korotyshka korotyshka) {
        System.out.println(this.getName() + " присаживается рядом с персонажем " + korotyshka.getName());
    }

    public void sit(){
        System.out.println(this.conditionKorotyshka.getConditionKorotyshka() + " " + getName() + " сидит");
    }


    @Override
    public void goAhead() {
        System.out.println(this.conditionKorotyshka.getConditionKorotyshka() + " " + this.getName() + " идет вперед на локации " +  this.location.getLocation() +
                " испытывая " + this.status.getStatus());
    }

    @Override
    public void goBack() {
        System.out.println(this.conditionKorotyshka.getConditionKorotyshka() + " " + this.getName() + " идет назад на локации " +  this.location.getLocation() +
                " испытывая " + this.status.getStatus());
    }

    @Override
    public void goLeft() {
        System.out.println(this.conditionKorotyshka.getConditionKorotyshka() + " " + this.getName() + " идет влево на локации " +  this.location.getLocation() +
                " испытывая " + this.status.getStatus());
    }

    @Override
    public void goRight() {
        System.out.println(this.conditionKorotyshka.getConditionKorotyshka() + " " + this.getName() + " идет вправо на локации " +  this.location.getLocation() +
                " испытывая " + this.status.getStatus());
    }

    public String someonePushKorotyshka(String thing){
        return ( thing + " толкает его (персонажа " + this.getName() + ")");
    }

    public void putOn(Boots boots){
        System.out.println(this.getName() + " надевает " + boots.getName());
    }

    public void want(String string){
        System.out.println(this.getName() + " хочет сделать: " + string);
    }

    public void changeStatus(Status status){
        this.status = status;
        System.out.println(this.getName() + " теперь испытывает " + status.getStatus());
    }

    public void changeStatusSecond(Status statusSecond){
        this.statusSecond = statusSecond;
        System.out.println(this.getName() + " теперь испытывает еще и " + statusSecond.getStatus());
    }

    public void getFlashlight(Flashlight flashlight){
        System.out.println(this.getName() + " берет " + flashlight.getStatus().getStatusFlashlight() + " " + flashlight.getName());
    }

    public void changeConditionKorotyshka(ConditionKorotyshka conditionKorotyshka){
        this.conditionKorotyshka = conditionKorotyshka;
        //System.out.println(this.getName() + " теперь имеет состояние  " + this.conditionKorotyshka.getConditionKorotyshka());
    }

    public String getStatus(){
        return this.status.getStatus();
    }

    public String getStatusSecond(){
        return this.statusSecond.getStatus();
    }

    @Override
    public boolean equals(Object object){
        if (object == null || object.getClass() != this.getClass()){
            return false;
        }
        if (this == object){
            return true;
        }
        Korotyshka other = (Korotyshka) object;
        return Objects.equals(name, other.name);
    }

    public String jumpToTryWarm(){
        return (getName() + " прыгает для того чтобы было: ' " + this.warm() + " '");
    }

    public String warm(){
        return (getName() + " согревается");
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString(){
        return this.name;
    }




    public static class BodyPart {
        private String name;

        public BodyPart(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

        public String claps(Korotyshka korotyshka){
            return (korotyshka.getName() + " хлопает частью тела " + getName());
        }

        public String shake(Korotyshka korotyshka){
            return (korotyshka.getName() + " трясет частью тела " + getName());
        }

        public void hurts(Korotyshka korotyshka){
            System.out.println(getName() + " персонажа " + korotyshka.getName() + " болят");
        }

        public void freezes(Korotyshka korotyshka) {
            System.out.println(getName() + " персонажа " + korotyshka.getName() + " замерзли");
        }

        public void haveThePower(Korotyshka korotyshka){
            System.out.println(getName() + " персонажа " + korotyshka.getName() + " обладают силой");
        }

        public void whines(Korotyshka korotyshka){
            System.out.println(getName() + " персонажа " + korotyshka.getName() + " ноют");
        }
    }

    public static class Eyes{
        private final String name = "Глаза";

        public String getName(){
            return this.name;
        }

        public void see(Korotyshka korotyshka){
            System.out.println(korotyshka.conditionKorotyshka.getConditionKorotyshka() +
                    " " + korotyshka.getName() + " смотрит по сторонам " + this.getName() + "ми");
        }

        public String accustomed(Korotyshka korotyshka){
            return  (this.getName() + " персонажа " + korotyshka.getName() + " привыкают к " );
        }
    }

    public void TryToWarm(BodyPart bodyPart){
        System.out.println(this.getName() + " " + this.jumpToTryWarm() + ". " + bodyPart.claps(this) + ", " +
                bodyPart.shake(this));
    }
}
