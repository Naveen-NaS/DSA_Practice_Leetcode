// Problem No : 1463 "Cherry Pickup II"

/* Aim :- You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] 
    represents the number of cherries that you can collect from the (i, j) cell.
    You have two robots that can collect cherries for you:
        Robot #1 is located at the top-left corner (0, 0), and
        Robot #2 is located at the top-right corner (0, cols - 1).
    Return the maximum number of cherries collection using both robots by following the rules below:
        From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
        When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
        When both robots stay in the same cell, only one takes the cherries.
        Both robots cannot move outside of the grid at any moment.
        Both robots should reach the bottom row in grid. 
*/

public class Day_10 {

    static int[][][] memo;

    public static int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        memo = new int[rows][cols][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return helper(grid, 0, 0, cols - 1);
    }

    private static int helper(int[][] grid, int row, int col1, int col2) {
        if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }
        if (memo[row][col1][col2] != -1) {
            return memo[row][col1][col2];
        }
        int count = 0;
        count += grid[row][col1];
        if (col1 != col2) {
            count += grid[row][col2];
        }
        if (row != grid.length - 1) {
            int max = 0;
            for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                    max = Math.max(max, helper(grid, row + 1, newCol1, newCol2));
                }
            }
            count += max;
        }
        return memo[row][col1][col2] = count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 1, 1 }, { 2, 5, 3 }, { 1, 5, 5 }, { 2, 1, 1 } };
        System.out.println(cherryPickup(grid));
    }
}
