class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the input array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the prefix
        String prefix = strs[0];

        // Loop through each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Compare the current prefix with the current string
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by removing the last character
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, return an empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the longest common prefix
        return prefix;
    }
}
