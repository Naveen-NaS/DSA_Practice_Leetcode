// Problem No : 169 "Majority Element"

/* Aim :- Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times.
    You may assume that the majority element always exists in the array. 
*/

import java.util.*;

public class Day_11 {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> intMap = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            intMap.put(nums[i], intMap.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
            if (entry.getValue() > len / 2) {
                ans = entry.getKey();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2, 3 };
        System.out.println(majorityElement(nums));
    }
}
