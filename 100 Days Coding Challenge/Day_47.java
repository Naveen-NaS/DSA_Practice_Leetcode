import java.util.*;

public class Day_47 {

    public static int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (tasks == null || len == 0) {
            return 0;
        }

        int[] frequency = new int[26];
        for (int i = 0; i < len; i++) {
            frequency[tasks[i] - 'A']++;
        }

        Arrays.sort(frequency);
        int maxFrequency = frequency[25];

        int idleIntervals = (maxFrequency - 1) * n;

        for (int i = 24; i >= 0 && frequency[i] > 0; i--) {
            idleIntervals -= Math.min(frequency[i], maxFrequency - 1);
        }

        idleIntervals = Math.max(0, idleIntervals);

        return len + idleIntervals;
    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
