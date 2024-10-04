import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int sum = 0;

        // Calculate the total sum of all skills
        for (int sk : skill) {
            sum += sk;
        }

        // If sum cannot be evenly divided, return -1
        if (sum % (n / 2) != 0) {
            return -1;
        }

        int target = sum / (n / 2);
        Arrays.sort(skill);  // Sort skills to easily form pairs
        long totalSum = 0;

        // Try to form pairs from smallest and largest available skills
        for (int i = 0; i < n / 2; i++) {
            int pairSum = skill[i] + skill[n - 1 - i];
            if (pairSum != target) {
                return -1;  // If pair sum doesn't match target, return -1
            }
            totalSum += (long) skill[i] * skill[n - 1 - i];  // Add the product of the pair
        }

        return totalSum;
    }
}
