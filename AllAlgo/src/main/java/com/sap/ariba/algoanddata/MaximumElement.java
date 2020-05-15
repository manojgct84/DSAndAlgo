package com.sap.ariba.algoanddata;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement
{
    static Stack<Integer> minStack = new Stack<>();
    static Stack<Integer> maxStack = new Stack<>();

   /* static {
        maxStack.push(Integer.MIN_VALUE);
    }*/

    static int maxValue = Integer.MIN_VALUE;

    static void maxElement (int op,int value)
    {

        switch (op) {
        case 1:
            minStack.push(value);
            maxStack.push(Math.max(value,maxStack.isEmpty() ? value : maxStack.peek()));
            break;
        case 2:
            minStack.pop();
            maxStack.pop();
            break;
        case 3:
            System.out.println(maxStack.peek());
            break;
        }
    }

    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int op = sc.nextInt();
            int value = sc.nextInt();
            maxElement(op,value);
        }
        sc.close();

    }
}
