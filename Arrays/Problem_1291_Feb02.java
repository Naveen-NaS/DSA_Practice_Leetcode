/* Aim : An integer has sequential digits if and only if each digit in the number 
        is one more than the previous digit.
    Return a sorted list of all the integers in the range [low, high] inclusive 
        that have sequential digits.
 */

import java.util.ArrayList;
import java.util.List;

public class Problem_1291_Feb02 {

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for (int digit = 1; digit <= 9; digit++) {
            int current = digit;
            int next = current + 1;

            while (next <= 9 && current <= high) {
                current = current * 10 + next;

                if (current >= low && current <= high) {
                    ans.add(current);
                }

                next++;
            }
        }

        ans.sort(null);

        return ans;
    }

    public static void main(String[] args) {
        int low = 1000, high = 13000;
        System.out.println(sequentialDigits(low, high));
    }
}