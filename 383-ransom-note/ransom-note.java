import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        // Initialize two HashMaps for ransomNote and magazine
        HashMap<Character, Integer> ranMap = new HashMap<>();
        HashMap<Character, Integer> magaMap = new HashMap<>();

        // Populate ranMap with the character frequencies from ransomNote
        for (char c : ransomNote.toCharArray()) {
            ranMap.put(c, ranMap.getOrDefault(c, 0) + 1);
        }

        // Populate magaMap with the character frequencies from magazine
        for (char c : magazine.toCharArray()) {
            magaMap.put(c, magaMap.getOrDefault(c, 0) + 1);
        }

        // Compare the frequencies in ranMap with magaMap
        for (char c : ranMap.keySet()) {
            if (ranMap.get(c) > magaMap.getOrDefault(c, 0)) {
                return false;  // Not enough characters in the magazine
            }
        }

        return true;  // All characters are available in sufficient quantities
    }
}
