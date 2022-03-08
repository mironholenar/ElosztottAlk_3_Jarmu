package com.jarmuvek;

public class Jarmu {

    enum Szin {
        Piros, Kek, Sarga, Feher, Fekete
    }

    private String nev;
    private Szin szin;
    private Ember tulajdonos;
    private Uzemanyag uzemanyag;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Szin getSzin() {
        return szin;
    }

    public void setSzin(Szin szin) {
        this.szin = szin;
    }

    public Ember getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(Ember tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public Uzemanyag getUzemanyag() {
        return uzemanyag;
    }

    public void setUzemanyag(Uzemanyag uzemanyag) {
        this.uzemanyag = uzemanyag;
    }

    public Jarmu(String nev, Szin szin, Ember tulajdonos, Uzemanyag uzemanyag) {
        this.nev = nev;
        this.szin = szin;
        this.tulajdonos = tulajdonos;
        this.uzemanyag = uzemanyag;
    }
}
