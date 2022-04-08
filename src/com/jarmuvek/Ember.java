package com.jarmuvek;

import java.util.Optional;

public class Ember {

    private String nev;
    private int kor;
    private Jogositvany jogositvany;

    public Ember(String nev, int kor) {
        this.nev = nev;
        this.kor = kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getKor() {
        return kor;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public Jogositvany getJogositvany() {
        if(jogositvany != null)
        {
            return jogositvany;
        }
        else
        {
            System.out.println(this.nev + " nincsen jogosítványa.");
            return jogositvany;
        }

    }

    public void jogositvanySzerzes() {
        if (this.kor >= 18) {
            this.jogositvany = new Jogositvany(true);
        }
        else
        {
            this.jogositvany = new Jogositvany(false);
        }
    }
}
