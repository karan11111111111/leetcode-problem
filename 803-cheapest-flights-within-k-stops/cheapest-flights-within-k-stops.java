class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = (int)1e9;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;

        // Run at most k+1 times (k stops → k+1 edges)
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n); // copy previous state

            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                if (cost[u] == INF) continue; // skip unreachable
                temp[v] = Math.min(temp[v], cost[u] + w);
            }

            cost = temp; // update after this iteration
        }

        return cost[dst] == INF ? -1 : cost[dst];
    }
}
