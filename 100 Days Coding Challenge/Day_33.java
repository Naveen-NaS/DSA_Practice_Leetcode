public class Day_33 {

    public static int minimumLength(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end && s.charAt(start) == s.charAt(end)) {
            char c = s.charAt(start);
            while (start <= end && s.charAt(start) == c) {
                start++;
            }
            while (end >= start && s.charAt(end) == c) {
                end--;
            }
        }

        return Math.max(0, end - start + 1);
    }

    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        System.out.println("Minimum Length : " + minimumLength(s));
    }
}
