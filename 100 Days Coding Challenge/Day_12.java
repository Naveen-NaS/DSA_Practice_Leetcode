// Problem No : 2108 "Find First Palindromic String in the Array"

/* Aim :- Given an array of strings words, return the first palindromic string in the array. 
    If there is no such string, return an empty string "".
    A string is palindromic if it reads the same forward and backward. 
*/

import java.util.*;

public class Day_12 {
    public static long largestPerimeter(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += nums[i];
        }

        for (int i = len - 1; i >= 2; i--) {
            if (sum > nums[i]) {
                return sum + nums[i];
            } else {
                sum -= nums[i - 1];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(largestPerimeter(nums));
    }
}
