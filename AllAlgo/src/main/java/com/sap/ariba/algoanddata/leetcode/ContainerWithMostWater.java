package com.sap.ariba.algoanddata.leetcode;

public class ContainerWithMostWater {

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     * <p>
     * Notice that you may not slant the container.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     * Example 2:
     * <p>
     * Input: height = [1,1]
     * Output: 1
     * Example 3:
     * <p>
     * Input: height = [4,3,2,1,4]
     * Output: 16
     * Example 4:
     * <p>
     * Input: height = [1,2,1]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == height.length
     * 2 <= n <= 3 * 104
     * 0 <= height[i] <= 3 * 104
     */

    public int maxArea(int[] height) {
        if (height.length == 0 || height.length < 2) {
            return 2;
        }

        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

}
