// Problem No : 2971 :"Find Polygon With the Largest Perimeter"

/* Aim :- You are given an array of positive integers nums of length n.
    A polygon is a closed plane figure that has at least 3 sides. 
    The longest side of a polygon is smaller than the sum of its other sides.
    Conversely, if you have k (k >= 3) positive real numbers a1, a2, a3, ..., ak where 
    a1 <= a2 <= a3 <= ... <= ak and a1 + a2 + a3 + ... + ak-1 > ak, 
    then there always exists a polygon with k sides whose lengths are a1, a2, a3, ..., ak.
    
    The perimeter of a polygon is the sum of lengths of its sides.
    Return the largest possible perimeter of a polygon whose sides can be formed from nums, 
    or -1 if it is not possible to create a polygon. 
*/

import java.util.Arrays;

public class Day_14 {

    public static long largestPerimeter(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += nums[i];
        }

        for (int i = len - 1; i >= 2; i--) {
            if (sum > nums[i]) {
                return sum + nums[i];
            } else {
                sum -= nums[i - 1];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 12, 1, 2, 5, 50, 3, 5 };
        System.out.println(largestPerimeter(nums));
    }
}
