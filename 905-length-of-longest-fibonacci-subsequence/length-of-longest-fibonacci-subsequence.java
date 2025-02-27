import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        // Store indices of elements in a HashMap for quick lookup
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate through all pairs (arr[i], arr[j])
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int ai = arr[i], aj = arr[j];
                int ak = ai + aj; // Next Fibonacci number
                
                // Check if ak exists in the array
                if (indexMap.containsKey(ak)) {
                    int k = indexMap.get(ak);
                    int len = dp.getOrDefault(i * n + j, 2) + 1;
                    dp.put(j * n + k, len);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0; // Valid sequence must be at least length 3
    }
}
