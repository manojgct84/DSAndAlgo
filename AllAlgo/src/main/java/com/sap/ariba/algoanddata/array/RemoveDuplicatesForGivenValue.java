package com.sap.ariba.algoanddata.array;

import java.util.Arrays;

//Morgan Standly - 06/10/2020

public class RemoveDuplicatesForGivenValue {
    /**
     *  Remove the duplicated number that is given give.
     * @param array  {1, 2, 3, 4, 5, 4, 6, 1, 7, 8, 9}
     * @param key - integer number
     * @return  array of integers.
     */
    private static int[] removeDuplicatesForGivenKey(int[] array, int key) {
        if (array.length  == 0) {
             return  array ;
        }
        int i = 0;
        int removedCount = 0;
        while (i < array.length) {
            if (array[i] == key) {
                array[i] = array[i + 1];
                int j = i + 1;
                while (j< array.length) {
                    if (j + 1 < array.length) {
                        array[j] = array[j + 1];
                    } else {
                        removedCount++;
                    }
                    j++;
                }
            }
            i++;
        }
        return Arrays.copyOf(array, array.length - removedCount);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicatesForGivenKey(new int[]{1, 2, 3, 4, 5, 4, 6,
                1, 7, 8, 9}, 4)));
    }
}
