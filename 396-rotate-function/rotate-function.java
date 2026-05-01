
// //brute force
// class Solution {
//     public int maxRotateFunction(int[] nums) {
//         int n = nums.length;
//         int maxVal = Integer.MIN_VALUE;

        
//         for (int k = 0; k < n; k++) {
//             int currentSum = 0;
            
            
//             for (int i = 0; i < n; i++) {
               
//                 int index = (i + k) % n;
//                 currentSum += i * nums[index];
//             }
            
//             maxVal = Math.max(maxVal, currentSum);
//         }
        
//         return maxVal;
//     }
// }


class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int currentF = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            currentF += i * nums[i];
        }

        int maxVal = currentF;

        
        for (int i = n - 1; i > 0; i--) {
           
            currentF = currentF + sum - (n * nums[i]);
            maxVal = Math.max(maxVal, currentF);
        }

        return maxVal;
    }
}