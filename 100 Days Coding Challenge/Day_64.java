// Problem No : 1544 "Make The String Great"

/* Aim :- Given a string s of lower and upper case English letters.

    A good string is a string which doesn't have two adjacent characters
    s[i] and s[i + 1] where:
    
        0 <= i <= s.length - 2
        s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
    To make the string good, you can choose two adjacent characters that make the string bad and remove them. 
    You can keep doing this until the string becomes good.
    
    Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
    
    Notice that an empty string is also good. 
*/

public class Day_64 {

    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(i + 1);
            if (Math.abs(ch1 - ch2) == 32) {
                sb.delete(i, i + 2);
                i = Math.max(-1, i - 2);
            }
        }

        if (sb.length() == 2) {
            char ch1 = sb.charAt(0);
            char ch2 = sb.charAt(1);
            if (Math.abs(ch1 - ch2) == 32) {
                return "";
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }
}
