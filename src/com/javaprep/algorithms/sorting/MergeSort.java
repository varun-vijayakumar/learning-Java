package com.javaprep.algorithms.sorting;

/**
 * O(N log N)
 * Auxillary Space - O(N)
 */
/**
 *  Recursively perform the following.
 *      Find middle of the array - mid
 *      create 2 auxillary arrays
 *          left array = main array [0 to mid]
 *          right array = main array [mide + 1 to end]
 *      perform sorted merge of left array and right array to main array.
 */
public class MergeSort {
    public static void sort(int[] a, int len) {
        if(len < 2) {
            return;
        }

        int mid = len / 2;
        int lenLeft = mid;
        int lenRight = len - mid;
        int[] left = new int[lenRight];
        int[] right = new int[lenRight];
        for (int i = 0; i < lenLeft; i++) {
            left[i] = a[i];
        }
        for (int i = 0; i < lenRight; i++) {
            right[i] = a[mid+i];
        }

        sort(left, lenLeft);
        sort(right, lenRight);
        sortedMerge(left, lenLeft, right, lenRight, a);
    }

    public static void sortedMerge(int[] left, int lenLeft, int[] right, int lenRight, int[] a) {
        int i = 0, j = 0, k = 0;

        while(i < lenLeft && j < lenRight) {
            if (left[i] < right[j]) {
                a[k] = left[i];
                k++;
                i++;
            } else {
                a[k] = right[j];
                k++;
                j++;
            }
        }

        while(i < lenLeft) {
            a[k] = left[i];
            k++;
            i++;
        }
        while(j < lenRight) {
            a[k] = right[j];
            k++;
            j++;
        }
    }
}
