package com.jarmuvek;

public class Ember {

    public static int autoID = 0;
    private int azonosito;
    private String nev;
    private int kor;
    private Jogositvany jogositvany;

    public Ember(String nev, int kor) {
        this.nev = nev;
        this.kor = kor;
        autoID++;
        this.azonosito = autoID;
    }

    public Ember(String nev, int kor, int id)
    {
        this.nev = nev;
        this.kor = kor;
        autoID = id;
        this.azonosito = id;
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

    public int getAzonosito() {
        return azonosito;
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
