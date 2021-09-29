package com.company;

import java.util.ArrayList;
import java.util.List;

public class Autoroute {
    private int id_autoroute;
    private List<Acces> l_acces;
    private List<Vehicule> l_vehicule;
    private int nb_acces;
    private float material;
    private int circonference;

    public Autoroute(int nb_acces)
    {
        this.circonference = id_autoroute * 50;
        this.nb_acces = l_acces.size();
        this.l_vehicule = new ArrayList<>();
        this.l_acces = new ArrayList<>(nb_acces);
        int mat_rand = (int)Math.floor(Math.random()*(3-1+1)+1);
        switch (mat_rand)
        {
            case 1:
                this.material = 0.5f;
                break;
            case 2:
                this.material = 1f;
                break;
            case 3:
                this.material = 1.5f;
                break;
            default:
                this.material = 1f;
                break;
        }

        for (int i = 0; i < nb_acces; i++)
        {
            this.l_acces.get(i).setEmplacement(((circonference)/nb_acces) * i);
        }
    }

    public Autoroute()
    {
        this.circonference = id_autoroute * 50;
        this.nb_acces = l_acces.size();
        this.l_vehicule = new ArrayList<>();
        int rand_nb_acces = (int)Math.floor(Math.random()*(6-2+1)+2);
        this.l_acces = new ArrayList<>(rand_nb_acces);
        int mat_rand = (int)Math.floor(Math.random()*(3-1+1)+1);
        switch (mat_rand)
        {
            case 1:
                this.material = 0.5f;
                break;
            case 2:
                this.material = 1f;
                break;
            case 3:
                this.material = 1.5f;
                break;
            default:
                this.material = 1f;
                break;
        }

        for (int i = 0; i < nb_acces; i++)
        {
            this.l_acces.get(i).setEmplacement(((circonference)/nb_acces) * i);
        }
    }

    public List<Acces> getL_acces() {
        return l_acces;
    }

    public void setL_acces(List<Acces> l_acces) {
        this.l_acces = l_acces;
    }

    public List<Vehicule> getL_vehicule() {
        return l_vehicule;
    }

    public void setL_vehicule(List<Vehicule> l_vehicule) {
        this.l_vehicule = l_vehicule;
    }

    public int getNb_acces() {
        return nb_acces;
    }

    public void setNb_acces(int nb_acces) {
        this.nb_acces = nb_acces;
    }
}
