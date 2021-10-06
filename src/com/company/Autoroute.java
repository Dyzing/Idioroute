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
        ++id_autoroute;
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
        this.l_vehicule = new ArrayList<Vehicule>();
        int rand_nb_acces = (int)Math.floor(Math.random()*(6-2+1)+2);
        this.l_acces = new ArrayList<Acces>(rand_nb_acces);
        this.nb_acces = l_acces.size();
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

    public Vehicule move_car(int id)
    {
        Vehicule v = l_vehicule.get(id);
        v.setPosition(v.getPosition() + v.getVitesse());


        return v;
    }

    public void prediction_move_car(int id)
    {
        Vehicule v;
        Vehicule w;
        boolean bAccident = true;
        int nb_vehicule = l_vehicule.size();
        for (int i = 0; i < nb_vehicule; i++)
        {
            if(l_vehicule.get(i).idVehicule == id)
            {
                v = l_vehicule.get(i);
                w = l_vehicule.get(i + 1);
                for (int j = i; j < nb_vehicule - 1; j++)
                {
                    Vehicule a, b;
                    a = l_vehicule.get(i);
                    b = l_vehicule.get(j+1);

                    try {
                        int positionA, positionB;
                        positionA = move_car(move_car(a.getIdVehicule()).getIdVehicule()).getPosition();
                        positionB = move_car(move_car(b.getIdVehicule()).getIdVehicule()).getPosition();
                        if (positionA >= positionB)
                        {
                            for (int k = 0; k < nb_acces; k++)
                            {
                                if((v.getPosition() <= l_acces.get(k).getEmplacement()) && (l_acces.get(k).getEmplacement() <= w.getPosition()))
                                {
                                    //gerer l'évitemment de accident -> appel à une fonction d'Idioroute avec acces et voiture en paramètre
                                    v.setNeed_move(true);
                                    bAccident = false;
                                    break;
                                }
                            }
                            if(bAccident == true)
                            {
                                throw new Exception();
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                        System.out.println("Accident");
                    }
                }

                v = move_car(i);
                break;
            }
        }
    }

}
