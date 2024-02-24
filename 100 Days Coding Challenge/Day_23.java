public class Day_23 {

    static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        int len = operations.length;
        for (int i = 0; i < len; i++) {
            if (operations[i].charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        String[] operations = { "X++", "++X", "--X", "X--" };
        System.out.println(finalValueAfterOperations(operations));
    }
}
