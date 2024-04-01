// Problem No : 58 "Length of Last Word"

/* Aim :- Given a string s consisting of words and spaces, 
    return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only. 
*/

public class Day_60 {

    public static int lengthOfLastWord(String s) {
        int count = 0;
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(s.length() - 1 - j) == ' ') {
                j++;
                continue;
            } else {
                if (s.charAt(i) != ' ') {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}
