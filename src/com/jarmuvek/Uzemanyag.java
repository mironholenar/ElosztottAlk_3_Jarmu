package com.jarmuvek;

public class Uzemanyag {

    enum Tipus {
        Benzin, Dizel
    }

    private int mennyiseg;

    public Uzemanyag(Tipus tipus, int mennyiseg) {

        this.mennyiseg = mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }
}
