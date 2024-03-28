// Problem No : 368 "Largest Divisible Subset"

/* Aim :- Given a set of distinct positive integers nums, return the largest subset answer such that 
    every pair (answer[i], answer[j]) of elements in this subset satisfies:
        answer[i] % answer[j] == 0, or
        answer[j] % answer[i] == 0
    If there are multiple solutions, return any of them. 
*/

import java.util.*;

public class Day_08 {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxIndex = 0;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j]) == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int size = maxSize;
        int index = maxIndex;
        int lastValue = nums[index];

        for (int i = maxIndex; i >= 0; i--) {
            if (size == dp[i] && lastValue % nums[i] == 0) {
                ans.add(nums[i]);
                size--;
                lastValue = nums[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 2, 7, 9, 6, 3, 4, 5 };
        System.out.println(largestDivisibleSubset(nums));
    }
}
