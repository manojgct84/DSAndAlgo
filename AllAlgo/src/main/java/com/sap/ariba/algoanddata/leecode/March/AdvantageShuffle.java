package com.sap.ariba.algoanddata.leecode.March;


import java.util.Arrays;
import java.util.TreeMap;

/**
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 * <p>
 * Return any permutation of A that maximizes its advantage with respect to B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 * <p>
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */


public class AdvantageShuffle {

    public static void main(String args[]) {
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
    }

    public static int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> store = new TreeMap<>();
        for (int i : A) {
            store.put(i, store.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[A.length];

        for (int i = 0; i < A.length; ++i) {

            Integer x = store.higherKey(B[i]);

            if (x == null) x = store.firstKey();

            store.put(x, store.get(x) - 1);

            if (store.get(x) == 0) {
                store.remove(x);
            }
            res[i] = x;
        }
        return res;
    }

}
