// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         // You can start from step 0 or step 1
//         return Math.min(minCost(n - 1, cost), minCost(n - 2, cost));
//     }

//     private int minCost(int i, int[] cost) {
//         if (i < 0) return 0;
//         if (i == 0 || i == 1) return cost[i];

//         return cost[i] + Math.min(minCost(i - 1, cost), minCost(i - 2, cost));
//     }
// }

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // You can start from step 0 or step 1
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCost(dp, n - 1, cost), minCost(dp,n - 2, cost));
    }

    private int minCost(int dp[],int i, int[] cost) {
        if (i < 0) return 0;
        if (i == 0 || i == 1) return cost[i];

        if(dp[i] != -1){
            return dp[i];
        }

        return dp[i] = cost[i] + Math.min(minCost(dp, i - 1, cost), minCost(dp, i - 2, cost));
    }
}
