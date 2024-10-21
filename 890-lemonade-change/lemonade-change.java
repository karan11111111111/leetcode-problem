class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;   // To count $5 bills
        int ten = 0;    // To count $10 bills
        
        for (int bill : bills) {
            if (bill == 5) {
                five++; // Store the $5 bill
            } else if (bill == 10) {
                if (five > 0) {
                    five--; // Give one $5 bill as change
                    ten++;  // Store the $10 bill
                } else {
                    return false; // Can't give change
                }
            } else if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;  // Give one $10 bill as change
                    five--; // Give one $5 bill as change
                } else if (five >= 3) {
                    five -= 3; // Give three $5 bills as change
                } else {
                    return false; // Can't give change
                }
            }
        }
        
        return true; // Successfully gave change for all customers
    }
}
