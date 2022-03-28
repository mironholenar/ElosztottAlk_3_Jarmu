package com.jarmuvek;

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
        return jogositvany;
    }

    public void jogositvanySzerzes(Jogositvany jogositvany) {
        if (this.kor >= 18) {
            this.jogositvany = jogositvany;
        }
    }
}
