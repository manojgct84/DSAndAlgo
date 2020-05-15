package com.sap.ariba.algoanddata;

import java.util.ArrayList;
import java.util.List;

public class SubStringIntelligent
{

    private static int getSpecialSubString (String s,
                                            int k,
                                            String charValue)
    {

        String alpha = "abcdefghijklmnopqrstuvwxyz";

        char[] alphaArray = alpha.toCharArray();
        List<Character> specialCharMap = new ArrayList<>();

        for (int i = 0; i < charValue.length(); i++) {
            if (charValue.charAt(i) == '0') {
                specialCharMap.add(alphaArray[i]);
            }
        }

        char[] str = s.toCharArray();
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length - 1; i++) {
            int index2 = i;
            int j = 0;
            while (j <= k) {
                if (specialCharMap.contains(str[index2])) {
                    if (j < k) {
                        sb.append(str[index2]);
                        j++;
                    }
                    else {
                        break;
                    }
                }
                else if (!specialCharMap.contains(str[index2])) {
                    sb.append(str[index2]);
                }
                if (index2 == str.length - 1) {
                    break;
                }
                index2++;
            }
            System.out.println("result :" + sb.toString());
            res.add(sb.toString());
            sb.delete(0,sb.length());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).length() > max) {
                max = res.get(i).length();
            }
        }
        return max;
    }

    public static void main (String args[])
    {
        System.out.println("max sub string possible for k : " + getSpecialSubString("giraffe",
                                                                                    2,
                                                                                    "01111001111111111011111111"));

        System.out.println("max sub string possible for k : " + getSpecialSubString("abcde",
                                                                                    2,
                                                                                    "10101111111111111111111111"));

        System.out.println("max sub string possible for k : " + getSpecialSubString("Manojkumar",
                                                                                    3,
                                                                                    "01111001111111111011111111"));

    }
}
