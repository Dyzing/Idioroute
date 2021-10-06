package com.company;

public class Camion extends Vehicule {

    public Camion()
    {
        super();
        this.vitesse = 80;

    }

    @Override
    public String toString() {
        return "Camion{" +
                "vitesse=" + vitesse +
                ", idAutoroute=" + idAutoroute +
                ", idVehicule=" + idVehicule +
                ", position =" + position;
    }
}
