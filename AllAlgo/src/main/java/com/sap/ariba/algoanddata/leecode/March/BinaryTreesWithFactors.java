package com.sap.ariba.algoanddata.leecode.March;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 * <p>
 * We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.
 * <p>
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 * Example 2:
 * <p>
 * Input: arr = [2,4,5,10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 */
public class BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr); // O(nlogn)

        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) { // O(n2)
            long count = 1L;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    count += map.get(arr[j]) * map.get(arr[i] / arr[j]);
                }

            }
            map.put(arr[i], count);
        }


        long totalCount = 0L;

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            totalCount += entry.getValue();
            System.out.println(" k " + entry.getKey() + " V " + entry.getValue());
        }

        return (int) (totalCount % (1000000000 + 7));
    }

}
