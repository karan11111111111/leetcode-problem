class Solution {
    public int romanToInt(String s) {
        int length = s.length();
        int value = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (i < length - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        value += (s.charAt(i + 1) == 'V') ? 4 : 9;
                        i++; // Skip the next character
                    } else {
                        value += 1;
                    }
                    break;

                case 'V':
                    value += 5;
                    break;

                case 'X':
                    if (i < length - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        value += (s.charAt(i + 1) == 'L') ? 40 : 90;
                        i++; // Skip the next character
                    } else {
                        value += 10;
                    }
                    break;

                case 'L':
                    value += 50;
                    break;

                case 'C':
                    if (i < length - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        value += (s.charAt(i + 1) == 'D') ? 400 : 900;
                        i++; // Skip the next character
                    } else {
                        value += 100;
                    }
                    break;

                case 'D':
                    value += 500;
                    break;

                case 'M':
                    value += 1000;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid Roman numeral character: " + c);
            }
        }
        return value;
    }
}
