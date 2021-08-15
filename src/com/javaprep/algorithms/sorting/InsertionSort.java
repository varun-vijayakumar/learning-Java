package com.javaprep.algorithms.sorting;

import utils.CommonUtils;
/**
 * O(n^2)
 */

/**
 * For every iteration
 *  select a value at a specific index
 *  Move elements of array to left of the selected index in sorted order.
 */
public class InsertionSort {
    public static void sort(int[] a) {
        int current = 0;
        int len = a.length;
        int value = 0;
        for (int i = 0; i < len; i++) {
            current = i;
            value = a[current];
            while (current > 0 && value < a[current-1]) {
                CommonUtils.swapArrayElements(a, current, current-1);
                current--;
            }
        }
    }
}
