
package org.example;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static Scanner getScanner() {
        return new Scanner(in);
    }
//    static String passwordInput;

    static String passwordInput;

    public static void main(String[] args) {
        Scanner userScanner = getScanner();
        List<User> userList = new ArrayList<>();
        int numberOfTries = 0;
        userList.add(createUser("admin", "admin"));
        while (numberOfTries < 5) {
            System.out.println("Press Q to register user or press L to login.");
            String userDecision = userScanner.nextLine();
            if (userDecision.equals("L")) {
                System.out.println("Podaj login:");
                String loginInput = userScanner.nextLine();
                System.out.println("Podaj haslo:");
                passwordInput = userScanner.nextLine();
                for (int i = 0; i < userList.size(); i++)
                    if (userList.get(i).username.equals(loginInput) && userList.get(i).password.equals(passwordInput)) {
                        printMenu(userScanner);

                    }
                    else {
                        numberOfTries++;
                        System.out.println("Nie prawidlowy login albo haslo!\n");
                        System.out.println("Sprobuj jeszcze raz");
                     }
            }
            if (userDecision.equals("Q")) {
                userList.add(registerNextUser(userScanner));
                userDecision = userScanner.nextLine();
                if (userDecision.equals("Q")) {
                    continue;
                }
            }
        }
    }
    public static void printMenu(Scanner scanner) {
        System.out.println("1 - encrypt hasla  i decrypt hasla");
        System.out.println("2 - exit");
        switch (scanner.nextLine()) {
            case "1":

                byte[] encrypt = Base64.getEncoder().encode(passwordInput.getBytes());
               System.out.printf("Twoj encrypt hasla to ------> " + new String(encrypt));
               byte[] decrypt = Base64.getDecoder().decode(encrypt);
               System.out.println("\nTwoj dencrypt hasla to ------> " + new String(decrypt));
               case "2":
                break;
           default:
                System.out.println("Blad! Powtorz jeszcze raz");
                printMenu(scanner);
        }

    }
    public  static User registerUser(String username,String password) {
        User newUser = new User();
        newUser.password = password;
        newUser.username = username;
        return newUser;

    }
    public static User createUser(String username, String password) {
        User user = new User();
        user.username = username;
        user.password = password;
        return  user;
    }
    public static User registerNextUser(Scanner scanner) {
        System.out.println("Podaj login:");
        String  inputLogin = scanner.nextLine();
        System.out.println("Podaj haslo:");
        String inputPassword = scanner.nextLine();
        User user = registerUser(inputLogin,inputPassword);
        System.out.printf("Hello %s, your password is %s\n",user.username,user.password);
        return user;
    }
//    public static User loginUser(boolean loggeIn) {
//        User login = new User();
//        login.loggedIn = loggeIn;
//        return login;
    }




