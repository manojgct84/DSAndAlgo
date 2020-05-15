package com.sap.ariba.algoanddata;

import sun.lwawt.macosx.CSystemTray;
import java.awt.event.AdjustmentEvent;

public class RepeatedString
{

    public static void main (String args[])
    {
        //solution("a", 1000000000000);
    }

    private static void solution (String str,
                                  long number)
    {
        long div = number / str.length();
        int rem = (int)(number % str.length());
        long countChar = 0;

        for (char s : str.toCharArray()) {
            if (s == 'a') {
                countChar++;
            }
        }

        long totalChar = countChar * div;
        if(rem == 0){
            System.out.println(totalChar);
        }else {
            String st = str.substring(0,rem);
            for (char s : st.toCharArray()) {
                if (s == 'a') {
                    totalChar++;
                }
            }
        }
        System.out.println(totalChar);
    }
}
