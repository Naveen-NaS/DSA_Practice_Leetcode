// Problem No : 1249 "Minimum Remove to Make Valid Parentheses"

/* Aim :- Given a string s of '(' , ')' and lowercase English characters.

    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) 
    so that the resulting parentheses string is valid and return any valid string.
    
    Formally, a parentheses string is valid if and only if:
        It is the empty string, contains only lowercase characters, or
        It can be written as AB (A concatenated with B), where A and B are valid strings, or
        It can be written as (A), where A is a valid string. 
*/

import java.util.*;

public class Day_65 {

    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        minRemoveToMakeValid(s);
    }
}
