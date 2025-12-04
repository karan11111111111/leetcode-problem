// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int count =0;
//         int maxx =0;
//         for(int i=0; i<nums.length; i++){
//             if(nums[i]==1){
//             count++;
//             maxx = Math.max(count,maxx);
//             }
//            else{
//             count =0;
//            }
//         }
//         return maxx;
//     }
// }

class Solution {
       public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxcount =0;
        for(int i=0;i<nums.length;i++){

            if(nums[i] == 1){
                count++;
                maxcount = Math.max(count, maxcount);
            }else{
                count =0;
            }
        }
           
            return maxcount;
        }
}
// class Solution {
//        public int findMaxConsecutiveOnes(int[] nums) {
//         int count=0;
//         for(int i=0;i<nums.length;){
//             if(nums[i]==1){
//                 int j=i;
//                 while( j<nums.length && nums[j]==1){
//                     j++; 
//                 }
//                 int z=(j-i);
//                 if(count<z){
//                     count=z;
//                     i=j+1;
//                 }
//                 else {
//                 	i=j+1;
//                 }
//             }
//             else{
//                 i++;
//             } 
//         }
//             return count;
//         }
// }