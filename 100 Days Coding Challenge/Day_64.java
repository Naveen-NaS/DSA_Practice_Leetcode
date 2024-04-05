public class Day_64 {

    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(i + 1);
            if (Math.abs(ch1 - ch2) == 32) {
                sb.delete(i, i + 2);
                i = Math.max(-1, i - 2);
            }
        }

        if (sb.length() == 2) {
            char ch1 = sb.charAt(0);
            char ch2 = sb.charAt(1);
            if (Math.abs(ch1 - ch2) == 32) {
                return "";
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }
}
