#include <vector>
#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        vector<int> result;
        if (s.empty() || words.empty()) return result;

        int wordLength = words[0].length();
        int totalWordsLen = wordLength * words.size();
        int n = s.length();

        // Create a frequency map for the words
        unordered_map<string, int> wordCount;
        for (const string& word : words) {
            wordCount[word]++;
        }

        // Loop through possible offsets (0 to wordLength - 1)
        for (int offset = 0; offset < wordLength; offset++) {
            unordered_map<string, int> currentCount;
            int start = offset, matchedWords = 0;

            for (int end = offset; end + wordLength <= n; end += wordLength) {
                // Get the current word
                string word = s.substr(end, wordLength);

                // If it's a valid word, update the current count
                if (wordCount.find(word) != wordCount.end()) {
                    currentCount[word]++;
                    
                    // Check if the count is valid
                    if (currentCount[word] <= wordCount[word]) {
                        matchedWords++;
                    } else {
                        // Remove extra occurrences
                        while (currentCount[word] > wordCount[word]) {
                            string removedWord = s.substr(start, wordLength);
                            currentCount[removedWord]--;
                            if (currentCount[removedWord] < wordCount[removedWord]) {
                                matchedWords--;
                            }
                            start += wordLength;
                        }
                    }

                    // If all words match, add the start index
                    if (matchedWords == words.size()) {
                        result.push_back(start);
                    }
                } else {
                    // Reset the window if the word is invalid
                    currentCount.clear();
                    matchedWords = 0;
                    start = end + wordLength;
                }
            }
        }

        return result;
    }
};
