package org.example;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static final String CORRECT_NUMBER = "5";

    public static void main(String[] args) {
        Scanner number = new Scanner(in);
        out.println("Wpisz " + CORRECT_NUMBER + " lub inny numer");
        String name = number.nextLine();
        out.println(name);
        if (CORRECT_NUMBER.equals(name)) {
            out.println("Wszedles");
        } else {
            out.println("Nie prawidlowe haslo");
        }
    }
}