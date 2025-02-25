import java.util.*;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];

        // Step 1: Construct the tree as an adjacency list
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Step 2: Find Bob’s path from node 'bob' to root (node 0)
        Map<Integer, Integer> bobTime = new HashMap<>();
        findBobPath(bob, -1, graph, bobTime, 0);

        // Step 3: DFS for Alice's most profitable path
        return dfsAlice(0, -1, 0, graph, bobTime, amount);
    }

    private boolean findBobPath(int node, int parent, List<Integer>[] graph, Map<Integer, Integer> bobTime, int time) {
        bobTime.put(node, time);
        if (node == 0) return true; // Bob reached the root

        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue;
            if (findBobPath(neighbor, node, graph, bobTime, time + 1)) return true;
        }

        bobTime.remove(node); // If this path isn't valid, remove the node
        return false;
    }

    private int dfsAlice(int node, int parent, int time, List<Integer>[] graph, Map<Integer, Integer> bobTime, int[] amount) {
        int profit = 0;

        // Adjust profit based on Bob’s arrival time
        if (!bobTime.containsKey(node) || time < bobTime.get(node)) {
            profit = amount[node]; // Alice takes full amount
        } else if (time == bobTime.get(node)) {
            profit = amount[node] / 2; // Bob and Alice arrive at the same time
        }

        int maxProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;

        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue;
            isLeaf = false;
            maxProfit = Math.max(maxProfit, dfsAlice(neighbor, node, time + 1, graph, bobTime, amount));
        }

        return isLeaf ? profit : profit + maxProfit;
    }
}
