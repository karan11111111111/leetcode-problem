// class Solution {
//     public int singleNumber(int[] nums) {

//         //a^a = 0;
//         //a^0 = a;
//         int xor =0;
//         for(int i=0; i<nums.length; i++){
//             xor = xor^nums[i];
//         }
//         return xor;
//     }
// }

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num;  // XOR each element with the result
        }
        
        return result;
    }
}
