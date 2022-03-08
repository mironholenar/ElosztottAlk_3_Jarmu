package com.jarmuvek;

public class Uzemanyag {

    public Uzemanyag(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    enum Tipus {
        Benzin, Dizel
    }

    private int mennyiseg;

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }
}
