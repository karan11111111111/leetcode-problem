class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0}; // Frequency array for 'a', 'b', and 'c'
        int i = 0, total = 0;
        
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']++; // Include character at j in window
            
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // All 'a', 'b', 'c' are in the window
                total += s.length() - j; // All substrings from i to end are valid
                count[s.charAt(i) - 'a']--; // Shrink the window from left
                i++;
            }
        }
        return total;
    }
}
