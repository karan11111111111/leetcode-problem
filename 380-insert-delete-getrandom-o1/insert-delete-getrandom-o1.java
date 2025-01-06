import java.util.*;

class RandomizedSet {
    private Map<Integer, Integer> valueToIndex; // Maps value to its index in the list
    private List<Integer> values; // Stores the actual values
    private Random random; // For random number generation

    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false; // Value already exists
        }
        values.add(val); // Add value to the list
        valueToIndex.put(val, values.size() - 1); // Map value to its index in the list
        return true;
    }
    
    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false; // Value does not exist
        }
        
        // Get the index of the value to remove
        int index = valueToIndex.get(val);
        
        // Swap the value with the last element in the list
        int lastValue = values.get(values.size() - 1);
        values.set(index, lastValue);
        valueToIndex.put(lastValue, index); // Update the index of the last value
        
        // Remove the last element from the list and map
        values.remove(values.size() - 1);
        valueToIndex.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        // Generate a random index and return the value at that index
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}
