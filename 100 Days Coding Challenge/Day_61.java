// Problem No : "205 Isomorphic Strings"

/* Aim :- Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. 
    No two characters may map to the same character, but a character may map to itself. 
*/

import java.util.*;

public class Day_61 {

    public static boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (map.containsKey(charS)) {
                if (map.get(charS) != charT)
                    return false;
            } else {
                if (reverseMap.containsKey(charT) && reverseMap.get(charT) != charS)
                    return false;
                map.put(charS, charT);
                reverseMap.put(charT, charS);
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
