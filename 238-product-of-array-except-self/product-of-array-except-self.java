//brute force



// class Solution {

//     public int[] productExceptSelf(int[] nums) {

//         int arr[] = new int[nums.length];

//         for(int i=0; i<nums.length; i++){
//             int mul =1;
//             for(int j=0; j<nums.length; j++){
//                 if(i!=j){
//                 mul = mul* nums[j];
//                 }
//             }

//             arr[i] = mul;
//         }

//         return arr;
        
//     }
// }

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        
        result[0] = 1;  
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

       
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
