package org.example;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static final String CORRECT_NUMBER = "5";
    public static  int MAX_TRIES = 5;
    public static int NUMBER_TRIES= 0;

    public static void main(String[] args) {
        while (NUMBER_TRIES < MAX_TRIES) {
            Scanner number = new Scanner(in);
            out.println("Wpisz " + CORRECT_NUMBER + " lub inny numer");
            String name = number.nextLine();
            out.println(name);
            if (CORRECT_NUMBER.equals(name)) {
                out.println("Wszedles");
                break;
            } else {
                NUMBER_TRIES++;
                out.println("Nie prawidlowe haslo");
            }
        }
        if (NUMBER_TRIES == MAX_TRIES)//dupa123
        {
            exit(0);
        }
    }
}