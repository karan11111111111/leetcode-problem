class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1]; // Difference array
        
        // Populate the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int value = direction == 1 ? 1 : -1;
            
            diff[start] += value;
            if (end + 1 < n) {
                diff[end + 1] -= value;
            }
        }
        
        // Compute the prefix sum to get net shifts
        int[] netShifts = new int[n];
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += diff[i];
            netShifts[i] = currentShift;
        }
        
        // Apply the shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char originalChar = s.charAt(i);
            int newCharIndex = (originalChar - 'a' + netShifts[i]) % 26;
            if (newCharIndex < 0) {
                newCharIndex += 26; // Handle negative shifts
            }
            char newChar = (char) ('a' + newCharIndex);
            result.append(newChar);
        }
        
        return result.toString();
    }
}
