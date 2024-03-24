// Problem No : 287 "Find the Duplicate Number"

/* Aim :- Given an array of integers nums containing n + 1 integers 
    where each integer is in the range [1, n] inclusive.
    
    There is only one repeated number in nums, return this repeated number.
    
    You must solve the problem without modifying the array nums and uses only constant extra space. 
*/

public class Day_52 {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate(nums));
    }
}
