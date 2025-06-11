// class Solution {
//     public void setZeroes(int[][] matrix) {

// int nRows = matrix.length;
// int nCols = matrix[0].length;

// boolean[] zeroRows = new boolean[nRows];
// boolean[] zeroCols = new boolean[nCols];

// // Step 1: Mark the rows and columns that should be zeroed
// for (int i = 0; i < nRows; i++) {
//     for (int j = 0; j < nCols; j++) {
//         if (matrix[i][j] == 0) {
//             zeroRows[i] = true;
//             zeroCols[j] = true;  // Corrected index
//         }
//     }
// }

// // Step 2: Zero out marked rows
// for (int i = 0; i < nRows; i++) {
//     if (zeroRows[i]) {
//         for (int j = 0; j < nCols; j++) {
//             matrix[i][j] = 0;
//         }
//     }
// }

// // Step 3: Zero out marked columns
// for (int j = 0; j < nCols; j++) {  // Corrected loop to iterate over columns
//     if (zeroCols[j]) {
//         for (int i = 0; i < nRows; i++) {
//             matrix[i][j] = 0;
//         }
//     }
// }

//     }
// }

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int[][] temp = new int[n][m];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 temp[i][j] = matrix[i][j];
//             }
//         }

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (temp[i][j] == 0) {
//                     for (int k = 0; k < m; k++) {
//                         matrix[i][k] = 0;
//                     }
//                     for (int k = 0; k < n; k++) {
//                         matrix[k][j] = 0;
//                     }
//                 }
//             }
//         }
//     }
// }

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        // Step 1: Mark 0s in first row and column
        for (int i = 0; i < n; i++)
            if (matrix[i][0] == 0) firstCol = true;

        for (int j = 0; j < m; j++)
            if (matrix[0][j] == 0) firstRow = true;

        // Step 2: Use first row and column to mark zeros
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // mark row
                    matrix[0][j] = 0;  // mark column
                }
            }
        }

        // Step 3: Set cells to 0 using markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Step 4: Handle first row and column separately
        if (firstRow) {
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
        }

        if (firstCol) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }
    }
}
