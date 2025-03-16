import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        
        long left = 1, right = (long) ranks[0] * (long) cars * cars;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAll(ranks, cars, mid)) {
                right = mid; // Try a smaller time
            } else {
                left = mid + 1; // Increase time
            }
        }
        return left;
    }

    private boolean canRepairAll(int[] ranks, int cars, long timeLimit) {
        int totalCars = 0;
        for (int rank : ranks) {
            totalCars += Math.sqrt(timeLimit / rank);
            if (totalCars >= cars) return true; // Enough cars repaired
        }
        return false;
    }
}
