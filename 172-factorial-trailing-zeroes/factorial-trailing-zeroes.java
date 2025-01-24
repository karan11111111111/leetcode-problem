public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        
        // Keep dividing n by powers of 5
        while (n >= 5) {
            n /= 5; // Divide n by 5
            count += n; // Add the quotient to the count
        }
        
        return count; // Return the total count of trailing zeroes
    }
}
