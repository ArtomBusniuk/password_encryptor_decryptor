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
                menu();
                return;
            }
            numberOfTries++;
            out.println("Nie prawidlowe haslo!\n");
        }
    }
    public static void menu() {

        Scanner number = new Scanner(in);
        out.println("Wszedles w admina!");
        out.println("1 - encrypt hasla  i decrypt hasla");
        out.println("2 - exit");
        String menuInput = number.nextLine();
        switch (menuInput) {
            case "1":
                byte[] encryptPassword = Base64.getEncoder().encode(CORRECT_NUMBER.getBytes());
                out.printf("Twoj encrypt hasla to ------> " + new String(encryptPassword));

                byte[] decryptPassword = Base64.getDecoder().decode(encryptPassword);
                out.println("\nTwoj dencrypt hasla to ------> " + new String(decryptPassword));
                break;
            case "2":
                break;
        }
    }

}