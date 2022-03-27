package com.sap.ariba.algoanddata.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * Note* What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (Character str : s.toCharArray()) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        for (Character str : t.toCharArray()) {
            if (map.containsKey(str)) {
                if (map.get(str) == 1) {
                    map.remove(str);
                } else {
                    map.put(str, map.get(str) - 1);
                }
            } else {
                return false;
            }
        }
        return map.size() <= 0;
    }
}