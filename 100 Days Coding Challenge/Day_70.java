import java.util.*;

public class Day_70 {

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int len = deck.length;
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            index.offer(i);
        }
        int[] result = new int[len];
        for (int card : deck) {
            result[index.pollFirst()] = card;
            if (!index.isEmpty()) {
                index.offer(index.pollFirst());
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
