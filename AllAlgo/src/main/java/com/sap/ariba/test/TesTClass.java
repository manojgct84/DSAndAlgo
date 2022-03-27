package com.sap.ariba.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TesTClass {
    static String value = "testify";
    static int value1 = 25;
    static int count = 0;
    static {
        value1 = 50;
        System.out.println(value);
        System.out.println(value1);
    }

    public static void main(String args[]) {
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("FalSe"));
        list.add(Boolean.TRUE);
        System.out.println(list.size());
        System.out.println(list.get(1) instanceof Boolean);

        char mchar = "piper".charAt(3);
        System.out.println(mchar);

        if ("manoj" instanceof  String) {
            System.out.println("true");
        }

        int[] sample = {8,5,3,1};
        System.out.println(sample[2]);

        List<String> name = new ArrayList<>();

        name.add("A");
        name.add("D");
        name.add("C");
        name.add("B");
        Collections.sort(name);
        System.out.println(name.toString());

        StringBuilder ab = new StringBuilder("hello");
        //ab.deleteCharAt(0).insert(0,"H")."world!";
        String[] array = new String[] {"A","B","C"};
        List<String> list1 = Arrays.asList(array);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        List<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"), "C"));
        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));

       // List<String> words = new ArrayList<>(){"Hellow"};
       // ArrayList<String> words1 = {"Hellow", "words"};
       // ArrayList<String> words2 =Arrays.asList("Hellow", "words");

        if (count < 3) {
            count++;
            main(null);
        } else {
            return;
        }
        System.out.println("Hellow World");
     }
}
