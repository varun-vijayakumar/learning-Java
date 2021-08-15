package com.javaprep.algorithms.search;

import java.util.ArrayList;

public class BinarySearch {
    public static int searchRecursive(ArrayList<Integer> a, int start, int end, int data) {
        if (start == end && a.get(start) == data) return start;
        //else if (start == end && a[start] != data) return -1;
        else if (start > end) return  -1;

        int mid = start + (end - start)/2;
        if (a.get(mid) == data) {
            return mid;
        }
        if (a.get(mid) > data) {
            return searchRecursive(a, start, mid-1, data);
        } else {
            return searchRecursive(a, mid+1, end, data);
        }
    }
}
