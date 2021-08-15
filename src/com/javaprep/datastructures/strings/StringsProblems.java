package com.javaprep.datastructures.strings;

import utils.CommonUtils;

import java.util.HashSet;
import java.util.Set;

public class StringsProblems {
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static double stringToInteger(String s) {
        int size = s.length();
        int i = 0, j;
        double result = 0;
        boolean negative = false;

        for (j = size - 1; j >= 0; j--) {
            if (s.charAt(j) == '-') {
                if (j != 0) {
                    return 0;
                }
                negative = true;
                break;
            }

            int c = s.charAt(j) - 48;
            if (c < 0 || c > 9) {
                return 0;
            }

            result = result + (c * CommonUtils.powerOf(10, i));
            i++;
        }

        if (negative) {
            result = 0 - result;
        }
        return result;
    }

    public static String intToString(int num) {
        StringBuilder finalString = new StringBuilder();
        int result = 0;
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num = -(num);
        }
        while ((num / 10) != 0) {
            result = num % 10;
            num = num / 10;
            finalString.append(result);
        }
        finalString.append(num % 10);
        if (neg) finalString.append("-");
        finalString.reverse();
        return finalString.toString();
    }

    /**
     * Source :  Element of Prgramming Interview - Strings
     * Alphabetical encoding of spreadsheets column id to integer ids.
     * Column Ids  - A,B,--,Z,AA, AB, --, AZ, -- ZZ, AAA, ---- ZZZ.
     * A - 1, B - 26
     * AA - 27, ZZ - 702
     *
     * @param col - column id in string
     * @return - column id in int
     */
    public static int columnId(String col) {
        int result = 0;
        for (int i = 0; i < col.length(); i++) {
            result = (result * 26) + (col.charAt(i) - 64) ;
        }
        return result;
    }

    /**
     * Source :  Element of Prgramming Interview - Strings
     * Given an char array, replace all occurance of 'a' with 'dd' and
     * remove all occurance of 'bb'
     * @param s
     * @param size
     * @return
     */
    public static int replaceAndRemove(char[] s, int size) {
        System.out.println("Array Length start : " + s.length);
        int wIdx = 0, aCount = 0;
        for (int i = 0; i< size; i++) {
             if (s[i] != 'b') {
                 s[wIdx++] = s[i];
             }
             if(s[i] == 'a') {
                 aCount++;
             }
        }

        int curIdx = wIdx - 1;
        wIdx = wIdx + aCount - 1;
        int finalSize = wIdx + 1;

        while(curIdx >= 0) {
            if(s[curIdx] == 'a') {
                s[wIdx--] = 'd';
                s[wIdx--] = 'd';
            } else  {
                s[wIdx--] = s[curIdx];
            }
            curIdx--;
        }
        System.out.println("Array Length end : " + s.length);
        return finalSize;
    }

    /**
     * Source :  Leetcode.
     *
     * Implement atoi which converts a string to an integer.
     *
     * The function first discards as many whitespace characters as necessary until the first non-whitespace
     * character is found. Then, starting from this character, takes an optional initial plus or minus sign followed
     * by as many numerical digits as possible, and interprets them as a numerical value.
     *
     * The string can contain additional characters after those that form the integral number, which are ignored and
     * have no effect on the behavior of this function.
     *
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
     * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     *
     * If no valid conversion could be performed, a zero value is returned.
     *
     * Note:
     *
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed
     * integer range: [−231,  231 − 1].
     * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or
     * INT_MIN (−231) is returned.
     * Example 1:
     *
     * Input: "42"
     * Output: 42
     * Example 2:
     *
     * Input: "   -42"
     * Output: -42
     * Explanation: The first non-whitespace character is '-', which is the minus sign.
     *              Then take as many numerical digits as possible, which gets 42.
     * Example 3:
     *
     * Input: "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     * Example 4:
     *
     * Input: "words and 987"
     * Output: 0
     * Explanation: The first non-whitespace character is 'w', which is not a numerical
     *              digit or a +/- sign. Therefore no valid conversion could be performed.
     * Example 5:
     *
     * Input: "-91283472332"
     * Output: -2147483648
     * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
     *              Thefore INT_MIN (−231) is returned.
     * @param str string to convert
     * @return integer.
     */
    public static int myAtoi(String str) {
        int len;
        double result = 0;
        boolean negative = false;
        boolean positive = false;
        int count = 0;

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }



        if (str.charAt(0) == '-') {
            negative = true;
        } else if(str.charAt(0) == '+') {
            positive = true;
        }

        StringBuffer strNum = new StringBuffer();
        len = str.length();
        for (int i = ((negative || positive) ? 1 : 0); i < len; i++) {
            int c = str.charAt(i) - 48;
            if (c < 0 || c > 9) {
                break;
            }
            strNum.append(c);
        }

        String numString = strNum.toString();
        System.out.println(numString);
        for(int i = 0; i < numString.length(); i++) {
            int c = numString.charAt(i) - '0';
            double power = Math.pow(10, numString.length() - (i+1));
            result = result + c * power ;
            if (result > Integer.MAX_VALUE) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

        }

        if (negative) {
            result = 0 - result;
        }
        return (int)result;
    }
    /**
     * Source :  Leetcode.
     *
     * Given a string, find the length of the longest substring without repeating characters.
     *
     *      Example 1:
     *
     *      Input: "abcabcbb"
     *      Output: 3
     *      Explanation: The answer is "abc", with the length of 3.
     *      Example 2:
     *
     *      Input: "bbbbb"
     *      Output: 1
     *      Explanation: The answer is "b", with the length of 1.
     *      Example 3:
     *
     *      Input: "pwwkew"
     *      Output: 3
     *      Explanation: The answer is "wke", with the length of 3.
     *      Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *      https://leetcode.com/articles/longest-substring-without-repeating-characters/
     */
    public static int longestNonRepSubStringLength(String s) {
        /**
         * brute force. T = O(N^3), O(min(n,m)).
         *
         *
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (allUnique(s, i, j)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
         */
        /**
         * Sliding Window.
         * The naive approach is very straightforward. But it is too slow. So how can we optimize it?
         *
         * In the naive approaches, we repeatedly check a substring to see if it has duplicate character.
         * But it is unnecessary. If a substring s_{ij}sij from index ii to j - 1j−1 is already checked to have no
         * duplicate characters. We only need to check if s[j]s[j] is already in the substring s_{ij}sij.
         *
         * To check if a character is already in the substring, we can scan the substring, which leads to an O(n^2)O(n
         * 2) algorithm. But we can do better.
         *
         * By using HashSet as a sliding window, checking if a character in the current can be done in O(1)O(1).
         *
         * A sliding window is an abstract concept commonly used in array/string problems.
         * A window is a range of elements in the array/string which usually defined by the start and end indices,
         * i.e. [i, j)[i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the
         * certain direction. For example, if we slide [i, j)[i,j) to the right by 11 element,
         * then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).
         *
         * Back to our problem. We use HashSet to store the characters
         * in current window [i, j)[i,j) (j = ij=i initially). Then we slide the index jj to the right.
         * If it is not in the HashSet, we slide jj further. Doing so until s[j] is already in the HashSet.
         * At this point, we found the maximum size of substrings without duplicate characters start with index ii.
         * If we do this for all ii, we get our answer.
          */

        int len = s.length();
        int max = 0, i = 0, j = 0;
        Set<Character> s1 = new HashSet<>();
        while(i < len && j < len) {
            if (!s1.contains(s.charAt(j))) {
                s1.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                s1.remove(s.charAt(i++));
            }
        }
        return max;
    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void extractString(String s) {
        /*
        System.out.println(s.indexOf('n'));
        System.out.println(s.indexOf('v'));
        System.out.println(s.indexOf('t'));
        System.out.println(s.indexOf("vt"));
        System.out.println("lastIndex of t : " + s.lastIndexOf('t'));
        */

        //Extract version
        /*
        System.out.println(s.lastIndexOf('_'));
        String version;
        if (s.lastIndexOf('_') != -1) {
            version = s.substring(s.lastIndexOf('_') + 1, s.indexOf(".py.base64"));
        } else {
            version = null;
        }

        //s = s.substring(0, s.indexOf(".vm"));

        System.out.println(version);
        */
        //Extract Name
        String solution;
        if (s.lastIndexOf("_solcfg_v1.0.0")!= 1) {
            solution = s.substring(0,s.lastIndexOf("_solcfg_v1.0.0"));
        } else {
            solution = null;
        }
        System.out.println(solution);
    }

    public static void stringCompare(String s) {
        if (!CommonUtils.matchesRegex(s, "(0|[1-9][0-9]*).(0|[1-9][0-9]*).(0|[1-9][0-9]*)")) {
            System.out.println("pattern not correct");
            return;
        }
        String parent = "1.0.5";
        String parentAppVersion = null;
        String currentAppVersion = null;
        int iend = s.indexOf(".");
        if (iend != -1) {
            currentAppVersion = s.substring(0, iend);
        }

        iend = parent.indexOf(".");
        if (iend != -1) {
            parentAppVersion = parent.substring(0, iend);
        }

        System.out.println("currentAppVersion : "+ currentAppVersion+ " parentAppVersion : " + parentAppVersion);
        if (currentAppVersion != null && parentAppVersion != null) {
            if (currentAppVersion.compareTo(parentAppVersion) <= 0) {
                System.out.println("version supported");
            } else {
                System.out.println("version not supported");
            }
        } else {
            System.out.println("version not available");
        }
    }

}
