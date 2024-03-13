public class Day_41 {

    public static int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }

        int totalSum = sum(n);
        for (int pivot = 1; pivot < n; pivot++) {
            int leftSum = sum(pivot - 1);
            int rightSum = totalSum - leftSum - pivot;
            if (leftSum == rightSum) {
                return pivot;
            }
        }

        return -1;
    }

    public static int sum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }
}
