class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        // Compute total sum mod p
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        // If the sum is already divisible by p, return 0
        int target = totalSum % p;
        if (target == 0) {
            return 0;
        }

        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);  // Initialize with mod 0 at index -1

        int currentSum = 0;
        int minLen = n;

        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;

            // Calculate the required mod to remove
            int needed = (currentSum - target + p) % p;

            // If we found a subarray that, when removed, makes the total divisible by p
            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            // Update the map with the current mod and index
            modMap.put(currentSum, i);
        }

        // If minLen wasn't updated, return -1, otherwise return minLen
        return minLen == n ? -1 : minLen;
    }
}
