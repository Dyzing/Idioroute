package com.company;


import java.util.*;

public class Idioroute {
    private List<Autoroute> l_autoroute;

    public Idioroute()
    {
        this.l_autoroute = new ArrayList<Autoroute>(5);

        for (int i = 0; i < 5; i++)
            this.l_autoroute.add(new Autoroute());

    }

    public void generate_vehicule()
    {

        Random random = new Random();
        int random_value = random.nextInt(3)+1 ;
        System.out.println(random_value);
        Vehicule v;
        if (random_value == 1)
        {
            v = new Voiture();
        }
        else if (random_value == 2)
        {
            v = new Moto();
        }
        else
        {
            v = new Camion();
        }

        List<Vehicule> lv = l_autoroute.get(0).getL_vehicule();
        lv.add(v);
        System.out.println(lv.get(lv.size()-1).toString());

    }

    public void add_car()
    {
        Vehicule v = new Vehicule();
        l_autoroute.get(4).getL_vehicule().add(v);
    }

    public void tour_complet(int i, Autoroute autoroute_a, Autoroute autoroute_b)
    {
        Vehicule v_to_move = autoroute_a.getL_vehicule().get(i);
        if(v_to_move.getPosition() == autoroute_a.getL_acces().get(autoroute_a.getNb_acces()).getEmplacement())
        {
            autoroute_a.getL_vehicule().remove(v_to_move);
            autoroute_b.getL_vehicule().add(v_to_move);
            Autoroute auto_actuelle = l_autoroute.get(v_to_move.getIdAutoroute());
            auto_actuelle.getL_vehicule().remove(v_to_move);
            if(v_to_move.getIdAutoroute() == 0)
            {
                l_autoroute.get(v_to_move.getIdAutoroute() + 1).getL_vehicule().add(v_to_move);
            }
            else
            {
                l_autoroute.get(v_to_move.getIdAutoroute() - 1).getL_vehicule().add(v_to_move);
            }
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


   public void run()
   {

       Timer timer = new Timer();
       TimerTask task = new TimerTask() {
           @Override
           public void run() {
               generate_vehicule();
               gestion_accident();
           }
       };
       timer.scheduleAtFixedRate(task, 0,1000);//wait 0 ms before doing the action and do it evry 1000ms (1second)
   }
}
