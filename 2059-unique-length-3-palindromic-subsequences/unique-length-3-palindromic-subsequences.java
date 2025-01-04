import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        // Array to store the first and second occurrences of each character
        Pair[] occurrences = new Pair[26];

        // Initialize the array with pairs of -1, -1 (no occurrences)
        for (int i = 0; i < 26; i++) {
            occurrences[i] = new Pair(-1, -1);
        }

        // Traverse the string to find the first and second occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (occurrences[index].firstOcc == -1) {
                occurrences[index].firstOcc = i;
            } else {
                occurrences[index].secondOcc = i;
            }
        }

        int count = 0;

        // Check for each character if it has both first and second occurrences
        for (Pair pair : occurrences) {
            if (pair.firstOcc != -1 && pair.secondOcc != -1) {
                // Set to track distinct characters between the first and second occurrence
                Set<Character> distinctChars = new HashSet<>();
                for (int i = pair.firstOcc + 1; i < pair.secondOcc; i++) {
                    distinctChars.add(s.charAt(i));
                }
                count += distinctChars.size();
            }
        }

        return count;
    }

    // Helper class to store the first and second occurrences of a character
    class Pair {
        int firstOcc;
        int secondOcc;

        Pair(int firstOcc, int secondOcc) {
            this.firstOcc = firstOcc;
            this.secondOcc = secondOcc;
        }
    }
}
