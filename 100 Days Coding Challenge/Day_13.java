// Problem No : 2149 "Rearrange Array Elements by Sign"

/* Aim :- You are given a 0-indexed integer array nums of even length consisting of an 
    equal number of positive and negative integers.
    You should return the array of nums such that the the array follows the given conditions:
        1. Every consecutive pair of integers have opposite signs.
        2. For all integers with the same sign, the order in which they were present in nums is preserved.
        3. The rearranged array begins with a positive integer.
    Return the modified array after rearranging the elements to satisfy the aforementioned conditions. 
*/

public class Day_13 {

    public static int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }

    public static void printArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4, -1 };
        printArray(rearrangeArray(nums));
    }
}