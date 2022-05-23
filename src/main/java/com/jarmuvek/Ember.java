package com.jarmuvek;

import javafx.beans.property.StringProperty;

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
        this.jogositvany = new Jogositvany(false);
    }

    public Ember(String nev, int kor, int id)
    {
        this.nev = nev;
        this.kor = kor;
        autoID = id;
        this.azonosito = id;
    }

    public Ember(String nev, int kor, int id, boolean ervenyes) //Null érték elkerülése, egy harmadik konstruktor ami előre beállít jogosítványt
    {
        this.nev = nev;
        this.kor = kor;
        this.azonosito = id;
        this.jogositvany = new Jogositvany(false);
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

    public String getJogositvanyValidity() { //Jogosítvány érvényességének ellenőrzése, TableColumn innen kapja az értéket
        int id = this.getJogositvany().jogositvanyKod;
        if(id > 0)
        {
            return "Érvényes" + " - " + "Id: " + id;
        }
        else{
            return "Érvénytelen - Nincs";
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

    public void jogositvanySzerzes(int kod) {
        if (this.kor >= 18) {
            this.jogositvany = new Jogositvany(kod);
        }
        else
        {
            this.jogositvany = new Jogositvany(false);
        }
    }

    @Override
    public String toString() {
        return nev;
    }
}
