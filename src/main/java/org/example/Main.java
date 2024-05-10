
package org.example;

import java.io.PrintStream;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static final int MAX_TRIES = 5;

    public Main() {
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] args) {
        User.password = "artom123";
        User.username = "Artom";
        User2.password2 = "vlad123";
        User2.username2 = "Vlad";
        int numberOfTries = 0;
        Scanner userScanner = getScanner();

        while(numberOfTries < 5) {
            System.out.printf("Podaj login:");
            String inputLogin = userScanner.nextLine();
            System.out.printf("Podaj haslo:");
            String inputPassword = userScanner.nextLine();
            if (User.password.equals(inputPassword) && User.username.equals(inputLogin) || User2.password2.equals(inputPassword) && User2.username2.equals(inputLogin)) {
                System.out.println("Hello " + inputLogin + "!");
                printMenu(userScanner);
                return;
            }

            ++numberOfTries;
            System.out.println("Nie prawidlowy login albo haslo!\n");
            System.out.println("Sprobuj jeszcze raz");
        }

    }

    public static void printMenu(Scanner scanner) {
        System.out.println("1 - encrypt hasla  i decrypt hasla");
        System.out.println("2 - exit");
        switch (scanner.nextLine()) {
            case "1":
                byte[] encrypt = Base64.getEncoder().encode(User.password.getBytes());
                System.out.printf("Twoj encrypt hasla to ------> " + new String(encrypt));
                byte[] decrypt = Base64.getDecoder().decode(encrypt);
                PrintStream var10000 = System.out;
                String var10001 = new String(decrypt);
                var10000.println("\nTwoj dencrypt hasla to ------> " + var10001);
            case "2":
                break;
            default:
                System.out.println("Blad! Powtorz jeszcze raz");
                printMenu(scanner);
        }

    }
}
