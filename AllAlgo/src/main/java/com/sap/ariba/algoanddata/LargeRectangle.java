package com.sap.ariba.algoanddata;

import java.util.Map;
import java.util.Stack;

public class LargeRectangle
{
    static long largestRectangle (int[] h)
    {
        Stack<Integer> index = new Stack<>();
        int topIndex = 0;
        int maxArea = 0;
        int area = 0;
        int i = 0;
        while (i < h.length) {
            if (index.isEmpty() || h[index.peek()] <= h[i]) {
                index.push(i);
                i++;
            }
            else {
                topIndex = index.pop();
                area = h[topIndex] * (index.isEmpty() ? (i) : i - index.peek() - 1);
                maxArea = Math.max(area,maxArea);
            }
        }

        while (!index.isEmpty()) {
            topIndex = index.pop();
            area = h[topIndex ] * (index.isEmpty() ? (i) : i - index.peek() - 1);
            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
    }

    public static void main (String args[])
    {
        System.out.println(largestRectangle(new int[] { 11, 11, 10, 10, 10 }));
        System.out.println(largestRectangle(new int[] { 1, 2, 3, 4, 5 }));
    }
}
