package com.javaprep.algorithms.sorting;

import utils.CommonUtils;

/**
 * O(n^2)
 */

/**
 * For every iteration,
 *      Start index from the i+1 element
 *      Find the minimum position .
 *      Swap the element at minimum position to element at index.
 */
public class SelectionSort {
    public static void sort(int[] a) {
        int iMin = 0;
        int len = a.length;
        for (int i = 0; i < len-1; i++) {
            iMin = i;
            for (int j = i+1; j < len; j++) {
                if (a[j] < a[iMin]) {
                    iMin = j;
                }
            }
            CommonUtils.swapArrayElements(a, i, iMin);
        }
    }
}
