package com.sap.ariba.algoanddata.Codility;

import java.util.HashSet;
import java.util.Set;

public class TravelPlan
{

    public static void main (String args[])
    {
        System.out.println(solution(new int[] { 0, 0, 0, 1, 6, 1, 0, 0 }));
        System.out.println(solution(new int[] { 0, 9, 0, 2, 6, 8, 0, 8, 3, 0 }));
    }

    public static int solution (int a[])
    {
        Set<Integer> path = new HashSet<>();
        int nextCity = 0;
        path.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] == nextCity) {
                path.add(a[i]);
                nextCity = i;
            }
        }
        path.add(nextCity);
        return path.size();

    }
}
