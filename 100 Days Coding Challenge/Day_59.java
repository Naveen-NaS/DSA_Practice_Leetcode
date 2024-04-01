// Problem No : 2444 "Count Subarrays With Fixed Bounds"

/* Aim :- You are given an integer array nums and two integers minK and maxK.

    A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
        The minimum value in the subarray is equal to minK.
        The maximum value in the subarray is equal to maxK.
    Return the number of fixed-bound subarrays.
    
    A subarray is a contiguous part of an array. 
*/

public class Day_59 {

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int badI = -1, minI = -1, maxI = -1, len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                badI = i;
            }
            if (nums[i] == minK) {
                minI = i;
            }
            if (nums[i] == maxK) {
                maxI = i;
            }
            ans += Math.max(0, Math.min(minI, maxI) - badI);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1 };
        int minK = 1, maxK = 1;
        System.out.println(countSubarrays(nums, minK, maxK));
    }
}
