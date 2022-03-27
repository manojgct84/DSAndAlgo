package com.sap.ariba.algoanddata.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    /**
     * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
     *
     * Return a list of all possible strings we could create. You can return the output in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: S = "a1b2"
     * Output: ["a1b2","a1B2","A1b2","A1B2"]
     * Example 2:
     *
     * Input: S = "3z4"
     * Output: ["3z4","3Z4"]
     * Example 3:
     *
     * Input: S = "12345"
     * Output: ["12345"]
     * Example 4:
     *
     * Input: S = "0"
     * Output: ["0"]
     */

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        if (S == null || S.length() == 0) {
            list.add("");
            return list;
        }
        List<String> results = letterCasePermutation(S.substring(1));
        for (String result : results) {
            if (Character.isLetter(S.charAt(0))) {
                list.add(S.substring(0, 1).toLowerCase() + result);
                list.add(S.substring(0, 1).toUpperCase() + result);
            } else {
                list.add(S.charAt(0) + result);
            }
        }
        return list;
    }
}
