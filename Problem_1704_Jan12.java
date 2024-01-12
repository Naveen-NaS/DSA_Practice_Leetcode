public class Problem_1704_Jan12 {
    public static boolean halvesAreAlike(String s) {
        int len = s.length();
        String left = s.substring(0, len / 2);
        String right = s.substring(len / 2, len);

        int leftCount = countVowels(left);
        int rightCount = countVowels(right);

        return leftCount == rightCount;
    }

    public static int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String testString = "book";
        System.out.println(halvesAreAlike(testString));
    }
}