// Problem No : 79 "Word Search"

/* Aim :- Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    he word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
    or vertically neighboring. The same letter cell may not be used more than once. 
*/

public class Day_62 {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0, visited))
                    return true;
            }
        }

        return false;
    }

    private static boolean search(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length())
            return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]
                || board[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        boolean found = search(board, word, row + 1, col, index + 1, visited)
                || search(board, word, row - 1, col, index + 1, visited)
                || search(board, word, row, col + 1, index + 1, visited)
                || search(board, word, row, col - 1, index + 1, visited);

        visited[row][col] = false;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }
}
