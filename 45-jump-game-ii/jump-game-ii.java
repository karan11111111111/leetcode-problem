// class Solution {
//     public int jump(int[] nums) {
//         int n = nums.length;
//         int [] dp = new int[n];
        
        
//         for (int i = 1; i < n; i++) {
//           dp[i] = Integer.MAX_VALUE;
//         }


//        for(int i=0; i<n; i++){
//         for(int j =i+1; j<= Math.min(i+nums[i], n-1);j++){
//             dp[j] = Math.min(dp[j] , dp[i]+1);
//         }
//        }
//         return dp[n - 1]; 
        
//     }
// }

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0; // Number of jumps
        int far = 0; // Farthest point that can be reached
        int currentEnd = 0; // Current jump range

        for (int i = 0; i < n - 1; i++) { 
            far = Math.max(far, i + nums[i]); 

            if (i == currentEnd) { 
                jumps++;
                currentEnd = far; 

                if (currentEnd >= n - 1) { 
                    break;
                }
            }
        }

        return jumps;
    }
}
