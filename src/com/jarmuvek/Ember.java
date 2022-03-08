package com.jarmuvek;

public class Ember {

    public Ember(String nev) {
        this.nev = nev;
    }

    private String nev;
    private int kor;

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


}
