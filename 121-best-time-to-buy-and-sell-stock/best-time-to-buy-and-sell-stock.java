class Solution {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length ==0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i=0; i<prices.length; ++i){
         if(prices[i]< min){
            min = prices[i]; 
         }

         int profit = prices[i] - min;

         if(profit>max){
            max = profit;
         }
        }

        return max;
        
    }
}


// class Solution {
//         public int maxProfit(int[] prices) {
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