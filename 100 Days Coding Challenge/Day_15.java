// Problem No : 1481 "Least Number of Unique Integers after K Removals"

/* Aim :- Given an array of integers arr and an integer k. 
    Find the least number of unique integers after removing exactly k elements. 
*/

import java.util.*;

public class Day_15 {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        int len = arr.length;
        Map<Integer, Integer> intMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            intMap.put(arr[i], intMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> nums = new ArrayList<>(intMap.values());

        Collections.sort(nums);

        int uniqueIntegers = intMap.size();
        int removed = 0;

        for (int frequency : nums) {
            if (removed + frequency <= k) {
                uniqueIntegers--;
                removed += frequency;
            } else {
                break;
            }
        }

        return uniqueIntegers;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 2, 3, 3, 2 };
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }
}
