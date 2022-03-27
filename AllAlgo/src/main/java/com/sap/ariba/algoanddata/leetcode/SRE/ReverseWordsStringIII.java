package com.sap.ariba.algoanddata.leetcode.SRE;

public class ReverseWordsStringIII {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    public static String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        String[] array = s.split(" ");
        for (String value : array) {
            int j = value.length() - 1;
            while (j >= 0) {
                result.append(array[j]);
                j--;
            }
            result.append(" ");

        }
        return result.toString();
    }
}
