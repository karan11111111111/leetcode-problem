import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] will be true if s[0...i-1] can be segmented
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Base case: an empty string can always be segmented
        
        // Convert the wordDict into a HashSet for faster lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Iterate through the string s
        for (int i = 1; i <= n; i++) {
            // Check all possible substrings s[j...i-1]
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // No need to check further, as we've found a valid segmentation
                }
            }
        }
        
        // Return whether the whole string can be segmented
        return dp[n];
    }
}
