class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long[] freq = new long[26]; // frequency of each character

        // Step 1: Initialize frequency array from input string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Simulate t transformations
        for (int step = 0; step < t; step++) {
            long[] newFreq = new long[26];

            for (int i = 0; i < 26; i++) {
                if (i == 25) { // 'z'
                    newFreq[0] = (newFreq[0] + freq[25]) % MOD; // 'a'
                    newFreq[1] = (newFreq[1] + freq[25]) % MOD; // 'b'
                } else {
                    newFreq[i + 1] = (newFreq[i + 1] + freq[i]) % MOD;
                }
            }

            freq = newFreq;
        }

        // Step 3: Sum the frequencies to get final length
        long result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + freq[i]) % MOD;
        }

        return (int) result;
    }
}
