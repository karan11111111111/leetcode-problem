import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        // Sort by the difference (minimum - actual) descending
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int currentEnergy = 0;
        int initialEnergy = 0;
        
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            
            // If our current energy is less than the minimum required for this task
            if (currentEnergy < minimum) {
                // We need to add exactly the deficit to our initial energy
                initialEnergy += (minimum - currentEnergy);
                // After adding the deficit, our energy is now exactly the 'minimum'
                currentEnergy = minimum;
            }
            
            // Spend the actual energy
            currentEnergy -= actual;
        }
        
        return initialEnergy;
    }
}