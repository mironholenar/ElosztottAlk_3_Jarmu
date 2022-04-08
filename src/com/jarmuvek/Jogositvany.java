package com.jarmuvek;

public class Jogositvany {

    enum Kategoria {
        A1, A2, A, B, C, D, K, T, V
    }

    public static int autoID = 0;

    public int jogositvanyKod;

    public Jogositvany(boolean valid) {
        if(valid)
        {
            this.jogositvanyKod = autoID + 1;
            autoID++;
        }
        else
        {
            this.jogositvanyKod = -1; //Mivel az ember classban létezik egy jogositvány példány, ezért muszáj létrehozni egy érvénytelen, mert nem adhatunk vissza null értéket!
        }


    }

    public Jogositvany(int id)
    {
        if(id > 0)
        {
            autoID = id;
            this.jogositvanyKod = id;
        }
        else
        {
            this.jogositvanyKod = -1;
        }


    }

    public int getJogositvanyKod() {
        if(this.jogositvanyKod > 0)
        {
            return jogositvanyKod;
        }
        else
        {
            System.out.println("Nem sikerült jogositványt szerezni!");
            return jogositvanyKod;
        }

    }

    public void setJogositvanyKod(int jogositvanyKod) {
        this.jogositvanyKod = jogositvanyKod;
    }


}

