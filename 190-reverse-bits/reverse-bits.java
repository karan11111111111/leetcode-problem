public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        
        for (int i = 0; i < 32; i++) {
            // Shift reversed left by 1 to make room for the next bit
            reversed <<= 1;
            // Get the least significant bit of n and add it to reversed
            reversed |= (n & 1);
            // Shift n to the right by 1 to process the next bit
            n >>= 1;
        }
        
        return reversed;
    }
}
