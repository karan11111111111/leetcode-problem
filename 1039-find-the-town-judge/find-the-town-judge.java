class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1; // If there's only one person, they are the judge by definition

        int[] trustBalance = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            trustBalance[a]--;
            trustBalance[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustBalance[i] == n - 1) {
                return i; // i is the town judge
            }
        }

        return -1; // No town judge found
    }
}
