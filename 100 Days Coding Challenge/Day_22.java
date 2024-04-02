// Problem No : 787 "Cheapest Flights Within K Stops"

/* Aim :- There are n cities connected by some number of flights. 
    You are given an array flights where flights[i] = [fromi, toi, pricei] 
    indicates that there is a flight from city fromi to city toi with cost pricei.

    You are also given three integers src, dst, and k, return the cheapest price 
    from src to dst with at most k stops. If there is no such route, return -1. 
*/

import java.util.*;

public class Day_22 {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple {
        int first, second, third;

        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if (stops > K)
                continue;
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if (cost + edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }
        if (dist[dst] == (int) (1e9))
            return -1;
        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int source = 0, dst = 3, k = 1;

        int cheapestPrice = findCheapestPrice(n, flights, source, dst, k);
        System.out.println("Cheapest price: " + cheapestPrice);
    }
}
