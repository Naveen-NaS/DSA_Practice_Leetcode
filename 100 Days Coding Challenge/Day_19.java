// Problem No : 268 "Missing Number"

/* Aim :- Given an array nums containing n distinct numbers in the range [0, n], 
    return the only number in the range that is missing from the array. 
*/

public class Day_19 {

    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int naturalSum = len * (len + 1) / 2;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        return naturalSum - sum;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 6, 4, 2, 5, 7, 0, 1 };
        System.out.println(missingNumber(nums));
    }
}
