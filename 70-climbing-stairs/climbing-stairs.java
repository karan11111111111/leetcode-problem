class Solution {

    //recursion

    // public int climbStairs(int n) {
    //     if(n==0 || n==1){
    //         return 1;
    //     }
        
    //     return climbStairs(n-1) +climbStairs(n-2);
    // }


   //memoiozation

    // public int climbStairs(int n) {
    //     int[] memo = new int[n+1];
    //     return helper(n,memo);
        
    // }

    // private int helper(int n, int[]memo){
    //     if(n==0 || n==1){
    //         return 1;
    //     }
        
    //     if(memo[n] !=0){
    //         return memo[n];
    //     }

    //     memo[n] = helper(n-1,memo) + helper(n-2,memo);

    //     return memo[n];
    // }


    // Tabulation

    public int climbStairs(int n) {

        
        int[] tabul = new int[n+1];
        tabul[0] =1;
        tabul[1] =1;

        for(int i=2; i<=n; i++){
            tabul[i] = tabul[i-1] + tabul[i-2];
        }

        return tabul[n];
    }
   
}