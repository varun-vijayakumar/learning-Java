package com.javaprep.datastructures.arrays;

import com.javaprep.algorithms.search.BinarySearch;
import com.javaprep.algorithms.sorting.*;
import utils.CommonUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class ArraysDriver {
    public static void sortingDriver() {
        int[] array = {5,4,3,2,1};
        SelectionSort.sort(array);
        System.out.println("Selection Sort");
        CommonUtils.printArray(array);

        int[] array2 = {5,4,1,2,0};
        BubbleSort.sort(array2);
        System.out.println("Bubble Sort");
        CommonUtils.printArray(array2);

        int[] array3 = {5,4,1,2,0};
        InsertionSort.sort(array3);
        System.out.println("Insertion Sort");
        CommonUtils.printArray(array3);

        int[] array4 = {5,4,1,2,6};
        MergeSort.sort(array4, array4.length);
        System.out.println("Merge Sort");
        CommonUtils.printArray(array4);

        int[] array5 = {5,4,3,2,1};
        System.out.println("Quick Sort");
        QuickSort.sort(array5, 0, array5.length-1);
        CommonUtils.printArray(array5);
    }

    public static void binarySearchDriver() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList();
        boolean searchReady = false;
        while(true) {
            if (!searchReady) {
                System.out.print("Enter array : ");
                while(in.hasNext()) {
                    int element = in.nextInt();
                    if (element != -100) {
                        arrayList.add(element);
                    } else {
                        //Collections.sort(arrayList);
                        //Collections.sort(arrayList, Collections.reverseOrder());
                        QuickSort.sortArrayList(arrayList, 0, arrayList.size() - 1);
                        CommonUtils.printArrayList(arrayList);
                        searchReady = true;
                        break;
                    }
                }
            } else {
                System.out.print("Enter number to search : ");
                int num = in.nextInt();
                if (num == -200) {
                    System.out.println("Quitting....");
                    break;
                } else if (num == -100) {
                    arrayList.clear();
                    searchReady = false;
                    continue;
                }

                System.out.println("Searching Number " + num + " ......");
                int index = BinarySearch.searchRecursive(arrayList, 0, arrayList.size() - 1, num);
                System.out.println(index == -1 ? "Not Found" : ("Found at index : " + index));
            }
        }
    }

    public static void dutchFlagDriver() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> tempList;
        int index = 0;
            while(true) {
            System.out.print("Enter array : ");
            while (in.hasNext()) {
                int element = in.nextInt();
                if (element != -100) {
                    arrayList.add(element);
                } else {
                    while (true) {
                        System.out.print("Enter partition index : ");
                        index = in.nextInt();
                        if(index >= arrayList.size()) continue;
                        tempList =(ArrayList<Integer>) arrayList.clone();
                        ArrayListProblems.dutchFlagProblem(tempList, index);
                        CommonUtils.printArrayList(tempList);
                    }
                }
            }
        }
    }

    public static void rotateArrayDriver() {
        int[] array = { 1,2,3,4,5};
        int k;
        Scanner in = new Scanner(System.in);
        CommonUtils.printArray(array);
        System.out.print("Enter rotate index : ");
        k = in.nextInt();
        ArraysProblems.rotate(array, k);
        CommonUtils.printArray(array);
    }

    public static void incrementAribitatryPrecisionIntegerDriver() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int num = 0;
        while(true) {
            System.out.print("Enter digit array : ");
            while(in.hasNext()) {
                num = in.nextInt();
                if (num < 0 || num > 9) {
                    ArrayListProblems.incrementAribitatryPrecisionInteger(arrayList);
                    System.out.println("RESULT : " + arrayList);
                    arrayList.clear();
                    break;
                } else {
                    arrayList.add(num);
                }
            }
        }
    }

    public static void twoSumDriver() {

        int[] nums = {1,2,3,4,5};
        int[] indexes =  ArraysProblems.twoSum(nums, 10);
        System.out.print("Array : ");
        CommonUtils.printArray(nums);
        System.out.print("Indexes : ");
        CommonUtils.printArray(indexes);
    }

    public static void combDriver() {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        System.out.println(ArrayListProblems.combinations(input).toString());
    }
}

