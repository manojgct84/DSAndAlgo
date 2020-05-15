package com.sap.ariba.test;

public class TesTClass {
    static String value = "testify";
    static int value1 = 25;

    static {
        value1 = 50;
        System.out.println(value);
        System.out.println(value1);
    }

    public static void main(String args[]){
    }

}
