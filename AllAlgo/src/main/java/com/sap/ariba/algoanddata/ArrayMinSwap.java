package com.sap.ariba.algoanddata;

import java.util.HashMap;
import java.util.Map;

public class ArrayMinSwap
{

    public static void main (String args[])
    {
        System.out.println(minimumSwaps(new int[] { 1, 4, 3, 2, 6, 5 }));
    }

    static int minimumSwaps (int[] arr)
    {
        boolean[] visited = new boolean[arr.length + 1];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < visited.length; i++) {
            map.put(i,arr[i - 1]);
        }

        int swapCount = 0;

        for (int i = 1; i < map.size(); i++) {
            int nextIndex;
            if (!visited[i]) {
                visited[i] = true;
                if (!(i == map.get(i))) {
                    int v = map.get(i);
                    // System.out.println("value " + v);
                    //Check if the index is visited and swap the index.
                    while (!visited[v]) {
                        visited[v] = true;
                        nextIndex = map.get(v);
                        // System.out.println("nextIndex " + nextIndex);
                        v = nextIndex;
                        ++swapCount;
                    }
                }
            }
        }
        return swapCount;
    }
}
