// Problem No : 42. Trapping Rain Water

/* Aim :- Given n non-negative integers representing an elevation map where the width of each bar is 1, 
    compute how much water it can trap after raining. 
*/

public class Day_71 {
    public static int trap(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trapWater = 0;
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trapWater += waterLevel - height[i];
        }

        return trapWater;

    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }
}