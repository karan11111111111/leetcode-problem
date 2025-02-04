class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
       int sum = nums[0], max = nums[0];
        for(int i=1; i<n; i++){
            
            

            if(nums[i]>nums[i-1]){
             sum = sum+nums[i];
            
            }else{
             
             max = Math.max(sum, max);
                sum =nums[i];
            }
          
        }
       return Math.max(sum,max); 
    }
}