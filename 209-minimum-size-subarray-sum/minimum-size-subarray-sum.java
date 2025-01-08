class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

       int minLength = Integer.MAX_VALUE; //stores the minimun length
       int sum =0; // current sum of window
       int start =0; // start index of the sliding window 

       //Traverse the array

       for(int end =0; end <n; end++){
        sum = sum+nums[end];  //Expand the window by  adding the current number

        //shrink the window as long as the is >= target

        while(sum >=target){
            minLength = Math.min(minLength, end-start+1);
            sum -= nums[start];
            start++;
        }
       }
        
        return minLength == Integer.MAX_VALUE?0:minLength;
    }
}