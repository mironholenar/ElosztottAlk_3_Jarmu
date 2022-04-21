package com.jarmuvek;

public class Auto extends Jarmu{

    public Auto(String nev, Szin szin, Uzemanyag uzemanyag) {
        super(nev, szin, uzemanyag);
    }

    public Auto(String nev, Szin szin, Uzemanyag uzemanyag, Ember tulajdonos, Ember sofor) {
        super(nev, szin, uzemanyag, tulajdonos, sofor);
    }
}
