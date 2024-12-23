class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) { // Corrected method name here
            if (c == '(') {
                if (count > 0) {
                    result.append(c);
                }
                count++;
            } else if (c == ')') {
                count--;
                if (count > 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
