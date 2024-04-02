// Problem No : 2864 "Maximum Odd Binary Number"

/* Aim :- You are given a binary string s that contains at least one '1'.

    You have to rearrange the bits in such a way that the resulting binary number is 
    the maximum odd binary number that can be created from this combination.
    
    Return a string representing the maximum odd binary number that can be created from the given combination.
    
    Note that the resulting string can have leading zeros. 
*/

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
        String test = "1001100100";
        System.out.println(maximumOddBinaryNumber(test));
    }
}
