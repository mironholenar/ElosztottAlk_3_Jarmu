package com.jarmuvek;

public class Jogositvany {

    enum Kategoria {
        A1, A2, A, B, C, D, K, T, V
    }

    public static int autoID = 0;

    public int jogositvanyKod;

    public Jogositvany() {
        this.jogositvanyKod = autoID + 1;
    }

    public int getJogositvanyKod() {
        return jogositvanyKod;
    }

    public void setJogositvanyKod(int jogositvanyKod) {
        this.jogositvanyKod = jogositvanyKod;
    }


}

