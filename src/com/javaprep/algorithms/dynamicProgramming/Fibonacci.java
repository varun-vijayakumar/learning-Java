package com.javaprep.algorithms.dynamicProgramming;

public class Fibonacci {
    public static int getRecFibonacci(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        } else {
            return getRecFibonacci(num - 1) + getRecFibonacci(num-2);
        }
    }
    public static int getFibonacci(int num, int[] memo) {
        if (memo[num] != -1) {
            return memo[num];
        }
        int result = 0;
        if (num == 1 || num == 2 ) {
            result = 1;
        } else {
            result = getFibonacci(num-1, memo) + getFibonacci(num-2, memo);
        }
        memo[num] = result;
        return result;
     }

    public static int getBottomUpFibonacci(int num) {
        if (num == 0) return 0;
        else if (num == 1 || num == 2) return 1;
        else {
            int[] bottomUp = new int[num+1];
            bottomUp[0] = 0;
            bottomUp[1] = 1;
            bottomUp[2] = 1;

            for (int i = 3; i <= num; i++) {
                bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
            }
            return bottomUp[num];
        }
    }
}
