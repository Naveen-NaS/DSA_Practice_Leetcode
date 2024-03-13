// Problem No : 279 "Perfect Squares"

/* Aim :- Given an integer n, return the least number of perfect square numbers that sum to n.
    A perfect square is an integer that is the square of an integer; in other words, 
    it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares 
    while 3 and 11 are not. 
*/

public class Day_07 {

    public static int numSquares(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int rem = i - j * j;
                if (dp[rem] < min) {
                    min = dp[rem];
                }
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
