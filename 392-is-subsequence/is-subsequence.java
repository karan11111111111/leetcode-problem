// class Solution {
//     public boolean isSubsequence(String s, String t) {
        
//             int n = s.length();
//             int m = t.length();
//         if(n==0){
//             return true;
//         }
//         if(m==0){
//             return false;
//         }

//             boolean dp[][] = new boolean[n+1][m+1];

          
//            for(int j=0; j<=m; j++){
//             dp[0][j] = true;
//            }

//            for(int i=1; i<=n; i++){
//               for(int j=1; j<=m; j++){
//                 if(s.charAt(i-1) == t.charAt(j-1)){
//                     dp[i][j] = dp [i-1][j-1];
//                 }else{
//                     dp[i][j] = dp[i][j-1];
//                 }
//               }
//            }
           
        
//         return dp[n][m];


//     }
// }


class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true; 
        }
        
        int i = 0; 
        int j = 0; 

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; 
            }
            j++; 
        }

        return i == s.length(); 
    }
}
