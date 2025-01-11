class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Directions for the 8 neighbors
        int[] directions = {-1, 0, 1};

        // Step 1: Apply rules and use temporary states
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(board, row, col);

                // Rule 1 and Rule 3: Live cell with fewer than 2 or more than 3 neighbors dies
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2; // Mark as "was live but now dead"
                }

                // Rule 4: Dead cell with exactly 3 neighbors becomes alive
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 3; // Mark as "was dead but now alive"
                }
            }
        }

        // Step 2: Finalize the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 0; // Dead
                } else if (board[row][col] == 3) {
                    board[row][col] = 1; // Alive
                }
            }
        }
    }

    // Helper method to count live neighbors
    private int countLiveNeighbors(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int liveNeighbors = 0;

        // Directions for the 8 neighbors
        int[] directions = {-1, 0, 1};

        for (int dr : directions) {
            for (int dc : directions) {
                if (dr == 0 && dc == 0) continue; // Skip the cell itself

                int r = row + dr;
                int c = col + dc;

                // Check bounds and add live neighbors
                if (r >= 0 && r < rows && c >= 0 && c < cols && (board[r][c] == 1 || board[r][c] == 2)) {
                    liveNeighbors++;
                }
            }
        }

        return liveNeighbors;
    }
}
