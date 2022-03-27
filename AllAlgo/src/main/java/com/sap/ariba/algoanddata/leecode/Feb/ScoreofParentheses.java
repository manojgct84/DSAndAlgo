package com.sap.ariba.algoanddata.leecode.Feb;

import java.util.Stack;

public class ScoreofParentheses {

    /**
     * Given a balanced parentheses string S, compute the score of the string based on the following rule:
     * <p>
     * () has score 1
     * AB has score A + B, where A and B are balanced parentheses strings.
     * (A) has score 2 * A, where A is a balanced parentheses string.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: "()"
     * Output: 1
     * Example 2:
     * <p>
     * Input: "(())"
     * Output: 2
     * Example 3:
     * <p>
     * Input: "()()"
     * Output: 2
     * Example 4:
     * <p>
     * Input: "(()(()))"
     * Output: 6
     */

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // The score of the current frame
        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int top = stack.pop();
                int result = stack.pop();
                if (top == 0)
                    result += 1;
                else
                    result += 2 * top;
                stack.push(result);
            }
        }
        return stack.pop();
    }

}
