class Solution {
    public void sortColors(int[] nums) {
        // Arrays.sort(nums);

    int n = nums.length;

    for(int i=0; i<n; i++){
        for(int j=0; j<n-i-1; j++){
           if(nums[j]>nums[j+1]){
            int temp = nums[j];
            nums[j] = nums[j+1];
            nums[j+1] = temp;
           }
        }
    }

    }
}