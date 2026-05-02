class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGood(int num) {
        boolean hasChanged = false;
        while (num > 0) {
            int digit = num % 10;
            
            // If it contains an invalid digit, the whole number is invalid
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            
            // If it contains at least one digit that changes upon rotation
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasChanged = true;
            }
            
            num /= 10;
        }
        return hasChanged;
    }
}