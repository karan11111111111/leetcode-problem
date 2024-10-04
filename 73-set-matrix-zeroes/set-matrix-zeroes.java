class Solution {
    public void setZeroes(int[][] matrix) {
      
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        boolean[] zeroRows = new boolean[nRows];
        boolean[] zeroCols = new boolean[nCols];

        // Step 1: Mark the rows and columns that should be zeroed
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;  // Corrected index
                }
            }
        }

        // Step 2: Zero out marked rows
        for (int i = 0; i < nRows; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < nCols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Zero out marked columns
        for (int j = 0; j < nCols; j++) {  // Corrected loop to iterate over columns
            if (zeroCols[j]) {
                for (int i = 0; i < nRows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
