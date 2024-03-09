public class Day_37 {

    public static int getCommon(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int one = 0, two = 0;

        while (one < len1 && two < len2) {
            if (nums1[one] == nums2[two]) {
                return nums1[one];
            } else if (nums1[one] < nums2[two]) {
                one++;
            } else {
                two++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 7 }, nums2 = { 2, 3, 4, 5 };
        System.out.println(getCommon(nums1, nums2));
    }
}
