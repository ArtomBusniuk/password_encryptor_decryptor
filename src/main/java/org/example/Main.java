package org.example;
import java.util.Scanner;

public class Main {

    public static final String CORRECT_NUMBER = "5";

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Wpisz " + CORRECT_NUMBER + " lub inny numer");
        String name = number.nextLine();
        System.out.println(name);
        if (CORRECT_NUMBER.equals(name)) {
            System.out.println("Wszedles");
        } else {
            System.out.println("Nie prawidlowe haslo");
        }
    }
}