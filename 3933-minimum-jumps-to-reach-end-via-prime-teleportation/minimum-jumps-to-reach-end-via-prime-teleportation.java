import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int maxVal = 0;
        for (int num : nums) maxVal = Math.max(maxVal, num);

        // 1. Precompute Smallest Prime Factor (SPF) using Sieve
        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) spf[i] = i;
        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }

        // 2. Map primes to indices where nums[j] % p == 0
        List<Integer>[] primeToIndices = new ArrayList[maxVal + 1];
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            while (temp > 1) {
                int p = spf[temp];
                if (primeToIndices[p] == null) primeToIndices[p] = new ArrayList<>();
                primeToIndices[p].add(i);
                while (temp % p == 0) temp /= p; // Skip duplicate factors
            }
        }

        // 3. BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedIndices = new boolean[n];
        boolean[] visitedPrimes = new boolean[maxVal + 1];

        queue.offer(0);
        visitedIndices[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currIdx = queue.poll();
                if (currIdx == n - 1) return steps;

                // Option A: Adjacent Steps
                if (currIdx + 1 < n && !visitedIndices[currIdx + 1]) {
                    visitedIndices[currIdx + 1] = true;
                    queue.offer(currIdx + 1);
                }
                if (currIdx - 1 >= 0 && !visitedIndices[currIdx - 1]) {
                    visitedIndices[currIdx - 1] = true;
                    queue.offer(currIdx - 1);
                }

                // Option B: Prime Teleportation (Only if nums[currIdx] is prime)
                if (isPrime(nums[currIdx], spf)) {
                    int p = nums[currIdx];
                    if (!visitedPrimes[p]) {
                        visitedPrimes[p] = true;
                        if (primeToIndices[p] != null) {
                            for (int nextIdx : primeToIndices[p]) {
                                if (!visitedIndices[nextIdx]) {
                                    visitedIndices[nextIdx] = true;
                                    queue.offer(nextIdx);
                                }
                            }
                            // Optimization: Clear bucket to save memory/time
                            primeToIndices[p].clear();
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean isPrime(int n, int[] spf) {
        return n > 1 && spf[n] == n;
    }
}