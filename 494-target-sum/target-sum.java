// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         return countWays(nums, 0, target);
//     }

//     private int countWays(int[] nums, int index, int target) {
        
//         if (index == nums.length) {
//             return (target == 0) ? 1 : 0;
//         }

        
//         int add = countWays(nums, index + 1, target - nums[index]);

        
//         int subtract = countWays(nums, index + 1, target + nums[index]);

//         return add + subtract;
//     }
// }


// import java.util.*;

// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         Map<String, Integer> memo = new HashMap<>();
//         return countWays(nums, 0, target, memo);
//     }

//     private int countWays(int[] nums, int index, int target, Map<String, Integer> memo) {
//         String key = index + "," + target;

//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }

//         if (index == nums.length) {
//             return (target == 0) ? 1 : 0;
//         }

//         int add = countWays(nums, index + 1, target - nums[index], memo);
//         int subtract = countWays(nums, index + 1, target + nums[index], memo);

//         memo.put(key, add + subtract);
//         return add + subtract;
//     }
// }


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        
        if (target > sum || target < -sum) return 0;

        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[0][sum] = 1; 

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (dp[i - 1][j] != 0) {
                    int plus = j + num;
                    int minus = j - num;

                    if (plus < 2 * sum + 1)
                        dp[i][plus] += dp[i - 1][j];
                    if (minus >= 0)
                        dp[i][minus] += dp[i - 1][j];
                }
            }
        }

        return dp[n][target + sum]; 
    }
}
