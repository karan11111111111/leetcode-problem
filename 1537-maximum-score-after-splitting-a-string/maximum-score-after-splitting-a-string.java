class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int maxScore = 0;

        // Calculate the total number of '1's in the string
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        // Iterate through possible splits
        int leftZeros = 0; // Number of '0's in the left substring
        int rightOnes = totalOnes; // Number of '1's in the right substring
        for (int i = 0; i < n - 1; i++) {
            // Update leftZeros and rightOnes
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            // Calculate the score for the current split
            int score = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}
