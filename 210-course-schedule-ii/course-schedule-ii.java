import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create the graph and calculate in-degrees
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        
        // Build the graph and fill in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.putIfAbsent(prereq, new ArrayList<>());
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
        
        // Step 2: Initialize the queue with all courses with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Step 3: Process the courses and build the topological order
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);
            
            // Reduce the in-degree of the neighbors
            if (graph.containsKey(course)) {
                for (int neighbor : graph.get(course)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        // Step 4: If the order contains all the courses, return it; otherwise, return an empty array (cycle detected)
        if (order.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = order.get(i);
            }
            return result;
        } else {
            return new int[0]; // Cycle detected, no valid ordering
        }
    }
}
