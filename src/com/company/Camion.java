package com.company;

public class Camion extends Vehicule {

    public Camion()
    {
        this.setVitesse(80);
    }

    @Override
    public boolean isNeed_move() {
        return super.isNeed_move();
    }

    @Override
    public void setNeed_move(boolean need_move) {
        super.setNeed_move(need_move);
    }

    @Override
    public int getVitesse() {
        return super.getVitesse();
    }

    @Override
    public int getIdVehicule() {
        return super.getIdVehicule();
    }

    @Override
    public int getIdAutoroute() {
        return super.getIdAutoroute();
    }

    @Override
    public int getPosition() {
        return super.getPosition();
    }

    @Override
    public void setVitesse(int vitesse) {
        super.setVitesse(vitesse);
    }

    @Override
    public void setIdVehicule(int idVehicule) {
        super.setIdVehicule(idVehicule);
    }

    @Override
    public void setIdAutoroute(int idAutoroute) {
        super.setIdAutoroute(idAutoroute);
    }

    @Override
    public void setPosition(int position) {
        super.setPosition(position);
    }

    @Override
    public String toString() {
        return "Camion{" +
                "vitesse=" + getVitesse() +
                ", idAutoroute=" + getIdAutoroute() +
                ", idVehicule=" + getIdVehicule() +
                ", position =" + getPosition();
    }
}
