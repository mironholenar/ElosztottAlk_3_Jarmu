package com.jarmuvek;

public class Ember {

    private String nev;
    private int kor;
    private Jogositvany jogositvany;

    public Ember(String nev) {
        this.nev = nev;
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

    public void setJogositvany(Jogositvany jogositvany) {
        this.jogositvany = jogositvany;
    }
}
