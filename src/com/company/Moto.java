package com.company;

public class Moto extends Vehicule{

    public Moto()
    {
        super();
        this.vitesse = 120;

    }

    @Override
    public String toString() {
        return "Voiture{" +
                "vitesse=" + vitesse +
                ", idAutoroute=" + idAutoroute +
                ", idVehicule=" + idVehicule +
                ", position =" + position ;
    }
}
