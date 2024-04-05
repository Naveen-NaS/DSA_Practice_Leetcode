// Problem No : 2485 "Find the Pivot Integer"

/* Aim :- Given a positive integer n, find the pivot integer x such that:

    The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
    Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most 
    one pivot index for the given input. 
*/

public class Day_41 {

    public static int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }

        int totalSum = sum(n);
        for (int pivot = 1; pivot < n; pivot++) {
            int leftSum = sum(pivot - 1);
            int rightSum = totalSum - leftSum - pivot;
            if (leftSum == rightSum) {
                return pivot;
            }
        }

        return -1;
    }

    public static int sum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }
}
