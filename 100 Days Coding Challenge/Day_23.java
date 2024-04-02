// Problem No : 2092 "Find All People With Secret"

/* Aim :- You are given an integer n indicating there are n people numbered from 0 to n - 1. 
    You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei]
    indicates that person xi and person yi have a meeting at timei. A person may attend multiple 
    meetings at the same time. Finally, you are given an integer firstPerson.

    Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. 
    This secret is then shared every time a meeting takes place with a person that has the secret. 
    More formally, for every meeting, if a person xi has the secret at timei, then they will share 
    the secret with person yi, and vice versa.

    The secrets are shared instantaneously. That is, a person may receive the secret and share it 
    with people in other meetings within the same time frame.

    Return a list of all the people that have the secret after all the meetings have taken place. 
    You may return the answer in any order. 
*/

import java.util.*;

public class Day_23 {

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            par[i] = i;

        Union(0, firstPerson);

        List<Integer> ans = new ArrayList<>();
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        int m = meetings.length;
        int i = 0;
        while (i < m) {
            int currT = meetings[i][2];
            List<Integer> persons = new ArrayList<>();
            while (i < m && meetings[i][2] == currT) {
                int a = meetings[i][0], b = meetings[i][1];
                Union(a, b);
                persons.add(a);
                persons.add(b);
                i++;
            }
            for (int x : persons) {
                if (!connected(0, x))
                    reset(x);
            }
        }
        for (int j = 0; j < n; j++) {
            if (connected(0, j))
                ans.add(j);
        }
        return ans;
    }

    private static int[] par;
    private static int[] rank;

    public static int find(int p) {
        if (par[p] == p)
            return p;
        return par[p] = find(par[p]);
    }

    public static void Union(int a, int b) {
        int p1 = find(a), p2 = find(b);
        int u = rank[p1], v = rank[p2];
        if (u == v) {
            par[p2] = p1;
            rank[p1]++;
        } else if (u > v) {
            par[p2] = p1;
        } else {
            par[p1] = p2;
        }
    }

    public static boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public static void reset(int a) {
        par[a] = a;
    }

    public static void main(String[] args) {
        int n = 5, firstPerson = 1;
        int[][] meetings = { { 3, 4, 1 }, { 1, 2, 1 }, { 2, 3, 1 } };
        System.out.println(findAllPeople(n, meetings, firstPerson));
    }
}
