package com.ariba.sap.test.leecode.Feb;

import java.util.List;

public class LongestWordDictionarythroughDeleting {
    /**
     * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
     * <p>
     * Example 1:
     * Input:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     * <p>
     * Output:
     * "apple"
     * Example 2:
     * Input:
     * s = "abpcplea", d = ["a","b","c"]
     * <p>
     * Output:
     * "a"
     * Note:
     * All the strings in the input will only contain lower-case letters.
     * The size of the dictionary won't exceed 1,000.
     * The length of all the strings in the input won't exceed 1,00
     */
    public String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || d.size() == 0) {
            return "";
        }
        String max_str = "";
        for (String word : d) {
            if (isSubsequence(word, s)) {
                if (word.length() > max_str.length()
                        || (word.length() == max_str.length() && word.compareTo(max_str) < 0)) {
                    max_str = word;
                }
            }
        }
        return max_str;
    }

    public boolean isSubsequence(String str1, String str2) {
        int index1 = 0;
        for (int index2 = 0; index2 < str2.length() && index1 < str1.length(); index2++) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                index1++;
            }
        }
        return index1 == str1.length();
    }
}
