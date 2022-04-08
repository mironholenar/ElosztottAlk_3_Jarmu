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

    public Ember getSofor() {
        return sofor;
    }

    public void setSofor(Ember sofor) {
        this.sofor = sofor;
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


    public void beinditas(Ember tulajdonos, Ember sofor)
    {
        if(this.uzemanyag.getMennyiseg() > 0)
        {
            if(sofor.getJogositvany().jogositvanyKod != -1)
            {
                this.motorstatusz = MotorStatusz.Be;
                tulajdonosBeallitasa(tulajdonos);
                soforBeallitasa(sofor);
                System.out.println(this.nev + " Sikeresen beindult!");
            }
            else
            {
                System.out.println("Nem sikerült beinditani mert " + sofor.getNev() + " nincs jogosítványa!" );
            }

        }

    }

    public void beinditas() {
        if (this.uzemanyag.getMennyiseg() > 0)
        {
            this.motorstatusz = MotorStatusz.Be;
        }
    }

    public void tulajdonosBeallitasa(Ember tulajdonos)
    {
        if(this.motorstatusz == MotorStatusz.Be) {
            this.tulajdonos = tulajdonos;
        }
    }

    public void soforBeallitasa(Ember sofor)
    {
        if(this.motorstatusz == MotorStatusz.Be)
        {
            this.sofor = sofor;
        }
    }

    public void leallitas()
    {
        this.motorstatusz = MotorStatusz.Ki;
    }


}
