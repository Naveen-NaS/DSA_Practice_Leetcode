public class Problem_931_Jan19 {

    public static int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int minPath = 0;
        int minCol = matrix[0][0];
        int min = 0;

        for (int i = 0; i < len; i++) {
            if (matrix[0][i] < minCol) {
                minCol = matrix[0][i];
                min = i;
            }
        }

        minPath = matrix[0][min];

        for (int row = 1; row < len; row++) {
            int minVal;
            if (min == 0) {
                minVal = Math.min(matrix[row][min], matrix[row][min + 1]);
                if (minVal == matrix[row][min]) {
                } else {
                    min = min + 1;
                }
            } else if (min == len - 1) {
                minVal = Math.min(matrix[row][min], matrix[row][min - 1]);
                if (minVal == matrix[row][min]) {
                } else {
                    min = min - 1;
                }
            } else {
                minVal = Math.min(matrix[row][min], Math.min(matrix[row][min - 1], matrix[row][min + 1]));
                if (minVal == matrix[row][min]) {
                } else if (minVal == matrix[row][min - 1]) {
                    min = min - 1;
                } else {
                    min = min + 1;
                }
            }

            minPath += minVal;

            // if (minVal == matrix[row][col] && col != min) {
            // min = col;
            // }
        }

        return minPath;
    }

    public static void main(String[] args) {
        int[][] arr = { { 100, -42, -46, -41 }, { 31, 97, 10, -10 }, { -58, -51, 82, 89 }, { 51, 81, 69, -51 } };

        System.out.println(minFallingPathSum(arr));
    }
}
