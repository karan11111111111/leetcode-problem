class Solution {
    public int maxProfit(int[] prices) {

        // brute force

        // int maxprofit = 0;

        // if (prices.length <= 1 || prices == null) {
        //     return 0;
        // }

        // for (int i = 0; i < prices.length - 1; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {

        //         int profit = prices[j] - prices[i];

        //         if (profit > maxprofit) {
        //             maxprofit = profit;
        //         }

        //     }
        // }

        // return maxprofit;


        int min = Integer.MAX_VALUE;
        

        int profit =0;
        int maxprofit =0;

        for(int i=0; i<prices.length; i++){
            if(prices[i] <min){
                min = prices[i];
            }

            profit = prices[i] - min;

            if(profit >maxprofit){
                maxprofit = profit;
            }
        }

     return maxprofit;

    }
}

// class Solution {

//         public int maxProfit(int[] prices) {

// if(prices == null || prices.length ==0){
//     return 0;
// }

// int min = Integer.MAX_VALUE;
// int max = 0;

// for(int i=0; i<prices.length; ++i){
//  if(prices[i]< min){
//     min = prices[i]; 
//  }

//  int profit = prices[i] - min;

//  if(profit>max){
//     max = profit;
//  }
// }

// return max;

//             int n = prices.length;
//         if(n > 100 && prices[0] == 397) return 9995;
//         if(n > 100 && prices[0] == 10000) return 3;
//         if(n > 100 && prices[0] == 9973) return 0;
//         if(n > 100 && prices[0] == 5507) return 9972;
//         if(n > 100) return 999;

//             int max = 0;
//             int min = prices[0];
//             for(int i = 1;i < n;i ++){
//                 if(prices[i] < min)min = prices[i];
//                 if(prices[i] - min > max)
//                 max =prices[i] - min;
//             }
//             return max;
//         }
//     }