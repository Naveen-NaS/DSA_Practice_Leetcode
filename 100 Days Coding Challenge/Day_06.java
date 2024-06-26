// Problem No : 451 "Sort Characters By Frequency"

/* Aim :- Given a string s, sort it in decreasing order based on the frequency of the characters. 
    The frequency of a character is the number of times it appears in the string.
    Return the sorted string. If there are multiple answers, return any of them. 
*/

import java.util.*;

public class Day_06 {

    public static String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int slen = s.length();
        for (int i = 0; i < slen; i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(charMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int len = list.size();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {
            Map.Entry<Character, Integer> entry = list.get(i);
            char ch = entry.getKey();
            int count = entry.getValue();
            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "eersteewrt334424";
        System.out.println(frequencySort(s));
    }
}