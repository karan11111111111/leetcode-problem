import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        // Digit-to-letters mapping
        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result; // Return empty list for empty input
        }
        
        // Backtracking function
        backtrack(digits, 0, new StringBuilder(), result, mapping);
        return result;
    }
    
    private void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] mapping) {
        // Base case: if the current combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the letters corresponding to the current digit
        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];
        
        // Explore all letters for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Add the letter
            backtrack(digits, index + 1, current, result, mapping); // Recurse
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
