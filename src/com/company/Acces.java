package com.company;

public class Acces {
    private static int id_access;
    private int emplacement;
    private boolean is_entry;
    private boolean is_exit;


    public Acces() {
        this.id_access = ++id_access;
        this.emplacement = 0;
        this.is_entry = false;
        this.is_exit = false;
    }

    public int getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(int emplacement) {
        this.emplacement = emplacement;
    }

    public boolean isIs_entry() {
        return is_entry;
    }

    public void setIs_entry(boolean is_entry) {
        this.is_entry = is_entry;
    }

    public boolean isIs_exit() {
        return is_exit;
    }

    public void setIs_exit(boolean is_exit) {
        this.is_exit = is_exit;
    }
}
