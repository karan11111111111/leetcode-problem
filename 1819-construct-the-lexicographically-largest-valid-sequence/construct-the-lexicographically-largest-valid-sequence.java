class Solution {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1; // Length of the resulting array
        int[] result = new int[len]; // The result array
        boolean[] used = new boolean[n + 1]; // Track used numbers

        // Start backtracking from index 0
        backtrack(n, result, used, 0);
        return result;
    }

    private boolean backtrack(int n, int[] result, boolean[] used, int index) {
        int len = result.length;

        // If we reached the end, return true (valid sequence found)
        if (index == len) {
            return true;
        }

        // If already filled, move to the next index
        if (result[index] != 0) {
            return backtrack(n, result, used, index + 1);
        }

        // Try placing numbers from largest to smallest
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue; // Skip if already used

            if (num == 1) { // Special case for '1', it appears only once
                result[index] = 1;
                used[1] = true;
                if (backtrack(n, result, used, index + 1)) return true;
                used[1] = false;
                result[index] = 0;
            } else {
                int secondIndex = index + num; // Position for second occurrence

                if (secondIndex < len && result[secondIndex] == 0) {
                    // Place the number
                    result[index] = result[secondIndex] = num;
                    used[num] = true;

                    // Recurse
                    if (backtrack(n, result, used, index + 1)) return true;

                    // Backtrack
                    result[index] = result[secondIndex] = 0;
                    used[num] = false;
                }
            }
        }
        return false; // No valid placement found
    }
}
