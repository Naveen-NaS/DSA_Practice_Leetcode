// Problem No : 57 "Insert Interval"

/* Aim :- You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
    represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
    still does not have any overlapping intervals (merge overlapping intervals if necessary).
     
    Return intervals after the insertion.
    
    Note that you don't need to modify intervals in-place.You can make a new array and return it.
*/

import java.util.*;

public class Day_45 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        boolean isInserted = false;
        List<int[]> finalList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (isInserted || intervals[i][1] < newInterval[0]) {
                finalList.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                finalList.add(newInterval);
                finalList.add(intervals[i]);
                isInserted = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        if (!isInserted) {
            finalList.add(newInterval);
        }

        return finalList.toArray(new int[finalList.size()][2]);
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };

        print2DArray(insert(intervals, newInterval));
    }
}
