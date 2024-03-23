// Problem No : 2011 "Final Value of Variable After Performing Operations"

/* Aim :- There is a programming language with only four operations and one variable X:
        ++X and X++ increments the value of the variable X by 1.
        --X and X-- decrements the value of the variable X by 1.
        Initially, the value of X is 0.
    Given an array of strings operations containing a list of operations, 
    return the final value of X after performing all the operations. 
*/

public class Day_23_b {

    static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        int len = operations.length;
        for (int i = 0; i < len; i++) {
            if (operations[i].charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        String[] operations = { "X++", "++X", "--X", "X--" };
        System.out.println(finalValueAfterOperations(operations));
    }
}
