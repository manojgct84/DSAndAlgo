package com.leecode;

import java.util.Arrays;

public class ArrayZigzag {
    /**
     * Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
     * <p>
     * An array A is a zigzag array if either:
     * <p>
     * Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
     * OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
     * Return the minimum number of moves to transform the given array nums into a zigzag array.
     *
     * @param nums
     * @return Input: nums = [1,2,3]
     * 0,1,2
     * Output: 2
     * Explanation: We can decrease 2 to 0 or 3 to 1.
     */

    public static void main(String[] args) {
        System.out.println(movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
        //System.out.println(movesToMakeZigzagNotMine(new int[]{9, 6, 1, 6, 2}));
    }

    public static int movesToMakeZigzag(int[] nums) {
        int len = nums.length;
        int even = 0;
        int odd = 0;
        int[] second;
        second = Arrays.copyOf(nums, len);
        for (int i = 0; i < len; i++) {
            if (i + 1 < len) {
                if (i % 2 == 0) {
                    if (nums[i] <= nums[i + 1]) {
                        int diff = nums[i + 1] - nums[i];
                        even += diff + 1;
                        nums[i + 1] = nums[i + 1] - (diff + 1);
                    }
                } else if (nums[i] >= nums[i + 1]){
                    int diff = nums[i] - nums[i + 1];
                    even += diff + 1;
                    nums[i] = nums[i] - (diff + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(nums));
        int sLen = second.length;
        for (int i = 0; i < sLen; i++) {
            if (i + 1 < len) {
                if (i % 2 == 0) {
                    if (second[i] >= second[i + 1]) {
                        int diff = second[i] - second[i + 1];
                        odd += diff + 1;
                        second[i] = second[i] - (diff + 1);
                    }
                } else if (second[i] <= second[i + 1]){
                    int diff = second[i + 1] - second[i];
                    odd += diff + 1;
                    second[i + 1] = second[i + 1] - (diff + 1);
                }
            }
        }
        //  System.out.println(Arrays.toString(second));
        return Math.min(even, odd);
    }
}
