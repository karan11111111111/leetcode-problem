import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        // Convert the board into a 1D array for easier handling
        int[] flattenedBoard = new int[n * n];
        int idx = 0;
        boolean leftToRight = true;
        
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    flattenedBoard[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flattenedBoard[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }
        
        // BFS setup
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                // If we reached the last cell
                if (current == n * n - 1) {
                    return steps;
                }
                
                // Try all dice rolls (1 to 6)
                for (int dice = 1; dice <= 6; dice++) {
                    int next = current + dice;
                    
                    // Skip if the next square is out of bounds
                    if (next >= n * n) {
                        continue;
                    }
                    
                    // If there's a ladder or snake, move to the destination square
                    if (flattenedBoard[next] != -1) {
                        next = flattenedBoard[next] - 1;  // Convert to 0-based index
                    }
                    
                    // If not visited, add to the queue
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            
            steps++;
        }
        
        // If we can't reach the top-right corner, return -1
        return -1;
    }
}
