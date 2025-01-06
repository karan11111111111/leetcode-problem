class Solution {
    // Helper function to check if a character is a vowel
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    // Helper function to check if a word starts and ends with a vowel
    private boolean isVowelString(String word) {
        if (word.isEmpty()) return false;
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1]; // Prefix sum array

        // Build the prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        // Answer the queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefix[r + 1] - prefix[l];
        }

        return result;
    }
}
