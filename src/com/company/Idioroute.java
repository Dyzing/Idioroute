package com.company;


import java.util.ArrayList;
import java.util.List;

public class Idioroute {
    private List<Autoroute> l_autoroute;

    public Idioroute()
    {
        l_autoroute = new ArrayList<>(5);
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
}
