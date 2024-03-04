import java.util.Arrays;

public class Day_32 {

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int score = 0, maxScore = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right];
                right--;
                score--;
            } else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] tokens = { 100, 200, 300, 400 };
        int power = 200;
        System.out.println("The Score is : " + bagOfTokensScore(tokens, power));
    }
}
