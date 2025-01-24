import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Create a list of projects, each represented as a pair of (capital, profit)
        int n = profits.length;
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }
        
        // Sort the projects by their required capital
        projects.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        // Max-heap (priority queue) to select the most profitable project
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        int currentCapital = w;
        int i = 0;
        
        // Select up to k projects
        for (int j = 0; j < k; j++) {
            // Add all projects that can be done with the current capital to the max heap
            while (i < n && projects.get(i)[0] <= currentCapital) {
                maxHeap.offer(projects.get(i)[1]);  // Add the profit to the max heap
                i++;
            }
            
            // If the heap is empty, no more projects can be selected
            if (maxHeap.isEmpty()) {
                break;
            }
            
            // Get the most profitable project from the heap
            currentCapital += maxHeap.poll();  // Complete the project and add profit to capital
        }
        
        return currentCapital;
    }
}
