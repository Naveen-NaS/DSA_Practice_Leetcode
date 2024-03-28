// Problem No : 49 "Group Anagrams"

/* Aim :- Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, t
    ypically using all the original letters exactly once. 
*/

import java.util.*;

public class Day_05 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        int len = strs.length;

        for (int i = 0; i < len; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!strMap.containsKey(sortedStr)) {
                strMap.put(sortedStr, new ArrayList<>());
            }

            strMap.get(sortedStr).add(strs[i]);
        }

        return new ArrayList<>(strMap.values());
    }

    public static void main(String[] args) {
        String[] strings = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strings));
    }
}
