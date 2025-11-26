class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxsum = nums[0];
        int sum = 0;

        for(int num : nums){
           sum = sum+num;
            if(sum>maxsum){
                maxsum = sum;
                
            }
            if(sum <0){
                sum=0;
            }
        }

        return maxsum;
        
    }
}