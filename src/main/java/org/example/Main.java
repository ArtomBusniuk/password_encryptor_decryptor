package org.example;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static final String CORRECT_NUMBER = "5";
    public static final int MAX_TRIES = 5;


    public static void main(String[] args) {
        int numberTries= 0;
        Scanner number = new Scanner(in);
        while (numberTries < MAX_TRIES) {
            out.printf("Wpisz %s lub inny numer:", CORRECT_NUMBER);
            String input = number.nextLine();
            out.println(input);
            if (CORRECT_NUMBER.equals(input)) {
                out.println("Wszedles!");
                return;
            }
                numberTries++;
                out.println("Nie prawidlowe haslo!\n");

        }

    }
}