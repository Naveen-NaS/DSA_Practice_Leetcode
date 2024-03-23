// Problem No : 201 "Bitwise AND of Numbers Range"

/* Aim :- Given two integers left and right that represent the range [left, right], 
    return the bitwise AND of all numbers in this range, inclusive.
*/

public class Day_20 {

    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }

    public static void main(String[] args) {
        int left = 1, right = 2147483647;
        System.out.println(rangeBitwiseAnd(left, right));
    }
}
