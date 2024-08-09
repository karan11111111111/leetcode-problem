// class Solution {
//     public int missingNumber(int[] nums) {
       
//         // Arrays.sort(nums);
        
        
//         // for (int i = 0; i < nums.length; i++) {
            
//         //     if (nums[i] != i) {
//         //         return i; 
//         //     }
//         // }
        
//         // // If no missing number was found in the array, the missing number is the last element
       
//         // return nums.length;
//     }
// }

class Solution {
    int mySum(int maxLen)
    {
        int sum=0;
        for(int i=0;i<=maxLen;i++)
        {
            sum=sum+i;
        }
        return sum;
    }
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int ans=len;

        int firstSum=mySum(len);
        int secondSum=0;

        for(int i=0;i<len;i++)
        {
            secondSum=secondSum+nums[i];
        }
        
        return firstSum-secondSum;
        
    }
}