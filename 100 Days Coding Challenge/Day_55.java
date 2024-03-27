// Problem No : 713 "Subarray Product Less Than K"

/* Aim :- Given an array of integers nums and an integer k, 
    return the number of contiguous subarrays where the product of all the elements
    in the subarray is strictly less than k. 
*/

public class Day_55 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int count = 0, product = 1, left = 0, len = nums.length;

        for (int right = 0; right < len; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
