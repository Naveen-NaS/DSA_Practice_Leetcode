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
