class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26]; // To store max frequency of each character in words2

        // Calculate the max frequency of each character in words2
        for (String word : words2) {
            int[] freq = getFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        
        // Check each word in words1
        for (String word : words1) {
            int[] freq = getFrequency(word);
            if (isSubset(freq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper method to calculate character frequency for a word
    private int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Helper method to check if freq1 is a superset of freq2
    private boolean isSubset(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] < freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
