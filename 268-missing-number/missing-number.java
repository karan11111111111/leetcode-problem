class Solution {
    public int missingNumber(int[] nums) {
       
        Arrays.sort(nums);
        
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] != i) {
                return i; 
            }
        }
        
        // If no missing number was found in the array, the missing number is the last element
       
        return nums.length;
    }
}