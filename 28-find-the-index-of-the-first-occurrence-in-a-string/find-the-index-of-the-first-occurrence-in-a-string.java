class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is empty, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Edge case: if needle is longer than haystack, return -1
        if (needleLength > haystackLength) {
            return -1;
        }

        // Traverse the haystack
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Check if the substring matches the needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i; // Found the first occurrence
            }
        }

        return -1; // No match found
    }
}
