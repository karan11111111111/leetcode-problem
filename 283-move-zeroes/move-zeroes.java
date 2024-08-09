class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        int n = nums.length;
        
       
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        
      
        for (int i = nonZeroIndex; i < n; i++) {
            nums[i] = 0;
        }
    }
}
