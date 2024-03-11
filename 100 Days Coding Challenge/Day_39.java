import java.util.*;

public class Day_39 {

    public static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (char c : order.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                int count = frequencyMap.get(c);
                while (count-- > 0) {
                    sb.append(c);
                }
                frequencyMap.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String order = "acdb";
        String s = "badcgfac";
        System.out.println(customSortString(order, s));
    }
}
