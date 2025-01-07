import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int lineLength = words[i].length();
            int start = i;

            // Collect words for the current line
            while (i + 1 < n && lineLength + words[i + 1].length() + (i - start + 1) <= maxWidth) {
                i++;
                lineLength += words[i].length();
            }

            // Build the current line
            StringBuilder line = new StringBuilder();
            int numWords = i - start + 1;
            int numSpaces = maxWidth - lineLength;

            // If it's the last line or only one word, left-justify
            if (i == n - 1 || numWords == 1) {
                for (int j = start; j <= i; j++) {
                    line.append(words[j]);
                    if (j < i) {
                        line.append(" ");
                    }
                }
                // Fill remaining spaces
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Distribute spaces evenly
                int spacesPerGap = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int j = start; j <= i; j++) {
                    line.append(words[j]);
                    if (j < i) { // Add spaces between words
                        for (int k = 0; k < spacesPerGap; k++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            // Add the line to the result
            result.add(line.toString());
            i++;
        }

        return result;
    }
}
