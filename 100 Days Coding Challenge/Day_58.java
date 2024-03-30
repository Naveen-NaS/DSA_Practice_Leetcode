// Problem No : 992 "Subarrays with K Different Integers"

/* Aim :- Given an integer array nums and an integer k, return the number of good subarrays of nums.

    Good array is an array where the number of different integers in that array is exactly k.
        For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
        
    A subarray is a contiguous part of an array. */

import java.util.HashMap;
import java.util.Map;

public class Day_58 {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums, k) - atmostK(nums, k - 1);
    }

    public static int atmostK(int[] nums, int k) {
        int start = 0, ans = 0, len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < len; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (map.size() > k) {
                if (map.get(nums[start]) > 1) {
                    map.put(nums[start], map.get(nums[start]) - 1);
                } else {
                    map.remove(nums[start]);
                }
                start++;
            }
            ans += (end - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
