package com.ariba.sap.test.leecode.Feb;

import java.util.*;


/**
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 * Example 2:
 * <p>
 * Input: s = "aaab", c = "b"
 * Output: [3,2,1,0]
 */
public class ShortestDistanceToCharacter {
    public static int[] shortestToChar(String s, char c) {

        Set<Integer> set = new LinkedHashSet<>();
        char[] ch = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == c) {
                set.add(i);
            }
        }
        int index = -1;
        int marker = 0;
        for (Integer inpIndex : set) {
            int prev = index;
            index = inpIndex;
            for (int i = marker; i < ch.length; i++) {
                if (ch[i] != c) {
                    if (index - i >= 0) {
                        if (prev != -1 && (i - prev < index - i))
                            result.add(i - prev);
                        else
                            result.add(index - i);
                    }
                } else {
                    result.add(0);
                    marker = i + 1;
                    break;
                }
            }
        }
        if (marker != ch.length) {
            for (int i = marker; i < ch.length; i++) {
                if (i - index >= 0) {
                    result.add(i - index);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("baab", 'b')));
    }
}
