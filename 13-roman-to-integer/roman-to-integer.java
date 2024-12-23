class Solution {
    public int romanToInt(String s) {
      int length = s.length();
        char c;
        int value = 0;
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            if (c == 'I') {
                if (i != length -1) {
                    if ( s.charAt(i+1) == 'V') {
                        value += 4;
                        i++;
                    } else if ( s.charAt(i+1) == 'X') {
                        i++;
                        value += 9;
                    } else value += 1;
                } else value += 1;
            } else if (c == 'V') {
                value += 5;
            } else if (c == 'X') {
                if (i != length -1) {
                    if (s.charAt(i + 1) == 'L') {
                        value += 40;
                        i++;
                    } else if (s.charAt(i + 1) == 'C') {
                        value += 90;
                        i++;
                    } else value += 10;
                } else value += 10;
            } else if (c == 'L') {
                value += 50;
            } else if (c == 'C') {
                if (i != length -1) {
                    if (s.charAt(i + 1) == 'D') {
                        value += 400;
                        i++;
                    } else if (s.charAt(i + 1) == 'M') {
                        value += 900;
                        i++;
                    } else value += 100;
                } else value += 100;
            } else if (c == 'D') {
                value += 500;
            } else value += 1000;
        }
        return value;
    }
}