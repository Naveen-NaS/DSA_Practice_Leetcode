// Problem No : 647 "Palindromic Substrings"

/* Aim :- Given a string s, return the number of palindromic substrings in it.
    A string is a palindrome when it reads the same backward as forward.
    A substring is a contiguous sequence of characters within the string. 
*/

public class Day_09 {

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += countPalindromes(s, i, i); // Odd length palindromes
            count += countPalindromes(s, i, i + 1); // Even length palindromes
        }

        return count;
    }

    public static int countPalindromes(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(countSubstrings(s));
    }
}
