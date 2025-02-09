import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        long totalPairs = 0, goodPairs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            goodPairs += freqMap.getOrDefault(key, 0); // Count pairs that form good pairs
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }

        totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - goodPairs;
    }
}
