import java.util.*;

public class Problem_451_Feb07 {

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
        String s = "eersteewrt333424";
        System.out.println(frequencySort(s));
    }
}
