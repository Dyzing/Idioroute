package com.company;

public class Voiture extends Vehicule {

    public Voiture()
    {
        super();
        this.vitesse = 100;

    }

    @Override
    public String toString() {
        return "Voiture{" +
                "vitesse=" + vitesse +
                ", idAutoroute=" + idAutoroute +
                ", idVehicule=" + idVehicule +
                ", position =" + position;
    }
}
