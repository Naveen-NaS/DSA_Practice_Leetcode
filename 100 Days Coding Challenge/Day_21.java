// Problem No : 997 "Find the Town Judge"

/* Aim :- In a town, there are n people labeled from 1 to n. 
    There is a rumor that one of these people is secretly the town judge.

    If the town judge exists, then:
        The town judge trusts nobody.
        Everybody (except for the town judge) trusts the town judge.
        There is exactly one person that satisfies properties 1 and 2.
    You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. 
    If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

    Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise. 
*/

public class Day_21 {

    public static int findJudge(int n, int[][] trust) {
        int[] trustCounts = new int[n + 1];
        for (int[] pair : trust) {
            trustCounts[pair[0]]--;
            trustCounts[pair[1]]++;
        }

        int judge = -1;
        for (int i = 1; i <= n; i++) {
            if (trustCounts[i] == n - 1) {
                if (judge != -1) {
                    return -1;
                }
                judge = i;
            }
        }

        return judge;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = { { 1, 3 }, { 1, 3 }, { 3, 1 } };
        System.out.println(findJudge(n, trust));
    }
}
