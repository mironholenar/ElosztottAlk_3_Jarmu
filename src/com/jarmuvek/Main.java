package com.jarmuvek;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Jarmu> Jarmuvek = new ArrayList<>();

    public static void main(String[] args) {
        Demo();
        fajlOlvas();
    }

    public static void Demo() throws NullPointerException
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
            myWriter.write("TEST23!");
            myWriter.close();
            System.out.println("Sikeres fájlba írás");
        } catch (IOException e) {
            System.out.println("ERROR.");
            e.printStackTrace();
        }
    }

    public static void fajlOlvas() {

        try {
            File myObj = new File("jarmuvek.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] beolvasottJarmuvek = data.split(";", 2);
                System.out.printf("Jármű neve: %s", beolvasottJarmuvek[0]);
                System.out.printf(" Jármű tulajdonosa: %s", beolvasottJarmuvek[1]);
                    switch (beolvasottJarmuvek[0]) {
                        case "jarmu":
                            new Auto(beolvasottJarmuvek[1], Jarmu.Szin.of(beolvasottJarmuvek[2]),new Uzemanyag(Uzemanyag.Tipus.of(beolvasottJarmuvek[3]),Integer.parseInt(beolvasottJarmuvek[4])));
                        case "tulaj":
                            new Ember(beolvasottJarmuvek[1], Integer.parseInt(beolvasottJarmuvek[2]));
                        case "sofor":
                            new Ember(beolvasottJarmuvek[1], Integer.parseInt(beolvasottJarmuvek[2]));
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


