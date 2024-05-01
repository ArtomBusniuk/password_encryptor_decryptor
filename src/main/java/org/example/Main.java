import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Wpisz 1 albo 2:");
        String  name = number.nextLine();
        System.out.println(name);
        if ("1".equals (name)) {
            System.out.println("Wszedles");
        } else {
            System.out.println("Nie prawidlowe haslo");
        }
    }
}