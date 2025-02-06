import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length, result = 0;

        // Count pairs (nums[i], nums[j]) that produce the same product
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Compute valid tuples from pairs count
        for (int count : productCount.values()) {
            if (count > 1) {
                result += (count * (count - 1) / 2) * 8;
            }
        }

        return result;
    }
}
