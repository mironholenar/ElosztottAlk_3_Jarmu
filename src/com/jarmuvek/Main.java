package com.jarmuvek;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World test3");
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
