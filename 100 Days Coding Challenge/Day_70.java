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

    public static void printArray(int[] arr) {
        int len = arr.length;
        System.out.print("[ ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
        printArray(deckRevealedIncreasing(deck));
    }

}
