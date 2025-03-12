class Solution {
    public int maximumCount(int[] nums) {

        int negC = 0;
        int posC = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]<0){
              negC++;
            }else if(nums[i]>0){
             posC++;
            }
        }
        
        return Math.max(negC,posC);
    }
}