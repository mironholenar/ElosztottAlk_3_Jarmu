package com.jarmuvek;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jarmuvek.Jarmu.Szin.ISMERETLEN;

public abstract class Jarmu {

    enum Szin {
        Piros, Kek, Sarga, Feher, Fekete, ISMERETLEN;

        private static final Map<String, Szin> ENUM_MAP = Stream.of(Szin.values())
                .collect(Collectors.toMap(Enum::name, Function.identity()));

        public static Szin of(final String name) {
            return ENUM_MAP.getOrDefault(name, ISMERETLEN);
        }
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
        this.tulajdonos = new Ember("Nincs",0,-1, false);
        this.sofor = new Ember("Nincs",0,-1, false);
    }

    public Jarmu(String nev, Szin szin, Uzemanyag uzemanyag, Ember tulajdonos, Ember sofor)
    {
        this.nev = nev;
        this.szin = szin;
        this.uzemanyag = uzemanyag;
        this.tulajdonos = tulajdonos;
        this.sofor = sofor;
        this.motorstatusz = MotorStatusz.Ki;
    }
    // A második konstruktor a fájlbeolvasáshoz kell

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



    public void beinditas() { //Felvesszük a tulajdonost és a sofőrt, majd beinditjuk a járművet ha van érvényes jogosítványa
        if (this.uzemanyag.getMennyiseg() > 0)
        {
            if(sofor.getJogositvany().jogositvanyKod != -1)
            {
                this.motorstatusz = MotorStatusz.Be;
                System.out.println(this.nev + " Sikeresen beindult!");
            }
            else
            {
                System.out.println("Nem sikerült beinditani mert " + sofor.getNev() + " nincs jogosítványa!" );
            }
        }
    }



    public void tulajdonosBeallitasa(Ember tulajdonos)  //Alternatív beindítás, ha már van tulajdonosa és sofőre a járműnek.
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

    public String getTipus() //Tipus ellenőrzés GUI-hoz
    {
        if(this.getClass() == Auto.class)
        {
            return "Autó";
        }
        if(this.getClass() == Motor.class)
        {
            return "Motor";
        }
        return "Default";
    }




}
