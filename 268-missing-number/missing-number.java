class Solution {
    public int missingNumber(int[] nums) {

    int count =0;

    int n = nums.length;

    Arrays.sort(nums);

    for(int i=0; i < n; i++){
        if(count != nums[i]){
            return count;
        }
        count++;
    }

    return n;
    }     
    
}