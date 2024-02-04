import java.util.HashMap;
import java.util.Map;

public class Problem_76_Feb04 {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        int i = 0;
        int j = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (Character.isLetter(c)) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        while (j < s.length()) {
            char charJ = s.charAt(j);
            if (charMap.containsKey(charJ)) {
                if (charMap.get(charJ) > 0) {
                    count--;
                }
                charMap.put(charJ, charMap.get(charJ) - 1);
            }
            j++;

            while (count == 0) {
                if (j - i < minLen) {
                    minLen = j - i;
                    ans = s.substring(i, j);
                }

                char charI = s.charAt(i);
                if (charMap.containsKey(charI)) {
                    charMap.put(charI, charMap.get(charI) + 1);
                    if (charMap.get(charI) > 0) {
                        count++;
                    }
                }
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));

    }
}