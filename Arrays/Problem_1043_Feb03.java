/* Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. 
   After partitioning, each subarray has their values changed to become the maximum value of that subarray.
   Return the largest sum of the given array after partitioning. 
   Test cases are generated so that the answer fits in a 32-bit integer. 
*/

import java.util.Arrays;

public class Problem_1043_Feb03 {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return recursive(0, arr, k, dp);
    }

    public static int recursive(int index, int[] arr, int k, int dp[]) {
        int n = arr.length;

        // Base Case
        if (index == n) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int len = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        // Recursive Case
        for (int i = 0; i < k && (index + i) < n; i++) {
            len++;
            max = Math.max(max, arr[index + i]);
            int sum = max * len + recursive(index + i + 1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[index] = maxSum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
        int k = 4;
        System.out.println(maxSumAfterPartitioning(nums, k));
    }
}
