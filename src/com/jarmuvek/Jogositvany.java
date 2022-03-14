package com.jarmuvek;

public class Jogositvany {

    public Jogositvany(String jogositvanyKod) {
        this.jogositvanyKod = jogositvanyKod;
    }

    enum Kategoria {
        A1, A2, A, B, C, D, K, T, V
    }

    private String jogositvanyKod;

    public String getJogositvanyKod() {
        return jogositvanyKod;
    }

    public void setJogositvanyKod(String jogositvanyKod) {
        this.jogositvanyKod = jogositvanyKod;
    }
}

