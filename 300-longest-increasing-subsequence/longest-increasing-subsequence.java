import java.util.*;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        List<Integer> tails = new ArrayList<>();
        
        for (int num : nums) {
            // Use binary search to find the correct position for num
            int left = 0, right = tails.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            // If num is larger than all elements in tails, add it
            if (left >= tails.size()) {
                tails.add(num);
            } else {
                tails.set(left, num); // Replace the existing value with num
            }
        }
        
        // The size of tails is the length of the longest increasing subsequence
        return tails.size();
    }
}
