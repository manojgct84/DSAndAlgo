package com.sap.ariba.algoanddata.leecode.March;

import java.util.Arrays;

public class MissingNumber {

    /**
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
     * <p>
     * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [0,1]
     * Output: 2
     * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
     * <p>
     * Example 3:
     * <p>
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
     * <p>
     * Example 4:
     * <p>
     * Input: nums = [0]
     * Output: 1
     * Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= n <= 104
     * 0 <= nums[i] <= n
     * All the numbers of nums are unique.
     */

    public static void main(String args[]) {
        missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length;
        while (start < end) {
            int m = (start + end) / 2;
            if (nums[m] > m) {
                end = m;
            } else {
                start = m + 1;
            }
        }
        return end;
    }
}

