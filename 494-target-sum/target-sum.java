class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countWays(nums, 0, target);
    }

    private int countWays(int[] nums, int index, int target) {
        
        if (index == nums.length) {
            return (target == 0) ? 1 : 0;
        }

        
        int add = countWays(nums, index + 1, target - nums[index]);

        
        int subtract = countWays(nums, index + 1, target + nums[index]);

        return add + subtract;
    }
}
