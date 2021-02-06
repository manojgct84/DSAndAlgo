package com.sap.ariba.algoanddata.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: 2
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,1]
 * Output: 0
 */

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (Integer num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        count = 0;
        for (int key : nums) {
            if (hashMap.containsKey(key + 1)) {
                count = Math.max(count, hashMap.get(key) + hashMap.get(key + 1));
            }
        }
        return count;
    }
}
