package org.example;

import lombok.Getter;

import java.util.Base64;

import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static final String CORRECT_NUMBER = "5";
    public static final int MAX_TRIES = 5;

    public static Scanner getScanner() {
        return new Scanner(in);
    }


    public static void main(String[] args) {
        int numberOfTries = 0;
        Scanner userScanner = getScanner();
        while (numberOfTries < MAX_TRIES) {
            out.printf("Wpisz %s lub inny numer:", CORRECT_NUMBER);
            String input = userScanner.nextLine();
            out.println(input);
            if (CORRECT_NUMBER.equals(input)) {
                out.println("Wszedles w admina!");
                printMenu(userScanner);
                return;
            }
            numberOfTries++;
            out.println("Nie prawidlowe haslo!\n");
        }
    }

    public static void printMenu(Scanner scanner) {
        out.println("1 - encrypt hasla  i decrypt hasla");
        out.println("2 - exit");
        String menuInput = scanner.nextLine();
        switch (menuInput) {
            case "1":
                byte[] encrypt = Base64.getEncoder().encode(CORRECT_NUMBER.getBytes());
                out.printf("Twoj encrypt hasla to ------> " + new String(encrypt));

                byte[] decrypt = Base64.getDecoder().decode(encrypt);
                out.println("\nTwoj dencrypt hasla to ------> " + new String(decrypt));
                break;
            case "2":
                break;
            default:
                out.println("Blad! Powtorz jeszcze raz");
                printMenu(scanner);
        }
    }

}