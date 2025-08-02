import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int globalMin = Integer.MAX_VALUE;
        
        // 1) Count total frequency across both baskets, and track the overall minimum element.
        for (int x : basket1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            globalMin = Math.min(globalMin, x);
        }
        for (int x : basket2) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            globalMin = Math.min(globalMin, x);
        }
        
        // 2) Check feasibility: every element’s total count must be even.
        for (int cnt : freq.values()) {
            if ((cnt & 1) != 0) {
                return -1;  // impossible
            }
        }
        
        // 3) Build two lists of “surplus” elements:
        //    - extras1: values we have too many of in basket1 (will move out of basket1)
        //    - extras2: values we have too many of in basket2
        List<Integer> extras1 = new ArrayList<>();
        List<Integer> extras2 = new ArrayList<>();
        
        // Count difference for each value
        Map<Integer, Integer> diff = new HashMap<>();
        for (int x : basket1) diff.put(x, diff.getOrDefault(x, 0) + 1);
        for (int x : basket2) diff.put(x, diff.getOrDefault(x, 0) - 1);
        
        // For each value, add |diff/2| copies to the appropriate list
        for (Map.Entry<Integer, Integer> e : diff.entrySet()) {
            int val = e.getKey();
            int d = e.getValue();
            if (d > 0) {
                // basket1 has d more; we need to move d/2 out of basket1
                for (int i = 0; i < d/2; i++) extras1.add(val);
            } else if (d < 0) {
                // basket2 has -d more; move (-d/2) out of basket2
                for (int i = 0; i < (-d)/2; i++) extras2.add(val);
            }
        }
        
        // 4) Sort extras1 ascending, extras2 descending
        Collections.sort(extras1);
        extras2.sort(Collections.reverseOrder());
        
        // 5) Pair them up one-to-one, choosing the cheaper of:
        //    direct swap cost = min(a, b)
        //    or via two-swaps with globalMin = 2*globalMin
        long ans = 0;
        int m = extras1.size();
        for (int i = 0; i < m; i++) {
            int a = extras1.get(i);
            int b = extras2.get(i);
            ans += Math.min(Math.min(a, b), 2 * globalMin);
        }
        
        return ans;
    }
}
