// Problem No : 2958 "Length of Longest Subarray With at Most K Frequency"

/* Aim :- You are given an integer array nums and an integer k.

    The frequency of an element x is the number of times it occurs in an array.
    
    An array is called good if the frequency of each element in this array is less than or equal to k.
    
    Return the length of the longest good subarray of nums.
    
    A subarray is a contiguous non-empty sequence of elements within an array. 
*/

import java.util.*;

public class Day_56 {

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length, maxlen = 0, l = 0;
        int invalidCount = 0;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > k) {
                invalidCount++;
            }

            while (invalidCount > 0) {
                int leftNum = nums[l];
                map.put(leftNum, map.get(leftNum) - 1);
                if (map.get(leftNum) == k) {
                    invalidCount--;
                }
                l++;
            }

            maxlen = Math.max(maxlen, i - l + 1);
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 2, 3, 1, 2 };
        int k = 2;
        System.out.println("Output: " + maxSubarrayLength(nums, k));
    }
}
