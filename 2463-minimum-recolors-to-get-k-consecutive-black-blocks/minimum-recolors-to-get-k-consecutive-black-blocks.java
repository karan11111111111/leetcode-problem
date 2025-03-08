class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minRecolors = Integer.MAX_VALUE;
        int currentWhites = 0;

        // Count white blocks in the first k-length window
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                currentWhites++;
            }
        }
        minRecolors = currentWhites; // Initialize with the first window result

        // Slide the window through the string
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                currentWhites--; // Remove leftmost element from the window
            }
            if (blocks.charAt(i) == 'W') {
                currentWhites++; // Add new element to the window
            }
            minRecolors = Math.min(minRecolors, currentWhites);
        }

        return minRecolors;
    }
}
