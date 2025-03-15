class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        int ans = right; // Initialize with the maximum possible value

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSteal(nums, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canSteal(int[] nums, int k, int capability) {
        int count = 0;
        boolean prevStolen = false;
        for (int num : nums) {
            if (num <= capability && !prevStolen) {
                count++;
                prevStolen = true;
            } else {
                prevStolen = false;
            }
        }
        return count >= k;
    }
}