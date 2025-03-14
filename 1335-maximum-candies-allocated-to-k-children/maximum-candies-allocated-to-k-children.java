class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int maxm = 0;
        
        for (int candy : candies) {
            sum += candy;
            maxm = Math.max(maxm, candy);
        }

        // If total candies are less than the number of children, return 0
        if (sum < k) {
            return 0;
        }

        // Binary Search on the number of candies per child
        int left = 1, right = maxm, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;

            for (int candy : candies) {
                count += candy / mid;  // How many children can get at least 'mid' candies
            }

            if (count >= k) {
                ans = mid;  // A possible answer, but we try to maximize it
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
