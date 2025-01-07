class Solution {
    public String intToRoman(int num) {
        // Define arrays for Roman numeral symbols and their corresponding values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        // Use a StringBuilder to construct the Roman numeral
        StringBuilder roman = new StringBuilder();
        
        // Loop through the values array
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num, append the symbol
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return roman.toString();
    }
}
