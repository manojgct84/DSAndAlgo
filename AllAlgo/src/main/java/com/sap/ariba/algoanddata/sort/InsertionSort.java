package com.sap.ariba.algoanddata.sort;

public class InsertionSort
{
    //A={5; 2; 4; 6; 1; 3}.
    static String sort (int[] a)
    {
        int i = 0;

        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            System.out.println("Key " + key);
            i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
        return a.toString();
    }

    public static void main (String args[])
    {
        System.out.println(sort(new int[] { 5, 2, 4, 6, 1, 3 }));
    }
}
