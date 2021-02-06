package com.sap.ariba.algoanddata;

import java.util.Arrays;

public class LeftRotationArray
{

    public static void main (String args[])
    {
        System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5, 6 },
                                                   2)));
    }

    static int[] rotLeft (int[] a, int d)
    {
        int temp;
        int index;
        int i = 0;
        if (a.length == 0 || d == 0) {
            return a;
        }
        for (i = 0; i < d; i++) {
            temp = a[0];
            index = 0;
            for (int j = 1; j < a.length; j++) {
                a[j - 1] = a[j];
                index++;
            }
            a[index] = temp;
        }

        return a;
    }

}
