package com.company;

public class Camion extends Vehicule {

    public Camion()
    {
        super();
        this.vitesse = 80;

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
