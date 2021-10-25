package com.scaler.dc.advance.array1;

public class ClosestMinMax {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{343, 291, 963, 165, 152}));
    }

    public static int solve(int[] A) {
        if (A.length == 1) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int j : A) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }

        int max_index = 0;
        int min_index = 0;

        int res = Integer.MIN_VALUE;
        System.out.println("max " + max + " min " + min);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == max) {
                max_index = i;
            } else if (A[i] == min) {
                min_index = i;
            }
            System.out.println("max_index " + max_index + " min_index " + min_index);
            int val = Math.max(max_index, min_index) - Math.min(max_index, min_index) + 1;
            res = Math.max(res, val);
            System.out.println("res " + res);
        }
        return res;
    }
}
