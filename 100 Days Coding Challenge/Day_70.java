// Problem No : 950 "Reveal Cards In Increasing Order"

/* Aim :- You are given an integer array deck. There is a deck of cards where every card has a unique integer. 
    The integer on the ith card is deck[i].
    
    You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
    
    You will do the following steps repeatedly until all cards are revealed:
        Take the top card of the deck, reveal it, and take it out of the deck.
        If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
        If there are still unrevealed cards, go back to step 1. Otherwise, stop.
    Return an ordering of the deck that would reveal the cards in increasing order.
    
    Note that the first entry in the answer is considered to be the top of the deck. 
*/

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
        int[] deck = { 1, 13, 11, 2, 3, 5, 7 };
        printArray(deckRevealedIncreasing(deck));
    }

}
