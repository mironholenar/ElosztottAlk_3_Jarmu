package com.jarmuvek;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    ArrayList<Jarmu> Jarmuvek = new ArrayList<>();

    public static void main(String[] args) {
        Demo();
        olvas();
    }


    public static void Demo()
    {
        Ember e1 = new Ember("Val Aki", 20);
        Ember e2 = new Ember("X Y", 17);
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

    public static void olvas() {
        try {
            File myObj = new File("jarmuvek.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] beolvasottJarmuvek = data.split(";", 2);
                System.out.printf("Jármű neve: %s", beolvasottJarmuvek[0]);
                System.out.printf(" Jármű tulajdonosa: %s", beolvasottJarmuvek[1]);

                System.out.println(" ");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}


