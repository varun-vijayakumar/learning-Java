package com.javaprep.algorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DpDriver {
    public static void execute() {

        while(true) {
            System.out.print("Enter number : ");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            if (num == -1) break;
            int[] memo = new int[num+1];
            Arrays.fill(memo, -1);
            //System.out.println("dp rec fib : " + Fibonacci.getFibonacci(num,memo));
            //System.out.println("rec fib : " +Fibonacci.getRecFibonacci(num));
            System.out.println("dp bottomUp fib : " + Fibonacci.getBottomUpFibonacci(num));

        }
    }
}
