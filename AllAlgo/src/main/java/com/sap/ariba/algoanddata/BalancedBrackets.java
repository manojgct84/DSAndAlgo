package com.sap.ariba.algoanddata;

import java.util.Stack;

public class BalancedBrackets
{
    static String isBalanced (String brackets)
    {
        Stack<Character> stack = new Stack<>();

        if (brackets.length() < 2) {
            return "No";
        }

        for (int i = 0; i < brackets.length(); i++) {
            char value = brackets.charAt(i);
            System.out.print(value);
            // Add the stack
            if (value == '{') {
                stack.push('{');
            }
            else if (value == '(') {
                stack.push('(');
            }
            else if (value == '[') {
                stack.push('[');
            }
            //Remove from the stack
            if (value == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }else {
                    stack.push(')');
                }
            }
            if (value == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }else {
                    stack.push('}');
                }
            }
            if (value == ']') {
                if ( stack.peek() == '[') {
                    stack.pop();
                }else {
                    stack.push(']');
                }
            }
        }

        if (stack.empty()) {
            return "Yes";
        }
        stack.removeAllElements();
        return "No";
    }

    public static void main (String args[])
    {
        System.out.println(isBalanced("[](){()}"));
    }
}
