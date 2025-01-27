import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Initialize a transitive closure matrix
        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Step 2: Populate the graph with direct prerequisites
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            reachable[from][to] = true;
        }

        // Step 3: Use Floyd-Warshall to compute transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        // Step 4: Answer the queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }
}
