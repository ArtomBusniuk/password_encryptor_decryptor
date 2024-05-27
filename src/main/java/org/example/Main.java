
package org.example;

import java.io.PrintStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static final int MAX_TRIES = 5;

    public Main() {
    }

    public static Scanner getScanner() {
        return new Scanner(in);
    }

    public static void main(String[] args) {
        String adminLogin = "admin";
        String adminPassword = "admin";
        int numberOfTries = 0;
        Scanner userScanner = getScanner();
        List<User> userList = new ArrayList<>();


        while(numberOfTries < 5) {
            System.out.println("Press Q to register user or press L to login.");
            String userDecision =  userScanner.nextLine();
            if (userDecision.equals("L")) {
                System.out.println("Podaj login:");
                String loginInput = userScanner.nextLine();
                System.out.println("Podaj haslo:");
                String passwordInput = userScanner.nextLine();
                for ( int i = 0;  i < userList.size(); i++)
                    if (userList.get(i).username.equals(loginInput) && userList.get(i).password.equals(passwordInput)) {
                        printMenu(userScanner);
                    }
                    else {
                        ++numberOfTries;
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
                //userList.forEach((user -> System.out.printf("User %s, password %s",user.username,user.password)));
            }





        }

    }


    public static void printMenu(Scanner scanner) {
        System.out.println("1 - encrypt hasla  i decrypt hasla");
        System.out.println("2 - exit");
        switch (scanner.nextLine()) {
            case "1":
                byte[] encrypt = Base64.getEncoder().encode(registerUser("Login","Login").password.getBytes());
               System.out.printf("Twoj encrypt hasla to ------> " + new String(encrypt));
               byte[] decrypt = Base64.getDecoder().decode(encrypt);
               System.out.println("\nTwoj dencrypt hasla to ------> " + decrypt);
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
//    public static User adminUser(String adminLogin,String adminPassword){
//        User admin = new User();
//        admin.adminLogin = adminLogin;
//        admin.adminPassword = adminPassword;
//        return  admin;
//    }
    public static User registerNextUser(Scanner scanner) {
        System.out.printf("Podaj login:");
        String  inputLogin = scanner.nextLine();
        System.out.printf("Podaj haslo:");
        String inputPassword = scanner.nextLine();
        User user = registerUser(inputLogin,inputPassword);
        System.out.printf("Hello %s, your password is %s\n",user.username,user.password);
        return user;
    }
    public static User loginUser(boolean loggeIn) {
        User login = new User();
        login.loggedIn = loggeIn;
        return login;
    }


}
