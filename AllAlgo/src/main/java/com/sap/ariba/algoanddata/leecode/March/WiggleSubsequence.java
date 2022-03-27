package com.sap.ariba.algoanddata.leecode.March;

public class WiggleSubsequence {

    /**
     * Given an integer array nums, return the length of the longest wiggle sequence.
     * <p>
     * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
     * <p>
     * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) are alternately positive and negative.
     * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
     * A subsequence is obtained by deleting some elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
     */
    public int wiggleMaxLength(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length < 2) {
            return nums.length;
        }

        int count = 1;
        int j = 0;

        for (int i = 1; i < nums.length; j = i, i++) {
            if (nums[j] < nums[i]) {
                count++;
                while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                    i++;
                }
            } else if (nums[j] > nums[i]) {
                count++;
                while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                    i++;
                }
            }
        }
        return count;

    }

}
