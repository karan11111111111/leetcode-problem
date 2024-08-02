class Solution {
    public boolean isPalindrome(String s) {
        var size = s.length();
        int left = 0;
        int right = size - 1;
        
        while (left < right) {
            while (left < right && !isValidChar(s, left)) {
                left++;
            }
            
            while (right > left && !isValidChar(s, right)) {
                right--;
            }
            
            var leftChar = toLowerCase(s.charAt(left));
            var rightChar = toLowerCase(s.charAt(right));
            
            if (leftChar != rightChar) return false;
            left++;
            right--;
        }
        
        return true;
    }
    
    private boolean isValidChar(String s, int index) {
        var character = s.charAt(index);
        
        return ((character >= '0' && character <= '9') || (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z'));
    }
    
    private char toLowerCase(char character) {
        var pos = character - 'A';
        if (pos >= 0 && pos <= 25) {
            return (char) (pos + 'a');
        }
        
        return character;
    }
}