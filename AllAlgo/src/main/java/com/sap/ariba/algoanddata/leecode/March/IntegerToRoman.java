package com.sap.ariba.algoanddata.leecode.March;


public class IntegerToRoman {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * <p>
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: num = 3
     * Output: "III"
     * Example 2:
     * <p>
     * Input: num = 4
     * Output: "IV"
     * Example 3:
     * <p>
     * Input: num = 9
     * Output: "IX"
     * Example 4:
     * <p>
     * Input: num = 58
     * Output: "LVIII"
     * Explanation: L = 50, V = 5, III = 3.
     * Example 5:
     * <p>
     * Input: num = 1994
     * Output: "MCMXCIV"
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    public static void main(String args[]) {
         intToRoman(45);
    }

    public static  String intToRoman(int num) {
        String[] roman = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] integer = new int[]{
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        if (num > 3999 && num < 1) {
            return "-1";
        }
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            if (num - integer[i] >= 0) {
                result.append(roman[i]);
                num -= integer[i];
            } else {
                i++;
            }
        }
        return result.toString();
    }
}
