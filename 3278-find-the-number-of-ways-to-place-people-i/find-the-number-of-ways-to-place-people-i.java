class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];

                // Condition: A (i) is on upper-left of B (j)
                if (xi <= xj && yi >= yj) {
                    boolean valid = true;

                    // Check if any other point lies inside/on the rectangle
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;

                        int xk = points[k][0], yk = points[k][1];
                        if (xi <= xk && xk <= xj && yj <= yk && yk <= yi) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }

        return count;
    }
}
