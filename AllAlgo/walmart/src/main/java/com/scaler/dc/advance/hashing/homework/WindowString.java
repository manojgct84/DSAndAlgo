package com.scaler.dc.advance.hashing.homework;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

    public static void main(String[] args) {
        System.out.println(getMinWindow("ADOBECODEBANC", "ABC"));
        System.out.println(getMinWindow("Aa91b", "ab"));
        System.out.println(getMinWindow("AAAAAA", "AA"));
    }

    public static String getMinWindow(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        char[] b = B.toCharArray();
        for (char value : b) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int resLen = Integer.MAX_VALUE;
        int t = map.size();
        int l = 0;
        int r = 0;
        StringBuilder str = new StringBuilder();
        while (r < A.length()) {
            if (map.containsKey(A.charAt(r))) {
                if (map.get(A.charAt(r)) == 1) { // if there is duplicates it will be handled B[AA]
                    --t;
                }
                map.put(A.charAt(r), map.get(A.charAt(r)) - 1);
            }
            while (t == 0) {
                 if (resLen > (r - l + 1)) {
                    str.delete(0, str.length());
                    str.append(A, l, l + (r - l + 1));
                    resLen = str.length();
                }
                if (map.containsKey(A.charAt(l))) {
                    int val = map.get(A.charAt(l));
                    if (val == 0) {
                        ++t;
                    }
                    map.put(A.charAt(l), val + 1);
                }
                l++;
            }
            r++;
        }
        return str.toString();
    }
}
