package com.jarmuvek;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;


public class Main {

    ArrayList<Jarmu> Jarmuvek = new ArrayList<Jarmu>();

    public static void main(String[] args) {
        Demo();
    }


    public static void Demo()
    {
        Ember e1 = new Ember("Val Aki", 20);
        Ember e2 = new Ember("X Y", 17);
        mentes();
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
}


