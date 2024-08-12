class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int ans []= {-1,-1};
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
           
            if(nums[mid]>=target){
                high = mid -1;
            }else{
                low = mid +1;
            }
             if(nums[mid]==target){
              ans[0] = mid;
            }
        }

       low = 0; 
       high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
           
            if(nums[mid]<=target){
                low = mid +1;
            }else{
                high = mid -1;
            }
             if(nums[mid]==target){
              ans[1] = mid;
            }
        }

    return ans;

    }
}