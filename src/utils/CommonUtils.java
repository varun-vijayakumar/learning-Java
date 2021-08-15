package utils;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CommonUtils {
    public static void printArray(int[] a) {
        int i = 0;
        System.out.print("[");
        while(i < a.length) {
            System.out.print(a[i]);
            i++;
            if(i != a.length) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    public static void swapArrayElements(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    public static void swapArrayListElements(ArrayList<Integer> arrayList, int idx1, int idx2) {
        int temp = arrayList.get(idx1);
        arrayList.set(idx1, arrayList.get(idx2));
        arrayList.set(idx2, temp);
    }

    public static void printArrayList(ArrayList<Integer> arrayList) {
        /*
        for (int i = 0; i < arrayList.size()-1;i++) {
            System.out.print(arrayList.get(i));
        }
        System.out.println();*/
        System.out.println(arrayList);
    }

    public static double powerOf(int num, int exp) {
        double result = 1;
        if (exp == 0) return 1;

        for (int i = 0; i < exp; i++) {
            result = result * num;
        }
        return result;
    }
    /*
     for(int i = 0; i < 5; ++i) {
        System.out.println("MAIN i : " + i);
        for (int j = i + 1; j < 5; ++j) {
            System.out.print(" i : " + i + " j : " + j);
        }
        System.out.println();
     }

     int num = 0;
     int exp = 0;
     Scanner in = new Scanner(System.in);
     while (true) {
        System.out.print("Enter number : ");
        num = in.nextInt();
        System.out.print("Enter exp : ");
        exp = in.nextInt();
        System.out.println("Output of " + num + "^"+exp+ "  : "+ CommonUtils.powerOf(num, exp));
     }
    */
    /**
     * Check if a string matches a regular expression.
     *
     * @param text the String to check
     * @param regex the regular expression
     * @return true if the text matches the regex pattern
     */
    public static boolean matchesRegex(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).matches();
    }
}
