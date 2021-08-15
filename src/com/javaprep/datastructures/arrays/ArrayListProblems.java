package com.javaprep.datastructures.arrays;

import com.javaprep.datastructures.lists.LinkedListBasic;
import utils.CommonUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArrayListProblems {
    /**
     * Given an arrayList and an index, sort elements such that element < element at index is left,
     * greater to the right.
     * Example :
          Enter arrayList : 0 1 2 0 2 1 1
          Enter partition index : 2
          [0, 1, 0, 1, 1, 2, 2]
          Enter partition index : 3
          [0, 0, 1, 2, 2, 1, 1]
          Enter partition index : 1
          [0, 0, 1, 1, 1, 2, 2]
     * @param arrayList
     * @param index
     */
    public static void dutchFlagProblem(ArrayList<Integer> arrayList, int index) {

        /*
        int pivot = arrayList.get(index);
        int size = arrayList.size();
        int pIndex = 0;
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i) < pivot) {
                CommonUtils.swapArrayListElements(arrayList, i, pIndex);
                pIndex++;
            }
        }
        pIndex = size - 1;
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList.get(i) > pivot) {
                CommonUtils.swapArrayListElements(arrayList, i, pIndex);
                pIndex--;
            }
        }*/
        int size = arrayList.size();
        int pivot = arrayList.get(index);

        int smaller = 0, equal = 0, larger = size - 1;
        while(equal <= larger) {
            //System.out.println("start e = " + equal + " s = " + smaller + " l = " + larger + " array = " + arrayList);
            if (arrayList.get(equal) < pivot) {
                CommonUtils.swapArrayListElements(arrayList, equal, smaller);
                smaller++;
                equal++;
            } else if(arrayList.get(equal) > pivot) {
                CommonUtils.swapArrayListElements(arrayList, equal, larger);
                larger--;
            } else {
                equal++;
            }
            //System.out.println(" end  e = " + equal + " s = " + smaller + " l = " + larger + " array = " + arrayList);
            //System.out.println();
        }
    }

    /**
     * Take an array of digits , add + 1 to the integer combining the digits and update the
     * array with result.
     * [1,2,9] ==> [1,3,0]       (129 + 1)
     * [9,9,9] ==> [1,0,0,0]     (999 + 1)
     * @param arrayList
     */
    public static void incrementAribitatryPrecisionInteger(ArrayList<Integer> arrayList) {
        boolean carry = false;
        int len = arrayList.size();
        int perDigitSum = arrayList.get(len-1) + 1;
        if (perDigitSum == 10) {
            carry = true;
            arrayList.set(len-1, 0);
        } else {
            arrayList.set(len-1, perDigitSum);
        }
        if (carry) {
            for (int i = len-2; i>=0; i--) {
                if (carry) {
                    perDigitSum = arrayList.get(i) + 1;
                    if (perDigitSum == 10) {
                        carry = true;
                        arrayList.set(i, 0);
                    } else {
                        carry = false;
                        arrayList.set(i, perDigitSum);
                    }
                }
            }
        }

        //System.out.print("Arr : " + arrayList + " len : "+ len);
        if (carry && arrayList.get(0) == 0) {
            arrayList.set(0, 1);
            arrayList.add(0);
        }
    }

    public static HashSet combinations(ArrayList<Integer> input) {
        HashSet<ArrayList> combList = new HashSet<ArrayList>();
        ArrayList<Integer> comb;
        combList.add(input);
        combList.add(new ArrayList());
        for (int i = 0; i < input.size(); i++) {
            comb = new ArrayList<>();
            comb.add(input.get(i));
            combList.add(comb);
            for (int j = i+1; j < input.size(); j++) {

                comb.add(input.get(i));
                comb.add(input.get(j));
                combList.add(comb);
            }
        }
        return combList;
    }
}

