import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalWordsLength = wordLength * wordCount;
        
        // Create a hashmap for word frequencies in the list
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Iterate over possible starting points
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> currentCount = new HashMap<>();
            int left = i;
            int count = 0;

            // Slide through the string `s`
            for (int j = i; j + wordLength <= s.length(); j += wordLength) {
                String word = s.substring(j, j + wordLength);
                
                if (wordMap.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;
                    
                    // If a word is seen more times than it appears in `words`, shift left pointer
                    while (currentCount.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    // If all words match, add the starting index to the result
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Reset the window if the word is not in `words`
                    currentCount.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }

        return result;
    }
}
