class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true; 
        }

        int n = s1.length();
        int diffCount = 0;
        int first = -1, second = -1;

        
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                
                if (diffCount == 1) {
                    first = i;
                } else if (diffCount == 2) {
                    second = i;
                } else {
                    return false; 
                }
            }
        }

        
        return diffCount == 2 && 
               s1.charAt(first) == s2.charAt(second) && 
               s1.charAt(second) == s2.charAt(first);
    }
}
