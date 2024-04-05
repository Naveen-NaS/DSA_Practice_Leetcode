// Problem No : 525 "Contiguous Array"

/* Aim :- Given a binary array nums, return the maximum length
    of a contiguous subarray with an equal number of 0 and 1.
*/

public class Day_44 {

    public static int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] sumIndex = new int[2 * len + 1];
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < sumIndex.length; i++) {
            sumIndex[i] = -1;
        }

        sumIndex[len] = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            int index = sum + len;
            if (sumIndex[index] != -1) {
                maxLen = Math.max(maxLen, i - sumIndex[index] + 1);
            } else {
                sumIndex[index] = i + 1;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 1 };
        System.out.println(findMaxLength(nums));
    }
}
