package com.leecode;

public class ReverseWordsStringIII {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        String[] array = s.split(" ");
        for (int i = 0; i < array.length; i++) {
            int j = array[i].length();
            while (j > 0) {
                result.append(array[i].charAt(j - 1));
                j--;
            }
            if (i < array.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
