class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustBalance = new int[n + 1];

        for (int[] t : trust) {
            trustBalance[t[0]]--;  // Person t[0] trusts someone, decrease their balance
            trustBalance[t[1]]++;  // Person t[1] is trusted by someone, increase their balance
        }

        for (int i = 1; i <= n; i++) {
            if (trustBalance[i] == n - 1) {
                return i;  // Found the judge
            }
        }

        return -1;  // No judge found
    }
}
