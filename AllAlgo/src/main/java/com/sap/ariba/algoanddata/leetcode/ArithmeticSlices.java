package com.sap.ariba.algoanddata.leetcode;

public class ArithmeticSlices {

    /**
     * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
     * <p>
     * For example, these are arithmetic sequences:
     * <p>
     * 1, 3, 5, 7, 9
     * 7, 7, 7, 7
     * 3, -1, -5, -9
     * The following sequence is not arithmetic.
     * <p>
     * 1, 1, 2, 5, 7
     * <p>
     * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
     * <p>
     * A slice (P, Q) of the array A is called arithmetic if the sequence:
     * A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
     * <p>
     * The function should return the number of arithmetic slices in the array A.
     * <p>
     * <p>
     * Example:
     * <p>
     * A = [1, 2, 3, 4]
     * <p>
     * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
     *
     * @param A
     * @return
     */

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int currentValue = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                currentValue++;
                sum += currentValue;
            } else {
                currentValue = 0;
            }
        }
        return sum;
    }
}
