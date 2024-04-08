// Problem No : "678 Valid Parenthesis String"

/* Aim :- */

public class Day_66 {

    public static boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0, len = s.length();
        char ch = 'a';

        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen--;
                if (maxOpen < 0)
                    return false;
            } else {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen++;
            }
        }

        return minOpen == 0;
    }

    public static void main(String[] args) {
        String s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
        System.out.println(checkValidString(s));
    }
}
