// Problem No : 84 "Largest Rectangle in Histogram"

/* Aim :- Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
return the area of the largest rectangle in the histogram. 
*/

public class Day_72_a {

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0 || heights == null) {
            return 0;
        }

        int len = heights.length;
        int[] prevSmallerElement = new int[len];
        int[] nextSmallerElement = new int[len];

        prevSmallerElement[0] = -1;
        nextSmallerElement[len - 1] = len;

        for (int i = 1; i < len; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = prevSmallerElement[p];
            }
            prevSmallerElement[i] = p;
        }

        for (int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < len && heights[p] >= heights[i]) {
                p = nextSmallerElement[p];
            }
            nextSmallerElement[i] = p;
        }

        int maxArea = 0;

        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nextSmallerElement[i] - prevSmallerElement[i] - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }
}