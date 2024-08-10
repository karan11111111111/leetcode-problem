// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//        int n = nums.length;

//        int b[] =new  int[2];
//        for(int i=0; i<n; i++){
//         for(int j=i+1; j<n; j++){
//             if(nums[i]+nums[j]==target){
//               b[0] = i;
//               b[1] = j;  
//               return b;
//             }
//         }
//        }

//     return null;
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
         for(int i = 1;i<nums.length;i++)
         {
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]+nums[j-i]==target)
                {
                    return new int[] {j,j-i};
                }
            }
         }
         return null;
    }
}