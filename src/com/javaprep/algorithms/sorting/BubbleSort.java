package com.javaprep.algorithms.sorting;

import utils.CommonUtils;

/**
 * O(n^2)
 */

/**
 * For every iteration,
 *  swap elements adjacent to each other in sorted order.
 *  if no swapping done, stop.
 */
public class BubbleSort {
    public static void sort(int[] a) {
        boolean swapped = false;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            swapped = false;
            for (int j = 0; j < len-i-1; j++) {
                if (a[j] > a[j+1]) {
                    CommonUtils.swapArrayElements(a, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
