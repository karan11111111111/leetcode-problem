public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        // Loop while there are still 1 bits in n
        while (n != 0) {
            n = n & (n - 1);  // Clear the least significant 1 bit
            count++;           // Increment the count
        }
        
        return count;  // Return the total number of 1 bits
    }
}
