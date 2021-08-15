package com.javaprep.datastructures.stacks;

import java.util.Stack;

public class StackDriver {

    public static void stackBasicExample() {
        StackBasic stackBasic = new StackBasic(10);
        for (int i = 0; i < 7 ; i++) {
            System.out.println(stackBasic.toString());
            stackBasic.push(i);
            System.out.println("Top :  " + stackBasic.top() + " Size : " + stackBasic.currentSize());
        }
        System.out.println(stackBasic);

        System.out.println(stackBasic.contains(5));
        System.out.println(stackBasic.contains(100));

        System.out.println();
        System.out.println(stackBasic.isEmpty());

        System.out.println();
        System.out.println("Top :  " + stackBasic.top() + " Size : " + stackBasic.currentSize());
        System.out.println(stackBasic.access(3));
        System.out.println("Top :  " + stackBasic.top() + " Size : " + stackBasic.currentSize());

        for (int i = 0; i < 4 ; i++) {
            System.out.println(stackBasic.toString());
            if (!stackBasic.isEmpty()) {
                System.out.println("POPPING Top :  " + stackBasic.top() + " Size : " + stackBasic.currentSize());
                stackBasic.pop();
            }
        }

        System.out.println("\nSize : " + stackBasic.currentSize());
        System.out.println(stackBasic.toString());
    }

    public static void javaStackExample() {
        /**
         * Java provides two sets of implementations.
         * Stack <E> - Uses Vector as underlying implemention.Synchronous.
         * Dequeue <E> - Various Implementations like ArrayDeque.
         */
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < 5; i++) {

            System.out.println(stack.isEmpty());
            System.out.println(" Push : " +  stack.push(i+10));
            System.out.println("> Peek : "+ stack.peek());
            System.out.println(stack);
        }

        System.out.println("-------------------");
        System.out.println("Top : "+ stack.peek());
        System.out.println("Empty : "+ stack.empty());
        System.out.println("Add " + stack.add(10));
        System.out.println(stack);
        System.out.println("Element at 3 : " + stack.elementAt(3));

        System.out.println("-------------------");
        for(int i = 0; i < 5; i++) {
            System.out.println(stack.isEmpty());
            System.out.println("Popping : " + stack.pop());
            System.out.println(stack);
        }

    }
}
