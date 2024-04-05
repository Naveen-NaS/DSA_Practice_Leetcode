// Problem No : 930 "Binary Subarrays With Sum"

/* Aim : Given a binary array nums and an integer goal, 
    return the number of non-empty subarrays with a sum goal.
    A subarray is a contiguous part of the array. 
*/

import java.util.*;

public class Day_42 {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            count += map.getOrDefault(sum - goal, 0);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1, 0 };
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
}
