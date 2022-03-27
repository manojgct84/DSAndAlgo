package com.sap.ariba.algoanddata.leecode.March;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * You are given an integer array nums representing the data status of this set after the error.
 * <p>
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 * <p>
 * Input: nums = [1,1]
 * Output: [1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                result.add(num);
            } else {
                set.add(num);
            }
        }

        Set<Integer> numset = new HashSet<>(IntStream.of(nums).boxed().collect(Collectors.toList()));
        int i = 1;
        while (i <= numset.size() + 1) {
            if (!numset.contains(i)) {
                result.add(i);
                return result.stream().mapToInt(j -> j).toArray();
            }
            i++;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        findErrorNums(new int[]{1,1});
    }
}
