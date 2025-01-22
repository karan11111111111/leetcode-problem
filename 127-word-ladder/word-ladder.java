import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Step 1: Create a set for the wordList for quick lookups
        Set<String> wordSet = new HashSet<>(wordList);
        
        // If the endWord is not in the word list, return 0
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Step 2: Initialize BFS queue with the beginWord and the number of steps (initially 1)
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        // Keep track of the number of transformations (steps)
        int steps = 1;

        // Step 3: Initialize visited set to prevent revisiting words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // Step 4: BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all words at the current level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Try all possible transformations (one letter change at a time)
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    
                    // Try changing the current letter to all possible letters (a-z)
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String transformedWord = new String(wordArray);

                        // If the transformed word is the endWord, return the current step count
                        if (transformedWord.equals(endWord)) {
                            return steps + 1;
                        }

                        // If the transformed word is in the wordSet and hasn't been visited yet, add it to the queue
                        if (wordSet.contains(transformedWord) && !visited.contains(transformedWord)) {
                            visited.add(transformedWord);
                            queue.offer(transformedWord);
                        }
                    }
                }
            }
            
            // Increment steps after processing the current level
            steps++;
        }

        // If we exit the loop without finding the endWord, return 0
        return 0;
    }
}
