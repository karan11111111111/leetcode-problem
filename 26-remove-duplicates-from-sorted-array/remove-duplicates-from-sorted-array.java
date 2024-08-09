class Solution {
    public int removeDuplicates(int[] nums) {
        
    //  if(nums.length ==0)
    //  return 0;

    //  int uniqueIndex =1;

    //  for(int i= 1; i<nums.length; i++){
    //     if(nums[i] != nums[i-1]){
    //         nums[uniqueIndex] = nums[i];
    //         uniqueIndex++;
    //     }
    //  }

    //  return uniqueIndex;

    if(nums.length==0) 
       return 0;
       int uniqueIndex=0;
       for(int i=0;i<nums.length;i++){
        if(nums[uniqueIndex]!=nums[i]){
         uniqueIndex++;
        nums[uniqueIndex]=nums[i];
        }
       }
     return ++uniqueIndex;
    }
}