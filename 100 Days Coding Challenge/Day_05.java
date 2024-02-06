import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }
}
