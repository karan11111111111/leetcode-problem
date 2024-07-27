import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Edge case: if source and destination are the same
        if (source == destination) {
            return true;
        }

        // Step 1: Build the graph using adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // Step 2: Perform DFS to find a path from source to destination
        Set<Integer> visited = new HashSet<>();
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int current, int destination, Set<Integer> visited) {
        if (current == destination) {
            return true;
        }
        visited.add(current);
        for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
            if (!visited.contains(neighbor) && dfs(graph, neighbor, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}
