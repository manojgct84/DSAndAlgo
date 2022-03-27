package com.leecode.eassy;

import java.util.HashMap;
import java.util.Map;

public class ROMANTOINT {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        int res = 0;
        char[] c = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

         for (int i = 0; i < c.length; i++) {
            if (i <= c.length - 2 && map.get(c[i]) < map.get(c[i + 1])) {
                res -= map.get(c[i]);
            } else {
                res += map.get(c[i]);
            }
        }
        return res;
    }
}
