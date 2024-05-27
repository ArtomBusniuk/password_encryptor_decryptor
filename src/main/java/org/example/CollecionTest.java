package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollecionTest {
    static List<String> listStr = new ArrayList<>(Arrays.asList("Artom", "Bartek", "Vlad", "Ola", "Nikita"));
    static List<String> listStr2 = new ArrayList<>(Arrays.asList("Tania", "Robert"));
    static List<String> listStr4 = new ArrayList<>();


    public static void main(String[] args) {
        String name = "AArtt";
        addToList(name);
        findInList(name);
        removeFromList(name);
        printOddString();
        joinLists(listStr4);
        System.out.println(listStr4);
        System.out.println(listStr2);
        System.out.println(listStr);

    }

    public static void addToList(String stringToAdd) {
        listStr.add(stringToAdd);

    }

    public static String findInList(String stringToFind) {
        stringToFind = "Tania";
        listStr2.contains(stringToFind);
        return stringToFind;
    }
    public static String removeFromList(String stringToRemove) {
        stringToRemove = "Tania";
        listStr2.remove(stringToRemove);
        return stringToRemove;
    }
    public static void printOddString() {
        List<String> listStr3 = new ArrayList<>(Arrays.asList("Art", "Bar", "Vla", "Ol", "Nik"));
        for (int i = 1; i < listStr3.size(); i += 2) {
            System.out.println(listStr3.get(i));
        }
    }
    public static <listStr2, listStr> List<String> joinLists(listStr2 listStr) {

        listStr4.addAll((Collection<? extends User>) listStr);
        listStr4.addAll(listStr2);
        return listStr4;

    }
