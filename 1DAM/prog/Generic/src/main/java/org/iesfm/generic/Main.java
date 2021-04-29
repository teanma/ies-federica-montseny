package org.iesfm.generic;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ListUtils<String> listUtils = new ListUtils<>(new LinkedList<>());
        listUtils.introduceValue("Helado");
        listUtils.introduceValue("Chicle");
        listUtils.introduceValue("Canela");

        System.out.println(listUtils.getFirstPosition());
        System.out.println(listUtils.getLastPosition());

        ListUtils<Integer> listUtilsInteger = new ListUtils<>(new LinkedList<>());
        listUtilsInteger.introduceValue(2);
        listUtilsInteger.introduceValue(3);
        listUtilsInteger.introduceValue(1);

        ListUtils<Character> listUtilsChar = new ListUtils<>(new LinkedList<>());

        System.out.println(listUtilsInteger.getFirstPosition() + listUtilsInteger.getLastPosition());

    }
}