// Problem No : 85 "Maximal Rectangle"

/* Aim :- Given a rows x cols binary matrix filled with 0's and 1's, 
    find the largest rectangle containing only 1's and return its area. 
*/

import java.util.*;

public class Day_72_b {

    public static int maximalRectangle(char[][] matrix) {
        int maxAns = Integer.MIN_VALUE, rowLen = matrix.length, colLen = matrix[0].length;

        int[] histogram = new int[colLen];
        Arrays.fill(histogram, 0);

        for (int i = 0; i < rowLen; i++) {
            // To create Histogram array
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j]++;
                } else {
                    histogram[j] = 0;
                }
            }

            maxAns = Math.max(maxAns, largestRectangleArea(histogram));
        }

        return maxAns;
    }

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
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle(matrix));
    }
}
