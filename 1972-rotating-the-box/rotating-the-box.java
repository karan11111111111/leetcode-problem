class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Step 1: Apply Gravity to each row
        for (int i = 0; i < m; i++) {
            // We use a pointer to track the next available empty position from the right
            int emptyPos = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    // Obstacle: The next stone cannot move past this point
                    emptyPos = j - 1;
                } else if (boxGrid[i][j] == '#') {
                    // Stone: Move it to the emptyPos and update emptyPos
                    boxGrid[i][j] = '.';
                    boxGrid[i][emptyPos] = '#';
                    emptyPos--;
                }
            }
        }

        // Step 2: Rotate 90 degrees clockwise
        // New dimensions: rows = n, columns = m
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // The element at (i, j) moves to (j, m - 1 - i)
                rotatedBox[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return rotatedBox;
    }
}