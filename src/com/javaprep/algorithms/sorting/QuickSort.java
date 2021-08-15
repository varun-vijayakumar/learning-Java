package com.javaprep.algorithms.sorting;

import utils.CommonUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * O(N Log N)
 * No Auxillary Space
 */

/**
 * Find a Pivot.
 * Split/Partition Array into 2 parts, left side with elements < Pivot, right side with elements > Pivot.
 *  Recursively perform the follow the below till start index < end index.
 *      find a partition index
 *      choose the pivot.
 *      move elements < pivot to left.
 *      move elements > pivot to right.
 *
 *      finding partion index
 *          pindex = start element of the list
 *          for each element in the list
 *              if curr element is <= pivot then
 *                  swap current element and element at pindex
 *                  pindex++
 *          move the pivot element to the partition index.
 *          return pindex
 *
 * Pivot can be randomly selected. Can use the last element of the array. ( O(N^2)).
 * Pivot can be chosen randomly to enhance the run time. ( O(N Log N)).
 */
public class QuickSort {
    /**
     * Quick Sort of Array List
     * @param arrayList
     * @param start - start index
     * @param end - last element index
     */
    public static void sortArrayList(ArrayList<Integer> arrayList, int start, int end) {
        if (start >= end) return;
        int partitionIndex = partionArrayList(arrayList, start,end);//randomizedPartitionArrayList(arrayList, start, end);
        sortArrayList(arrayList, start, partitionIndex - 1);
        sortArrayList(arrayList, partitionIndex+1, end);
    }

    /**
     * Quick Sort of Array
     * @param a - array
     * @param start - start index
     * @param end - last index
     */
    public static void sort(int[]a, int start, int end) {
        if (start >= end) return;

        /*
         * without randomized partition :
         * int partitionIndex = partition(a, start, end);
         */
        int partitionIndex = randomizedPartition(a, start, end);
        sort(a, start, partitionIndex-1);
        sort(a, partitionIndex+1, end);
    }

    private static int  randomizedPartition(int[] a, int start, int end) {
        Random rand = new Random();
        int randIndex = rand.nextInt(end - start) + start;
        CommonUtils.swapArrayElements(a, end, randIndex);
        return partion(a, start, end);
    }

    private static int partion(int[]a, int start, int end) {
        int pivot = a[end];
        int pIndex = start;
        int i;
        for (i = start; i < end; i++) {
            // elements < pivot to the left side.
            if (a[i] <= pivot) {
                CommonUtils.swapArrayElements(a, i, pIndex);
                pIndex++;
            }
        }
        //move the pivot element to the partition Index.
        CommonUtils.swapArrayElements(a, end, pIndex);
        return pIndex;
    }

    private static int randomizedPartitionArrayList(ArrayList<Integer> arrayList, int start, int end) {
        Random rand = new Random();
        int randIndex = rand.nextInt(end-start) + start;
        CommonUtils.swapArrayListElements(arrayList, randIndex, end);
        return partionArrayList(arrayList, start, end);
    }

    private static int partionArrayList(ArrayList<Integer> arrayList, int start, int end) {
        int i = start;
        int pIndex = start;
        int pivot = arrayList.get(end);
        for (i = start; i < end; i++ ) {

            if (arrayList.get(i) <= pivot) {
                CommonUtils.swapArrayListElements(arrayList, i, pIndex);
                pIndex++;
            }
        }
        CommonUtils.swapArrayListElements(arrayList, end, pIndex);
        return pIndex;
    }

}
