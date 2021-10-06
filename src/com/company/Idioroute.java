package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Idioroute {
    private List<Autoroute> l_autoroute;

    public Idioroute()
    {
        l_autoroute = new ArrayList<>(5);
    }

    public void generate_vehicule()
    {
        Random random = new Random();
        int random_value = random.nextInt(1+3) + 1;
        Vehicule v;
        if (random_value == 1)
        {
            v = new Voiture();
        }
        if (random_value == 2)
        {
            v = new Moto();
        }
        else {

            v = new Camion();
        }

        l_autoroute.get(0).getL_vehicule().add(v);

    }

    public void add_car()
    {
        Vehicule v = new Vehicule();
        l_autoroute.get(4).getL_vehicule().add(v);
    }

    public void change_autoroute_car(int i, Autoroute autoroute_a, Autoroute autoroute_b)
    {
        Vehicule v_to_move = autoroute_a.getL_vehicule().get(i);
        if(v_to_move.getPosition() == autoroute_a.getL_acces().get(autoroute_a.getNb_acces()).getEmplacement())
        {
            autoroute_a.getL_vehicule().remove(v_to_move);
            autoroute_b.getL_vehicule().add(v_to_move);
        }
    }

    public void gestion_accident()
    {
        boolean updated = false;
        int list_auto_size = l_autoroute.size();
        for (int i = 0; i < list_auto_size; i++)
        {
            List<Acces> l_acces = l_autoroute.get(i).getL_acces();
            List<Vehicule> l_vehicule = l_autoroute.get(i).getL_vehicule();

            int list_vehi_size = l_vehicule.size();
            for (int j = 0; j < list_vehi_size; j++)
            {
                Vehicule v = l_vehicule.get(j);
                if(v.isNeed_move() == true)
                {
                    int list_acces_size = l_acces.size();
                    for(int k = 0; k < list_acces_size; k++)
                    {
                        if(v.getPosition() == l_acces.get(k).getEmplacement())
                        {
                            l_vehicule.remove(v);
                            if(i == 0)
                            {
                                l_autoroute.get(i + 1).getL_vehicule().add(v);
                            }
                            else
                            {
                                l_autoroute.get(i - 1).getL_vehicule().add(v);
                            }
                            updated = true;
                        }
                        if(updated)
                        {
                            updated = false;
                            break;
                        }
                    }
                }
            }
        }
    }
}
