class Solution {
    public int countPrefixSuffixPairs(String[] words) { // Updated method name
        int count = 0;
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Ensure i < j
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
