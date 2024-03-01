public class Day_29 {

    public static String maximumOddBinaryNumber(String s) {
        int oneCount = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (oneCount == 0)
            return "";

        for (int i = 1; i < oneCount; i++) {
            sb.append(1);
        }

        for (int i = oneCount; i < len; i++) {
            sb.append(0);
        }

        sb.append(1);

        return sb.toString();
    }

    public static void main(String[] args) {
        String test = "100110010";
        System.out.println(maximumOddBinaryNumber(test));
    }
}
