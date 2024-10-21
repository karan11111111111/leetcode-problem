class Solution {
    public int maxCoins(int[] piles) {
        // Sort the array in ascending order
        Arrays.sort(piles);
        
        int n = piles.length;
        int maxCoins = 0;
        
        // Pick the second largest coin in every triplet (starting from the end)
        for (int i = n / 3; i < n; i += 2) {
            maxCoins += piles[i];
        }
        
        return maxCoins;
    }
}