package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Vehicule {

    public static AtomicInteger genId = new AtomicInteger();
    int vitesse;
    int idVehicule;
    int idAutoroute;
    int position;


    public int getVitesse() {
        return vitesse;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public int getIdAutoroute() {
        return idAutoroute;
    }

    public int getPosition() {
        return position;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public void setIdAutoroute(int idAutoroute) {
        this.idAutoroute = idAutoroute;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public Vehicule() {
        this.idVehicule = genId.getAndIncrement();
        this.idAutoroute = 5;
        this.position = 0;


    }
}



