package org.example;

import java.util.Base64;

import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static final String CORRECT_NUMBER = "5";
    public static final int MAX_TRIES = 5;


    public static void main(String[] args) {
        int numberOfTries = 0;
        Scanner number = new Scanner(in);
        while (numberOfTries < MAX_TRIES) {
            out.printf("Wpisz %s lub inny numer:", CORRECT_NUMBER);
            String input = number.nextLine();
            out.println(input);
            if (CORRECT_NUMBER.equals(input)) {
                out.println("Wszedles!");
                printMenu();
                return;
            }
            numberOfTries++;
            out.println("Nie prawidlowe haslo!\n");
        }
    }
    public static void printMenu() {

        Scanner menu = new Scanner(in);
        out.println("Wszedles w admina!");
        out.println("1 - encrypt hasla  i decrypt hasla");
        out.println("2 - exit");
        String menuInput = menu.nextLine();
        switch (menuInput) {
            case "1":
                byte[] encrypt = Base64.getEncoder().encode(CORRECT_NUMBER.getBytes());
                out.printf("Twoj encrypt hasla to ------> " + new String(encrypt));

                byte[] decrypt = Base64.getDecoder().decode(encrypt);
                out.println("\nTwoj dencrypt hasla to ------> " + new String(decrypt));
                break;
            default:
        }
    }

}