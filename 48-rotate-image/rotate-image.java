// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         int[][] temp = new int[n][n];

//         // Copy values to the rotated positions
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 temp[j][n - 1 - i] = matrix[i][j];
//             }
//         }

//         // Copy temp back to original matrix
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 matrix[i][j] = temp[i][j];
//             }
//         }
//     }
// }

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                // Swap
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                start++;
                end--;
            }
        }
    }
}

