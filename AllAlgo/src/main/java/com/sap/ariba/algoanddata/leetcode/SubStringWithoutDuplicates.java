package com.sap.ariba.algoanddata.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SubStringWithoutDuplicates {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int i = 0;
        int j = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (i <= j && j < s.length() && i < s.length()) {
            if (set.contains(s.charAt(j))) {
                maxLen = Math.max(maxLen, j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
                set.add(s.charAt(j));
                j++;
            } else {
                set.add(s.charAt(j));
                j++;
            }
        }
        return Math.max(maxLen, j - i);
    }
}
