package com.jarmuvek;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Jarmu> Jarmuvek = new ArrayList<>();
    public static ArrayList<Ember> Emberek = new ArrayList<>();

    public static void main(String[] args) {
        fajlOlvas();
       // demoAdatok();
        Listazas();
        mentes();
    }



    public static void Listazas()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        int i = 0;
        for(;i<Jarmuvek.size();i++) {
            System.out.println(i + " - " + Jarmuvek.get(i).getNev());
        }

        boolean kilepes = false;

        System.out.println("Melyik járművet indítsuk be? Irja be a számot!, vagy írja be " + ((int)i+(int)1) + " - a kilépéshez");

        do
        {
            int valasz = scan.nextInt();
            if(valasz == i+1)
            {
                kilepes = true;
            }
            else
            {
                Jarmuvek.get(valasz).beinditas();
            }

        }
        while(!kilepes);

    }

    public static void demoAdatok() throws NullPointerException
    {
        Ember e1 = new Ember("Val Aki", 20);
        Ember e2 = new Ember("X Y", 17);

        e1.jogositvanySzerzes();
        e2.jogositvanySzerzes();

        Auto a1 = new Auto("Audi A6", Jarmu.Szin.Fekete,new Uzemanyag(Uzemanyag.Tipus.Dizel,30));
        a1.beinditas(e1,e1);
        Jarmuvek.add(a1);

        Auto a2 = new Auto("Mercedes CLS 63 AMG", Jarmu.Szin.Feher,new Uzemanyag(Uzemanyag.Tipus.Benzin,30));
        a2.beinditas(e2,e1);
        Jarmuvek.add(a2);


    }

    public static void mentes() {
        try {
            FileWriter myWriter = new FileWriter("jarmuvek.txt");

            int k = 0;
            for(;k<Emberek.size();k++) {
                myWriter.write("ember;" + Emberek.get(k).getNev() + ";" + Emberek.get(k).getKor() + ";" + Emberek.get(k).getAzonosito());
                myWriter.write("\n");
            }

            int i = 0;
            for(;i<Jarmuvek.size();i++) {
                myWriter.write("jarmu;"+ Jarmuvek.get(i).getNev() + ";" + Jarmuvek.get(i).getSzin() + ";" + Jarmuvek.get(i).getUzemanyag().getTipus() + ";" + Jarmuvek.get(i).getUzemanyag().getMennyiseg() + ";" + Jarmuvek.get(i).getTulajdonos().getAzonosito()+";" + Jarmuvek.get(i).getSofor().getAzonosito());
                myWriter.write("\n");
            }

            myWriter.close();
            System.out.println("Sikeres fájlba írás");
        } catch (IOException e) {
            System.out.println("ERROR.");
            e.printStackTrace();
        }
    }

    public static Ember getEmber(String id) {
        for (Ember ember : Emberek) {
            if (ember.getAzonosito() == Integer.parseInt(id)) {
                return ember;
            }
        }
        return new Ember("Nincs", 1);
    }

    public static void fajlOlvas() {

        try {
            File myObj = new File("jarmuvek.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] beolvasottJarmuvek = data.split(";", 8);

                    switch (beolvasottJarmuvek[0]) {
                        case "jarmu":


                            Ember tulaj = new Ember("NULL", 0) ;

                            tulaj = getEmber(beolvasottJarmuvek[5]);

                             //if (tulaj != null) auto.tulajdonosBeallitasa(tulaj);

                            Ember sofor = new Ember("NULL", 0) ;
                            sofor.getJogositvany();
                            sofor = getEmber(beolvasottJarmuvek[6]);
                            System.out.println(sofor.getNev());
                        //    if (sofor != null) auto.soforBeallitasa(sofor);

                            Auto auto = new Auto(
                                    beolvasottJarmuvek[1],
                                    Jarmu.Szin.of(beolvasottJarmuvek[2]),
                                    new Uzemanyag(Uzemanyag.Tipus.of(beolvasottJarmuvek[3]), Integer.parseInt(beolvasottJarmuvek[4])),
                                    tulaj,
                                    sofor
                                    );
                            Jarmuvek.add(auto);
                            break;
                        case "ember":

                           Ember ember = new Ember(beolvasottJarmuvek[1], Integer.parseInt(beolvasottJarmuvek[2]), Integer.parseInt(beolvasottJarmuvek[3]));
                           ember.jogositvanySzerzes();
                           Emberek.add(ember);
                        break;
                    }

                System.out.println(" ");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
           fajlLetrehoz();
           // e.printStackTrace();
        }
    }



    public static void fajlLetrehoz() {
        try {
            File myObj = new File("jarmuvek.txt");
            if (myObj.createNewFile()) {
                System.out.println("Fájl létrehozva: " + myObj.getName());
            } else {
                System.out.println("Fájl már létezik.");
            }
        } catch (IOException e) {
            System.out.println("Hiba történt.");
            e.printStackTrace();
        }
    }
}


