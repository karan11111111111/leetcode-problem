class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countOnes(i);
        }

        return ans;
    }

    // Pure recursive function to count 1s in binary representation of x
    private int countOnes(int x) {
        if (x == 0) return 0;
        return (x & 1) + countOnes(x >> 1);  // add 1 if last bit is 1, then recurse
    }
}
