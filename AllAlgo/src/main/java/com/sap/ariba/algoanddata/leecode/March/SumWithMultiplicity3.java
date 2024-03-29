package com.sap.ariba.algoanddata.leecode.March;

import java.util.HashMap;
import java.util.Map;

public class SumWithMultiplicity3 {
    /**
     * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
     * <p>
     * As the answer can be very large, return it modulo 109 + 7.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
     * Output: 20
     * Explanation:
     * Enumerating by the values (arr[i], arr[j], arr[k]):
     * (1, 2, 5) occurs 8 times;
     * (1, 3, 4) occurs 8 times;
     * (2, 2, 4) occurs 2 times;
     * (2, 3, 3) occurs 2 times.
     * Example 2:
     * <p>
     * Input: arr = [1,1,2,2,2,2], target = 5
     * Output: 12
     * Explanation:
     * arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
     * We choose one 1 from [1,1] in 2 ways,
     * and two 2s from [2,2,2,2] in 6 ways.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 3 <= arr.length <= 3000
     * 0 <= arr[i] <= 100
     * 0 <= target <= 300
     */

    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            res = (res + map.getOrDefault(target - arr[i], 0)) % mod;

            for (int j = 0; j < i; j++) {
                int temp = arr[i] + arr[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }
}
