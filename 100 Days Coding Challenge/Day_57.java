// Problem No : 2962 "Count Subarrays Where Max Element Appears at Least K Times"

/* Aim :- You are given an integer array nums and a positive integer k.

    Return the number of subarrays where the maximum element of nums appears
    at least k times in that subarray.
    
    A subarray is a contiguous sequence of elements within an array. 
*/

public class Day_57 {

    public static long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        long ans = 0;
        int count = 0, start = 0;
        for (int i = 0; i < len; i++) {
            while (start < len && count < k) {
                count += nums[start] == max ? 1 : 0;
                start++;
            }
            if (count < k) {
                break;
            }
            ans += len - start + 1;
            count -= nums[i] == max ? 1 : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 2, 1 };
        int k = 3;
        System.out.println(countSubarrays(nums, k));
    }
}