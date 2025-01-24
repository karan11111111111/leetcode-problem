import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n || k <= 0) {
            return result; // Edge case: invalid inputs
        }
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the current combination has k elements
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Explore each possible number
        for (int i = start; i <= n; i++) {
            current.add(i); // Choose the current number
            backtrack(i + 1, n, k, current, result); // Recurse with the next number
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
