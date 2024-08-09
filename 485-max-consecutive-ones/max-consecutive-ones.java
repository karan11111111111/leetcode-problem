class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       
        int count =0;
        int maxx =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
            count++;
            maxx = Math.max(count,maxx);
            }
           else{
            count =0;
           }
        }

        return maxx;
    }
}