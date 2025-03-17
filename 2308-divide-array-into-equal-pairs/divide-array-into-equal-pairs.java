import java.util.HashMap;

class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count occurrences of each number
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check if all numbers have even occurrences
        for (int count : freqMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}
