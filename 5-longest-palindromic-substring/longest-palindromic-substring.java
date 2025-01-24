public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0; // To store the start and end indices of the longest palindrome
        
        // Helper function to expand around the center
        for (int i = 0; i < s.length(); i++) {
            // Expand around a single character (odd-length palindrome)
            int len1 = expandAroundCenter(s, i, i);
            // Expand around a pair of characters (even-length palindrome)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the maximum length
            int len = Math.max(len1, len2);
            
            // Update the start and end indices if a longer palindrome is found
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // Helper function to expand the palindrome around the center
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}
