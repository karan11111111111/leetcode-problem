class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int s, int l){
      while(s<l){
        int temp = nums[s];
        nums[s] = nums[l];
        nums[l] = temp;
        s++;
        l--;
      }
       }

   }
    
