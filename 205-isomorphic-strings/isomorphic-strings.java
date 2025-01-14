class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Maps to store the mapping of characters from s to t and vice versa
        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        // Iterate through the strings
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if the mapping is consistent
            if (mapST[charS] == 0 && mapTS[charT] == 0) {
                // Create a new mapping
                mapST[charS] = charT;
                mapTS[charT] = charS;
            } else if (mapST[charS] != charT || mapTS[charT] != charS) {
                return false; // Mapping is inconsistent
            }
        }

        return true;
    }
}
