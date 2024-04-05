// Problem No : 1614 "Maximum Nesting Depth of the Parentheses"

/* Aim :- A string is a valid parentheses string (denoted VPS) if it meets one of the following:
        It is an empty string "", or a single character not equal to "(" or ")",
        It can be written as AB (A concatenated with B), where A and B are VPS's, or
        It can be written as (A), where A is a VPS.
        We can similarly define the nesting depth depth(S) of any VPS S as follows:
        
            depth("") = 0
            depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
            depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
            depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
            
        For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
        
    Given a VPS represented as string s, return the nesting depth of s. 
*/

public class Day_63 {

    public static int maxDepth(String s) {
        int maxDepth = 0, currDepth = 0, len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                currDepth++;
                maxDepth = Math.max(maxDepth, currDepth);
            } else if (s.charAt(i) == ')') {
                currDepth--;
                if (currDepth < 0) {
                    return 0;
                }
            }
        }

        return currDepth == 0 ? maxDepth : 0;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
}
