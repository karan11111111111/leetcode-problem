// class Solution {
//     public int maxSubArray(int[] nums) {
//        int maxSum = Integer.MIN_VALUE;
//        int n = nums.length;

//        for(int i=0; i<n; i++){
//         int currentSum =0;

//         for(int j=i; j<n; j++){
//             currentSum += nums[j];

//             maxSum  = Math.max(maxSum, currentSum);}
        
//        }

//        return maxSum;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(sum,max);
            if(sum<0){
            sum=0;
        }
      
        }
        return max;
    }
}