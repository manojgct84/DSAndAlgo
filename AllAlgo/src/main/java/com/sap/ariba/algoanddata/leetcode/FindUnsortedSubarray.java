package com.sap.ariba.algoanddata.leetcode;

import java.util.Arrays;

public class FindUnsortedSubarray {

    /**
     * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
     * <p>
     * Return the shortest such subarray and output its length.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,6,4,8,10,9,15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: 0
     * Example 3:
     * <p>
     * Input: nums = [1]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * -105 <= nums[i] <= 105
     * <p>
     * <p>
     * Follow up: Can you solve it in O(n) time complexity
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {

        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int ans = 0;

        while (start < end) {
            if (nums[start] != copy[start] && nums[end] != copy[end]) {
                ans = end - start + 1;
                break;
            } else if (nums[start] == copy[start] && nums[end] != copy[end]) {
                start++;
            } else if (nums[start] != copy[start] && nums[end] == copy[end]) {
                end--;
            } else if (nums[start] == copy[start] && nums[end] == copy[end]) {
                end--;
                start++;
            }
        }

        return ans;
    }
}
