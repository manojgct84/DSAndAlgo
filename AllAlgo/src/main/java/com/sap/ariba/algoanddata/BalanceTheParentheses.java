package com.sap.ariba.algoanddata;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceTheParentheses
{
    public static void main (String arg[])
    {
        // solution("{{})]}");
        solutionStack("{{})]}{(}");
    }

    private static void solution (String parentheses)
    {
        int openCount = 0;
        int closeCount = 0;
        List<Character> openArray = new ArrayList<>();
        List<Character> closeArray = new ArrayList<>();

        if (parentheses.length() < 1) {
            System.out.println("No");
        }
        char[] chars = parentheses.toCharArray();

        for (char aChar : chars) {

            if (aChar == '[' || aChar == '(' || aChar == '{') {
                openCount++;
                openArray.add(aChar);
            }
            else if (aChar == ']' || aChar == ')' || aChar == '}') {
                closeCount++;
                closeArray.add(aChar);
            }
        }

        if (openCount == closeCount) {
            System.out.println("No need to balance it");
        }

        boolean notMatch = false;
        Character toInsertOpen = null;
        Character toInsertClose = null;

        String append = null;
        if (openCount < closeCount) {
            int i = 0, j = 0;
            while (i < openArray.size()) {
                if (openArray.get(i) == '{' && closeArray.get(closeArray.size() - 1 - j) == '}') {
                    notMatch = true;
                }
                else if (openArray.get(i) == '['
                                && closeArray.get(closeArray.size() - 1 - j) == ']') {
                    notMatch = true;
                }
                else if (openArray.get(i) == '('
                                && closeArray.get(closeArray.size() - 1 - j) == ')') {
                    notMatch = true;
                }

                if (notMatch) {
                    notMatch = false;
                    if (append == null) {
                        append = String.valueOf(openArray.get(i));
                    }
                    else {
                        append = append.concat(String.valueOf(openArray.get(i)));
                    }

                    i++;
                }
                else {
                    if (closeArray.get(j) == '}') {
                        toInsertOpen = '{';
                    }
                    else if (closeArray.get(j) == ']') {
                        toInsertOpen = '[';
                    }
                    else if (closeArray.get(j) == ')') {
                        toInsertOpen = '(';
                    }
                    if (append == null) {
                        append = String.valueOf(toInsertOpen);
                    }
                    else {
                        append = append.concat(String.valueOf(toInsertOpen));
                    }
                }
                j++;
            }
            System.out.println("Corrected ");
            System.out.print(String.format(append.toString()));
            closeArray.forEach(System.out::print);
        }
        else if (closeCount < openCount) {
            int i = 0, j = 0;
            while (i < closeArray.size()) {

                if (openArray.get(j) == '{' && closeArray.get(closeArray.size() - 1 - i) == '}') {
                    notMatch = true;
                }
                else if (openArray.get(j) == '['
                                && closeArray.get(closeArray.size() - 1 - i) == ']') {
                    notMatch = true;
                }
                else if (openArray.get(j) == '('
                                && closeArray.get(closeArray.size() - 1 - i) == ')') {
                    notMatch = true;
                }

                if (notMatch) {
                    notMatch = false;
                    if (append == null) {
                        append = String.valueOf(closeArray.get(i));
                    }
                    else {
                        append = String.valueOf(closeArray.get(i)).concat(append);
                    }

                    i++;
                }
                else {
                    if (openArray.get(j) == '{') {
                        toInsertClose = '}';
                    }
                    else if (openArray.get(j) == '[') {
                        toInsertClose = ']';
                    }
                    else if (openArray.get(j) == '(') {
                        toInsertClose = ')';
                    }
                    if (append == null) {
                        append = String.valueOf(toInsertClose);
                    }
                    else {
                        append = String.valueOf(toInsertClose).concat(append);
                    }
                }

                j++;

            }
            System.out.println("Corrected ");
            openArray.forEach(System.out::print);
            System.out.print(String.format(append));
        }

    }

    private static void solutionStack (String parentheses)
    {

        Stack<Character> open = new Stack<>();
        Stack<Character> close = new Stack<>();

        if (parentheses.length() < 1) {
            System.out.println("No");
        }
        char[] chars = parentheses.toCharArray();
        //{[(}{(}
        //open - {[(

        //{{})]}{(}
        List<String> solution = new ArrayList<>();
        for (char aChar : chars) {
            if (aChar == '[' || aChar == '(' || aChar == '{') {
                open.push(aChar);
            }
            else if (!open.isEmpty()) {
                if (open.peek() == '{' && aChar == '}') {
                    solution.add("" + open.pop() + aChar);
                }
                else if (open.peek() == '(' && aChar == ')') {
                    solution.add("" + open.pop() + aChar);
                }
                else if (open.peek() == '[' && aChar == ']') {
                    solution.add("" + open.pop() + aChar);
                }
                else {
                    if (aChar == ')') {
                        solution.add("(" + aChar);
                    }
                    if (aChar == '}') {
                        solution.add("{" + aChar);
                    }
                    if (aChar == ']') {
                        solution.add("[" + aChar);
                    }
                }
            }
        }

        while (!open.isEmpty()) {
            solution.add("" + open.pop());
        }
    }
}
