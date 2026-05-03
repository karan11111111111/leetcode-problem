class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) return true;

        int n = s.length();

        // Try every possible shift 'offset'
        for (int offset = 0; offset < n; offset++) {
            boolean match = true;
            
            // Check if s shifted by 'offset' matches goal
            for (int i = 0; i < n; i++) {
                if (s.charAt((i + offset) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }
            
            if (match) return true;
        }

        return false;
    }
}