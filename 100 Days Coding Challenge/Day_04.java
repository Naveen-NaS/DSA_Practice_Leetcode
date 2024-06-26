// Problem No : 387 "First Unique Character in a String"

/* Aim :- Given a string s, find the first non-repeating character in it and return its index.
    If it does not exist, return -1. 
*/

public class Day_04 {

    public static int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                ans = Math.min(ans, index);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        String s = "naveensharmaji";
        System.out.println(firstUniqChar(s));
    }
}

// or
/*
 * public class Day_05 {
 * 
 * public static int firstUniqChar(String s) {
 * Map<Character, Integer> charMap = new HashMap<>();
 * for (char c : s.toCharArray()) {
 * if (Character.isLetter(c)) {
 * charMap.put(c, charMap.getOrDefault(c, 0) + 1);
 * }
 * }
 * int index = -1;
 * for(int i = 0; i < s.length(); i++) {
 * char ithChar = s.charAt(i);
 * if(charMap.get(ithChar) == 1) {
 * index = i;
 * break;
 * }
 * }
 * return index;
 * }
 * 
 * public static void main(String[] args) {
 * String s = "naveensharma";
 * System.out.println(firstUniqChar(s));
 * }
 * }
 */