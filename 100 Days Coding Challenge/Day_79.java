// Problem No : 1992 "Find All Groups of Farmland"

/* Aim :- You are given a 0-indexed m x n binary matrix land where a 0 represents
    a hectare of forested land and a 1 represents a hectare of farmland.
    
    To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. 
    These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not 
    four-directionally adjacent to another farmland in a different group.


    land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of
    land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland.
    A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].
    
    Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. 
    You may return the answer in any order. 
*/

import java.util.*;

public class Day_79 {

    public static int[][] findFarmland(int[][] land) {
        int rows = land.length, cols = land[0].length;
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1) {
                    int[] group = findFarmlandGroup(land, i, j);
                    ans.add(group);
                }
            }
        }

        int[][] ansArray = new int[ans.size()][4];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }

        return ansArray;
    }

    public static int[] findFarmlandGroup(int[][] land, int startX, int startY) {
        int[] group = new int[4];
        int endX = startX;
        int endY = startY;

        while (endX < land.length && land[endX][startY] == 1) {
            endX++;
        }
        while (endY < land[0].length && land[startX][endY] == 1) {
            endY++;
        }

        group[0] = startX;
        group[1] = startY;
        group[2] = endX - 1;
        group[3] = endY - 1;

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                land[i][j] = 0;
            }
        }

        return group;
    }

    public static void main(String[] args) {

    }
}
