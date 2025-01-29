import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new ArrayList[n + 1];

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Process edges one by one
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Check if adding (u, v) forms a cycle
            if (hasPath(u, v, graph, new HashSet<>())) {
                return edge;  // This is the redundant connection
            }

            // Otherwise, add edge to the graph
            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];  // Should not reach here per problem constraints
    }

    // DFS to check if there's already a path between u and v
    private boolean hasPath(int u, int v, List<Integer>[] graph, Set<Integer> visited) {
        if (u == v) return true; // Cycle detected

        visited.add(u);

        for (int neighbor : graph[u]) {
            if (!visited.contains(neighbor) && hasPath(neighbor, v, graph, visited)) {
                return true;
            }
        }

        return false;
    }
}
