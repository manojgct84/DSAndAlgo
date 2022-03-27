package com.walmart.interview;

public class Fibnoacci {

    //0 1, 1, 2 ,3


    public static int fib(int A) {// A = 5

        int[] res = new int[A + 1]; // 6

        if (A == 0) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }
        if (A == 2) {
            return 2;

        }
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= A + 1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[res.length - 1];
        //TC O(2^n)
        //TC O (n) DC O(N)
    }

    public static int minBoatsRequired(int[] A, int k) {
        //This is can be solved with two pointer approch.  i<=j

        //A = 1, 9 ,6,3,4 ,8 = 31 , K =7  31 /7 = 4.xx
        //  3,4 - 1
        //  6, 1, -2
        //  3, 5, 3, 4 k = 5
        //  5 -1
        //  4 -1
        //  3 -1
         //sum =0;
        //A = [3,3,4,5] k =5  // 3, 6,10,15 --> for (int i = 1; i< pref. i++
        // A[i] + sum <=k
        //   sum +=A[i];
        // if (sum = k) count++;
        //else A[i] < k count++;

        if (A.length == 0) {
            return 0;
        }
        int totalWeight = 0;
        for (int i = 0; i < A.length; i++) {
            totalWeight = totalWeight + A[i];
        }

        return (int)Math.floor(totalWeight / k);
    }
    //Kadane’s Algorithm (Maximum Sum Subarray Problem) in Java
    //{-2,-3,4,-1,-2,1,5,3} // solved using the Kadanes Algorithm



}
