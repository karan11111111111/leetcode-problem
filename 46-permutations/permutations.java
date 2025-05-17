import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result; // Edge case: empty input
        }
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        // Base case: if the current permutation has all numbers
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Explore all unused numbers
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // Skip already used numbers
            }
            current.add(nums[i]); // Choose the current number
            used[i] = true; // Mark it as used
            backtrack(nums, current, result, used); // Recurse
            current.remove(current.size() - 1); // Backtrack
            used[i] = false; // Unmark the number
        }
    }
}
