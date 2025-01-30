import java.util.*;

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        int maxGroups = 0;
        
        // Process each component separately
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) { // Unvisited component
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(graph, i, color, component)) return -1;
                
                // Find the max BFS layers in this component
                int maxLayers = 0;
                for (int node : component) {
                    maxLayers = Math.max(maxLayers, bfsMaxDepth(graph, node));
                }
                maxGroups += maxLayers;
            }
        }
        return maxGroups;
    }
    
    // Check if the component is bipartite and collect its nodes
    private boolean isBipartite(List<List<Integer>> graph, int start, int[] color, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);
            
            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // Odd cycle found
                }
            }
        }
        return true;
    }
    
    // BFS to find the maximum depth from any node
    private int bfsMaxDepth(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return depth;
    }
}
