package com.company;

import java.util.ArrayList;
import java.util.List;

public class Autoroute {
    private static int id_autoroute;
    private List<Acces> l_acces;
    private List<Vehicule> l_vehicule;
    private int nb_acces;
    private float material;
    private int circonference;

    public Autoroute(int nb_acces)
    {
        this.id_autoroute = ++id_autoroute;
        this.circonference = id_autoroute * 50;
        this.l_vehicule = new ArrayList<Vehicule>();

        this.l_acces = new ArrayList<Acces>(nb_acces); //risque de péter car il n'y a rien dedans
        for (int i = 0; i < nb_acces; i++)
            this.l_acces.add(new Acces());
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
            if(i == 0)
            {
                l_acces.get(i).setIs_entry(true);
            }
            else if(i == nb_acces - 1)
            {
                l_acces.get(i).setIs_exit(true);
            }

            this.l_acces.get(i).setEmplacement(((circonference)/nb_acces) * i);
        }
    }

    public Autoroute()
    {
        this.id_autoroute = ++id_autoroute;
        this.circonference = (6 - id_autoroute) * 240;
        this.l_vehicule = new ArrayList<Vehicule>();
        int rand_nb_acces = (int)Math.floor(Math.random()*(6-2+1)+2);
        this.l_acces = new ArrayList<Acces>(rand_nb_acces);
        for (int i = 0; i < rand_nb_acces; i++)
            this.l_acces.add(new Acces());
        this.nb_acces = rand_nb_acces;
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
            if(i == 0)
            {
                l_acces.get(i).setIs_entry(true);
            }
            else if(i == nb_acces - 1)
            {
                l_acces.get(i).setIs_exit(true);
            }

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
        System.out.println("Ce vehicule vient de move : " + v.toString() + "\n");
        return v;
    }

    public int simulation_move_car(int id)
    {
        Vehicule v = l_vehicule.get(id);
        int res = v.getPosition() + v.getVitesse();
        return res;
    }

    public void prediction_move_car(int id)
    {
        Vehicule v;
        Vehicule w;
        boolean bAccident = true;
        int nb_vehicule = this.l_vehicule.size();
        for (int i = 0; i < nb_vehicule-1; i++)
        {
            if(l_vehicule.get(i).getIdVehicule() == id)
            {
                v = l_vehicule.get(i);
                w = l_vehicule.get(i + 1);
                for (int j = i; j > 0 ; j--)
                {
                    Vehicule a, b;
                    b = l_vehicule.get(j-1);
                    a = l_vehicule.get(i);

                    try {
                        int positionA, positionB;
                        positionA = simulation_move_car(a.getIdVehicule()) + simulation_move_car(a.getIdVehicule());
                        positionB = simulation_move_car(b.getIdVehicule()) + simulation_move_car(b.getIdVehicule());
                        if (positionA >= positionB)
                        {
                            for (int k = 0; k < nb_acces; k++)
                            {
                                if((v.getPosition() <= l_acces.get(k).getEmplacement()) && (l_acces.get(k).getEmplacement() <= positionB))
                                {
                                    //gerer l'évitemment de accident -> appel à une fonction d'Idioroute avec acces et voiture en paramètre
                                    System.out.println("\n******************** EVITE ***************n\n");
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
                        e.printStackTrace();
                        System.out.println("Accident entre " + a + " et " + b);
                        System.exit(1);
                        return;
                    }
                }
                if(!v.isNeed_move())
                {
                    v = move_car(i);
                }
            }
        }
    }

}
