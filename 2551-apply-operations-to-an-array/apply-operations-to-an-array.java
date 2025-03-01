class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        // Step 1: Apply the given operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Shift all zeros to the end using two-pointer approach
        int index = 0; // Points to the next position to place a non-zero number
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                // Swap nums[i] with nums[index]
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        return nums;
    }
}
