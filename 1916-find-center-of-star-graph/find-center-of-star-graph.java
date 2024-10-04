class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1; // Number of nodes
        int[] indegree = new int[n + 1];

        // Calculate the indegree of each node
        for (int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        // The center node will have an indegree of n-1
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1) {
                return i;
            }
        }

        return -1; // Just a fallback, the problem guarantees there is a center
    }
}
