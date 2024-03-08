import java.util.*;

public class Day_36 {

    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for (int frequency : frequencyMap.values()) {
            maxFreq = Math.max(maxFreq, frequency);
        }

        int sum = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency == maxFreq) {
                sum += frequency;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 4, 1, 2, 1, 3, 1, 2, 3, 2, 2, 3, 6, 3, 8 };
        System.out.println(maxFrequencyElements(arr));
    }
}
