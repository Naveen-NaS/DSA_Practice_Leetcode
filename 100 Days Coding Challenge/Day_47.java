// Problem No : 621 "Task Scheduler"

/* Aim :- You are given an array of CPU tasks, each represented by letters A to Z, 
    and a cooling time, n. Each cycle or interval allows the completion of one task. 
    Tasks can be completed in any order, but there's a constraint: 
        identical tasks must be separated by at least n intervals due to cooling time.
    Return the minimum number of intervals required to complete all tasks. 
*/

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
        char[] tasks = { 'A', 'A', 'A', 'c', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
