class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; // Total gas available
        int totalCost = 0; // Total cost required
        int currentGas = 0; // Current gas balance
        int startIndex = 0; // Starting gas station index

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If we cannot reach the next station
            if (currentGas < 0) {
                startIndex = i + 1; // Start from the next station
                currentGas = 0; // Reset current gas balance
            }
        }

        // If total gas is less than total cost, return -1
        return totalGas >= totalCost ? startIndex : -1;
    }
}
