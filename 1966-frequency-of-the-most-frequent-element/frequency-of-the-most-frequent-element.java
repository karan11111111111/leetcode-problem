import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);   
        long total = 0;      
        int left = 0, result = 1;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            
            while ((long)nums[right] * (right - left + 1) - total > k) {
                total -= nums[left];
                left++;
            }

            
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
