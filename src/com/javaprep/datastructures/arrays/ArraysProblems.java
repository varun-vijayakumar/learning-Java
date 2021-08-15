package com.javaprep.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class ArraysProblems {

    public static void reverseArray(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len < 1 || len > 2 * (10000) || k < 0) {
            return;
        }

        /*
        //1. Brute Force - T = 0(N^2) S = O(1)
        while(k > 0) {
            for (int i = len-1; i > 0; i--) {
                CommonUtils.swapArrayElements(nums, i , i -1);
            }
            k--;
        }
        */

        /*
        //2. Using auxillary array - T = 0(N) S = O(N)
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
        */


        /*
        // 3. Using Cyclic Replacements , T = O(N), S = 0(1).
        // Refer - https://leetcode.com/problems/rotate-array/solution/ for explanation.
        int count = 0;

        for (int start = 0; count < len; start++) {
            int current = start;
            int prev = nums[current];

            do {
                int next = (current + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
        */

        // 4. Using Reverse Array Technique, T = O(N), S = O(1)
        k = k % len; // if k > len , eg : k = 5, len = 1;
        reverseArray(nums, 0, len-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, len-1);

    }

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap ();
        int i = 0;
        int[] indexes = new int[2];
        /*
        // 2 pass method

        for(i = 0; i < nums.length; i++) {
            map.put(target-nums[i], i);
        }
        Integer val = null;
        for (i = 0; i < nums.length; i++) {
            //if (map.containsKey(nums[i]) == true) {
                val = map.get(nums[i]);
                if (val != null && val != i) {
                    indexes[0] = i;
                    indexes[1] = val;
                    break;
                }
            //}
        }
        */
        //One pass
        Integer val = null;
        for (i = 0; i < nums.length; i++) {
            val = map.get(target-nums[i]);
            if (val != null) {
               indexes[0] = val;
               indexes[1] = i;
               break;
            }
            map.put(nums[i], i);
        }
        return indexes;
    }
}
