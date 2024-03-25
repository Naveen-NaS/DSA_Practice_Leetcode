// Problem No : 442 "Find All Duplicates in an Array"

/* Aim :- Given an integer array nums of length n where all the integers of nums are in the range [1, n] 
    and each integer appears once or twice, return an array of all the integers that appears twice.
    
    You must write an algorithm that runs in O(n) time and uses only constant extra space. 
*/

import java.util.*;

public class Day_53 {

    public static List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < len; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
