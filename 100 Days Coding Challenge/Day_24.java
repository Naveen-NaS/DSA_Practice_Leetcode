// Problem No : 2709 "Greatest Common Divisor Traversal"

/* Aim :- You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices.
    You can traverse between index i and index j, i != j, if and only if gcd(nums[i], nums[j]) > 1, 
    where gcd is the greatest common divisor.
    
    Your task is to determine if for every pair of indices i and j in nums, where i < j, there exists a 
    sequence of traversals that can take us from i to j.
    
    Return true if it is possible to traverse between all such pairs of indices, or false otherwise 
*/

import java.util.*;

public class Day_24 {

    static Map<Integer, List<Integer>> prime2index;
    static Map<Integer, List<Integer>> index2prime;

    public Day_24() {
        prime2index = new HashMap<>();
        index2prime = new HashMap<>();
    }

    // Run dfs with help of our two lists: prime2index and index2prime
    public static void dfs(int index, List<Boolean> visitedIndex, Map<Integer, Boolean> visitedPrime) {
        // if already visited this index, return
        if (visitedIndex.get(index))
            return;

        // mark visited
        visitedIndex.set(index, true);

        // check if index2prime contains the key
        if (!index2prime.containsKey(index))
            return;

        // loop through all prime factors of this number
        for (int prime : index2prime.get(index)) {
            // already visited
            if (visitedPrime.get(prime))
                continue;
            // mark visited
            visitedPrime.put(prime, true);
            // check if prime2index contains the key
            if (!prime2index.containsKey(prime))
                continue;
            // loop through all elements that have this prime factor in common
            for (int index1 : prime2index.get(prime)) {
                // already visited, continue
                if (visitedIndex.get(index1))
                    continue;
                // visit via dfs
                dfs(index1, visitedIndex, visitedPrime);
            }
        }
    }

    public static boolean canTraverseAllPairs(int[] nums) {
        // find all prime factors and create two mappings
        // prime2index and index2prime
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = 2; j * j <= nums[i]; j++) {
                if (temp % j == 0) {
                    prime2index.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                    index2prime.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    while (temp % j == 0)
                        temp /= j;
                }
            }
            // to handle case, if number has a prime factor greater than sqrt(num)
            // Eg - 10 -> 2, 5. 5 is greater than sqrt(10) -> 3
            if (temp > 1) {
                prime2index.computeIfAbsent(temp, k -> new ArrayList<>()).add(i);
                index2prime.computeIfAbsent(i, k -> new ArrayList<>()).add(temp);
            }
        }

        // Run DFS from 0th index
        List<Boolean> visitedIndex = new ArrayList<>(Collections.nCopies(nums.length, false));
        Map<Integer, Boolean> visitedPrime = new HashMap<>();
        // Initialize all primes to false initially
        for (int prime : prime2index.keySet()) {
            visitedPrime.put(prime, false);
        }
        dfs(0, visitedIndex, visitedPrime);

        // if number of connected components is > 1 then return false
        for (boolean index : visitedIndex)
            if (!index)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 12, 8, 5 };
        System.out.println(canTraverseAllPairs(nums));
    }
}
