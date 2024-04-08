// Problem No : "678 Valid Parenthesis String"

/* Aim :- Given a string s containing only three types of characters: '(', ')' and '*',
    return true if s is valid.
    
    The following rules define a valid string:

        Any left parenthesis '(' must have a corresponding right parenthesis ')'.
        Any right parenthesis ')' must have a corresponding left parenthesis '('.
        Left parenthesis '(' must go before the corresponding right parenthesis ')'.
        '*' could be treated as a single right parenthesis ')' or a single left parenthesis
        '(' or an empty string "".
*/

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
