package com.sap.ariba.test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class Binary
{

    public static void main (String args[])
    {
        System.out.println(FindBigNum(21));
    }

    static int FindBigNum (long n)
    {
        StringBuffer array = new StringBuffer();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        String dec = null;
        while (n > 0) {
            // String s1 = queue.peek();
            array.append(queue.peek());
            queue.add(queue.peek() + "0");
            queue.add(queue.peek() + "1");
            queue.remove();
            dec = convert(array,dec);
            array.delete(0,array.length());
            n = n - 1;
        }
        queue.remove();
       /* while (n != 0) {
            array.append(n & 1);
            n >>>= 1;
        }*/

        //System.out.println(Integer.parseInt(dec,2));
       /* double temp = Double.parseDouble(dec);
        int base =1;
        double result =0;
        while (temp > 0) {
            double lastDig = temp % 10;
            temp = temp / 10;
            result += lastDig * base;
            base = base * 2;

        }*/

        int ans = 0;
        char[] charArray = dec.toCharArray();
        int[] arr = new int[dec.length()];

        for (int i = 0; i < dec.length(); i++){
            arr[i] = charArray[i] - '0';
            System.out.println(arr[i]);
        }
        System.out.println("arr size " + arr.length);
        int size = arr.length;

        for (int i = 0; i < size; i++)
            ans += arr[i] << (size - i - 1);

        System.out.println(ans);

        return Integer.parseInt(dec,2);

    }

    private static String convert (StringBuffer array,
                                   String temp)
    {
        return temp == null ? "0" + array.toString() : temp + array.toString();

    }
}
