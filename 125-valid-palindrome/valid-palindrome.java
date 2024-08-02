class Solution {
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase
        s = s.toLowerCase();
        
        // Remove non-alphanumeric characters
        s = s.replaceAll("[^a-z0-9]", "");
        
        // Initialize pointers for comparison
        int left = 0;
        int right = s.length() - 1;
        
        // Compare characters from both ends
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}