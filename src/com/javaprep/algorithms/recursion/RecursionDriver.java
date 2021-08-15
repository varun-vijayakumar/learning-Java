package com.javaprep.algorithms.recursion;

import java.util.Scanner;

public class RecursionDriver {
    public static void recrursionDriver() {
        int s;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Enter the fib range : ");
            s= in.nextInt();
            if (s == -1) {
                System.out.println("Exiting");
                return;
            }
            System.out.println("fibonacci("+s+") = "+RecursionBasic.fibonacci(s));
            for (int i = 0; i <= s; i++) {
                System.out.print(RecursionBasic.fibonacci(i)+ " ");
            }
            System.out.println();
        }
    }
}
