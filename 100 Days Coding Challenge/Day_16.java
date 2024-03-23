// Problem No : 1642 "Furthest Building You Can Reach"

/* Aim :- You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
    You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
    While moving from building i to building i+1 (0-indexed),

    If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
    If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
    Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally. 
*/

public class Day_16 {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        int ans = -1;
        for (int i = 0; i < len - 1; i++) {
            if (heights[i] < heights[i + 1]) {
                if (bricks >= heights[i]) {
                    bricks -= heights[i];
                    ans = i;
                } else {
                    if (ladders > 0) {
                        ladders--;
                        ans = i;
                    } else {
                        ans = i;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights = { 4, 12, 2, 7, 3, 18, 20, 3, 19 };
        System.out.println(furthestBuilding(heights, 10, 2));
    }
}
