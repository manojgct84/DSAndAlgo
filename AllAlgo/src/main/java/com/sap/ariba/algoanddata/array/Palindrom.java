package com.sap.ariba.algoanddata.array;

public class Palindrom
{

    public static void main (String args[])
    {
        solution("WW");
    }

    private static void solution (String str)
    {

        if (str.length() == 0) {
            System.out.println("false");
        }
        str = str.toUpperCase();
        char[] strToChar = str.toCharArray();

        int i = 0;
        int j = strToChar.length - 1;
        boolean notMatch = false;
        while (i < j) {
            if (strToChar[i] == strToChar[j]) {
                System.out.println(String.format("%s ,%s ",
                                                 strToChar[i],
                                                 strToChar[j]));
                i++;
                j--;
            }
            else {
                System.out.println("false");
                notMatch = true;
                break;
            }
        }
        if(!notMatch)
        System.out.println("true");

    }



}
