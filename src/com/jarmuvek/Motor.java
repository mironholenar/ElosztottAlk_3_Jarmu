package com.jarmuvek;

public class Motor extends Jarmu{

    public Motor(String nev, Szin szin, Uzemanyag uzemanyag) {
        super(nev, szin, uzemanyag);
    }

    public Motor(String nev, Szin szin, Uzemanyag uzemanyag, Ember tulajdonos, Ember sofor) {
        super(nev, szin, uzemanyag, tulajdonos, sofor);
    }
}
