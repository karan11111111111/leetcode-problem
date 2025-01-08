// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         // Edge case: if the input array is empty, return an empty string
//         if (strs == null || strs.length == 0) {
//             return "";
//         }

//         // Start with the first string as the prefix
//         String prefix = strs[0];

//         // Loop through each string in the array
//         for (int i = 1; i < strs.length; i++) {
//             // Compare the current prefix with the current string
//             while (strs[i].indexOf(prefix) != 0) {
//                 // Shorten the prefix by removing the last character
//                 prefix = prefix.substring(0, prefix.length() - 1);

//                 // If the prefix becomes empty, return an empty string
//                 if (prefix.isEmpty()) {
//                     return "";
//                 }
//             }
//         }

//         // Return the longest common prefix
//         return prefix;
//     }
// }

class Solution {
    // Trie Node definition
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // For 26 lowercase English letters
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    // Initialize the Trie
    public Solution() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Find the longest common prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Insert all words into the Trie
        for (String word : strs) {
            insert(word);
        }

        // Find the longest common prefix
        TrieNode node = root;
        StringBuilder lcp = new StringBuilder();

        while (true) {
            int childCount = 0;
            int childIndex = -1;

            // Count the number of children for the current node
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    childCount++;
                    childIndex = i;
                }
            }

            // If there is more than one child or the node is the end of a word, stop
            if (childCount != 1 || node.isEndOfWord) {
                break;
            }

            // Move to the next node and append the character to the LCP
            node = node.children[childIndex];
            lcp.append((char) (childIndex + 'a'));
        }

        return lcp.toString();
    }
}
