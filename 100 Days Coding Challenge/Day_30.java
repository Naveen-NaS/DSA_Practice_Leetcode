public class Day_30 {

    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int[] result = new int[len];
        int i = len - 1, sq = 0;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                sq = nums[left];
                left++;
            } else {
                sq = nums[right];
                right--;
            }
            result[i--] = sq * sq;
        }
        return result;
    }

    public static void printArr(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] arr = { -1, -2, 0, 5, 4, -8, 7, 9, 12 };
        printArr(sortedSquares(arr));
    }
}