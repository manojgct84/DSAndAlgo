package com.ariba.sap.test.leecode.Feb;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 * <p>
 * depth("") = 0
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 * <p>
 * <p>
 * <p>
 * Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).
 * <p>
 * Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.
 * <p>
 * Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them.
 * Example 1:
 * <p>
 * Input: seq = "(()())"
 * Output: [0,1,1,1,1,0]
 * Example 2:
 * <p>
 * Input: seq = "()(())()"
 * Output: [0,0,0,1,1,0,1,1]
 */
public class MaximumNestingDepthTwoValidParenthesesStrings {


    public static void main(String args[]) {
        System.out.println(Arrays.toString(maxDepthAfterSplit("()(())()")));
    }
    /*public static int[] maxDepthAfterSplit(String seq) {

        int a = 0, b = 0;
        int[] result = new int[seq.length()];
        int index = -1;
        for (Character s : seq.toCharArray()) {
            if (s.equals('(')) {
                index++;
                if (a > b) {
                    b++;
                    result[index] = 1;
                } else {
                    a++;
                    result[index] = 0;
                }
            } else {
                index++;
                if (a > b) {
                    a--;
                    result[index] = 0;
                } else {
                    b--;
                    result[index] = 1;
                }
            }
        }
        return result;
    }*/

    public static int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            result[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
        }
        return result;
    }
}
