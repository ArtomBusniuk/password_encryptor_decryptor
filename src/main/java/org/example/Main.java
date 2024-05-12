
package org.example;

import java.io.PrintStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int MAX_TRIES = 5;

    public Main() {
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] args) {

        int numberOfTries = 0;
        Scanner userScanner = getScanner();
        List<User> userList = new ArrayList<>();
        User admin = new User();
        admin.username = "Admin";
        admin.password = "qwerty";
        userList.add(admin);
        while (true) {
            System.out.println("Press Q to register next user.");
            String userDecision = userScanner.nextLine();
            if (userDecision.equals("Q")) {
                userList.add(registerNextUser(userScanner));
                System.out.println("Press Q to register next user.");
                userDecision = userScanner.nextLine();
                if (!userDecision.equals("Q")) {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("Current users in your database:");
        userList.forEach((user -> System.out.printf("User %s, password %s \n", user.username, user.password)));

        // check IF username IS in the userList, if there is, check if password is correct for THIS user
        System.out.println("Podaj swoj login");

        boolean userExists = findIfUserExists(userList, username);
        if (userExists) {
            User user = getUserFromList(username);
            loginUser(user);

        }


        ++numberOfTries;
        System.out.println("Nie prawidlowy login albo haslo!\n");
        System.out.println("Sprobuj jeszcze raz");

    }


    public static void loginUser(User user) {
        //logic for checking password validity for user
        boolean isLoggedIn = validateUserPassword(user, password);
        if (isLoggedIn) {
            printMenu(userScanner);
        }
    }

    public static void printMenu(Scanner scanner) {
//        System.out.println("1 - encrypt hasla  i decrypt hasla");
//        System.out.println("2 - exit");
//        switch (scanner.nextLine()) {
//            case "1":
//                byte[] encrypt = Base64.getEncoder().encode(User.password.getBytes());
//                System.out.printf("Twoj encrypt hasla to ------> " + new String(encrypt));
//                byte[] decrypt = Base64.getDecoder().decode(encrypt);
//                PrintStream var10000 = System.out;
//                String var10001 = new String(decrypt);
//                var10000.println("\nTwoj dencrypt hasla to ------> " + var10001);
//            case "2":
//                break;
//            default:
//                System.out.println("Blad! Powtorz jeszcze raz");
//                printMenu(scanner);
        //}

    }

    public static User registerUser(String username, String password) {
        User newUser = new User();
        newUser.password = password;
        newUser.username = username;
        return newUser;

    }

    public static User registerNextUser(Scanner scanner) {
        System.out.printf("Podaj login:");
        String inputLogin = scanner.nextLine();
        System.out.printf("Podaj haslo:");
        String inputPassword = scanner.nextLine();
        User user = registerUser(inputLogin, inputPassword);
        System.out.printf("Hello %s, your password is %s\n", user.username, user.password);
        return user;
    }

}
