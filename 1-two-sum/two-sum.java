class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!map.containsKey(x)) {
                map.put(target - x, i);
            } else {
                ans[0] = map.get(x);
                ans[1] = i;
                return ans;
            }
        }
        return ans;

    }
}