package com.javaprep.algorithms.recursion;

import com.javaprep.datastructures.lists.LinkedListBasic;

import java.util.LinkedList;

public class RecursionBasic {
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

}
