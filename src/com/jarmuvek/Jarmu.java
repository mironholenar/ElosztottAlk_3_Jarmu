package com.jarmuvek;

public abstract class Jarmu {

    enum Szin {
        Piros, Kek, Sarga, Feher, Fekete
    }

    enum MotorStatusz {
        Ki, Be
    }

    private String nev;
    private Szin szin;
    private Ember tulajdonos;
    private Ember sofor;
    private Uzemanyag uzemanyag;
    private MotorStatusz motorstatusz;

    public Jarmu(String nev, Szin szin, Uzemanyag uzemanyag) {
        this.nev = nev;
        this.szin = szin;
        this.uzemanyag = uzemanyag;
        this.motorstatusz = MotorStatusz.Ki;
    }

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

    public MotorStatusz getMotorstatusz() {
        return motorstatusz;
    }

    public void setMotorstatusz(MotorStatusz motorstatusz) {
        this.motorstatusz = motorstatusz;
    }

    public void Beinditas()
    {
        if(this.uzemanyag.getMennyiseg() > 0)
        {
            this.motorstatusz = MotorStatusz.Be;
        }
    }

    public void TulajdonosBeallitasa(Ember tulajdonos)
    {
        this.tulajdonos = tulajdonos;
    }

    public void SoforBeallitasa(Ember sofor)
    {
        this.sofor = sofor;
    }

    public void Leallitas()
    {
        this.motorstatusz = MotorStatusz.Ki;
    }


}
