class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces
        s = s.trim();

        // Step 2: Split the string into words using one or more spaces as the delimiter
        String[] words = s.split("\\s+");

        // Step 3: Reverse the words array
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" "); // Add space between words
            }
        }

        // Step 4: Return the final result as a string
        return result.toString();
    }
}
