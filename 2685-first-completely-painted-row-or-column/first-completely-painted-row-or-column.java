class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Map value to its position in the matrix
        int[][] position = new int[rows * cols + 1][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                position[mat[i][j]][0] = i; // Row index
                position[mat[i][j]][1] = j; // Column index
            }
        }

        // Track how many elements are covered in each row and column
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        // Process elements in the order of arr
        for (int index = 0; index < arr.length; index++) {
            int value = arr[index];
            int row = position[value][0];
            int col = position[value][1];

            // Mark the value as covered
            rowCount[row]++;
            colCount[col]++;

            // Check if the row or column is completely covered
            if (rowCount[row] == cols || colCount[col] == rows) {
                return index; // Return the index of the first complete row/column
            }
        }

        return -1; // Should not happen for valid input
    }
}
