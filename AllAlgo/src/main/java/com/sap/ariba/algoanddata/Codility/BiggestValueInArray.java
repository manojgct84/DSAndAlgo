package com.sap.ariba.algoanddata.Codility;

import java.util.HashMap;
import java.util.Map;

public class BiggestValueInArray
{

    public static void main (String[] args)
    {
        System.out.print(solution(new int[] { 3, 8, 2, 3, 3, 2 }));
    }

    public static int solution (int[] A)
    {
        HashMap<Integer, Integer> store = new HashMap<>();
        for (int value : A) {
            store.put(value,store.getOrDefault(value,0) + 1);
        }
        int key = Integer.MIN_VALUE;
        int result = 0;
        for (Map.Entry<Integer, Integer> entity : store.entrySet()) {
            if (entity.getKey().equals(entity.getValue())) {
                if (key < entity.getKey()) {
                    key = entity.getKey();
                    result = entity.getValue();
                }
            }
        }
        return result;
    }
}
