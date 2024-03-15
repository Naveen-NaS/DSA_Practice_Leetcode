// Problem No : 238 "Product of Array Except Self"

/* Aim : Given an integer array nums, return an array answer such that answer[i] 
    is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation. 
*/

public class Day_43 {

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int product = 1;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * product;
            product = product * nums[i];
        }
        return ans;
    }

    public static void printArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                System.out.println(arr[i] + "]");
                break;
            }
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        printArray(productExceptSelf(nums));
    }
}
