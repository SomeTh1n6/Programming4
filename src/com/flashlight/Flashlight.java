package com.flashlight;

public class Flashlight{
    private String Name = "фонарь";
    private StatusFlashlight status = StatusFlashlight.ELECTRIC;
    private FlashlightStatusNow statusNow = FlashlightStatusNow.OFF;

    public StatusFlashlight getStatus(){
        return this.status;
    }

    public FlashlightStatusNow getStatusNow(){
        return this.statusNow;
    }

    public String getName() {
        return Name;
    }

    public void setStatus(StatusFlashlight status){
        this.status = status;
    }

    public void changeStatus(StatusFlashlight status){
        this.status = status;
        System.out.println(getName() + " теперь имеет статус  " + this.status.getStatusFlashlight());
    }

    public void changeFlashlightStatusNow(FlashlightStatusNow statusNow){
        this.statusNow = statusNow;
        System.out.println(getName() + " теперь " + this.statusNow.getStatusFlashlightNow());
    }
}
