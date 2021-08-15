package com.javaprep.datastructures.strings;

import java.util.Scanner;

public class StringsDriver {
    public static void palindromeDriver() {
        String s;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Palindrome check, enter the string : ");
            s = in.nextLine();
            if (s.length() == 0) break;
            System.out.println(s + " : " +
                    (StringsProblems.isPalindrome(s) ? "is a palindrome " : "is NOT a palindrome"));
        }
    }

    public static void strToIntDriver() {
        String s;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the num string : ");
            s = in.nextLine();
            double value = StringsProblems.stringToInteger(s);
            if (value == 0) {
                System.out.println(s + " is not a valid num string");
                continue;
            }
            System.out.println("Answer : "+ value);
        }
    }

    public static void intToStringDriver() {
        int num;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the num  : ");
            num = in.nextInt();
            String value = StringsProblems.intToString(num);
            if (value == null) {
                System.out.println(num + " is not valid to convert to a string");
                continue;
            }
            System.out.println("Answer : " + value);
        }
    }

    public static void columnIdDriver() {
        String col;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the columnID  : ");
            col = in.nextLine();
            System.out.println("Answer : " + StringsProblems.columnId(col));
        }
    }

    public static void replaceAndRemoveDriver() {
        String smain ;
        char[] s;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Enter the string :");
            smain = in.nextLine();
            s = smain.toCharArray();
            System.out.println("final size : " + StringsProblems.replaceAndRemove(s, s.length));
            System.out.println(s);
            //s[10] = '1';
            System.out.println(s);
        }
    }

    public static void atoiDriver() {
        String s;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the num string : ");
            s = in.nextLine();
            int value = StringsProblems.myAtoi(s);
            if (value == 0) {
                System.out.println(s + " is not a valid num string");
                continue;
            }
            System.out.println("Answer : "+ value);
        }
    }


    public static void stringExtractDriver() {
        String s;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Enter the string : ");
            s= in.nextLine();
            if (s.equals(-1)) {
                System.out.println("Exiting");
                return;
            }
            StringsProblems.extractString(s);
        }
    }

    public static void stringCompareDriver() {
        String s;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Enter the string : ");
            s= in.nextLine();
            if (s.equals(-1)) {
                System.out.println("Exiting");
                return;
            }
            StringsProblems.stringCompare(s);
        }
    }
}
