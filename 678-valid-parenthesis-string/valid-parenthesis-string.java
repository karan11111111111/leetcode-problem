class Solution {
    public boolean checkValidString(String s) {
        int low = 0;  // Minimum number of open parentheses
        int high = 0; // Maximum number of open parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Add open parenthesis
                low++;
                high++;
            } else if (c == ')') {
                // Try to balance closing parenthesis
                if (low > 0) low--;
                high--;
            } else if (c == '*') {
                // Star can act as '(' or ')' or empty
                if (low > 0) low--;  // * acts like ')'
                high++;  // * acts like '('
            }
            
            // If high becomes negative, it means we have more ')' than we can handle
            if (high < 0) {
                return false;
            }
        }
        
        // At the end, low should be 0 (balanced parentheses)
        return low == 0;
    }
}
