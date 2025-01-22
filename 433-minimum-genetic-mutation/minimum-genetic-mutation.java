import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // Step 1: Create a set for quick look-up of valid genes
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        // If the endGene is not in the bank, return -1
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        // Step 2: Initialize BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        
        // Map to store visited genes to avoid revisiting
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        
        // Step 3: Initialize mutation count (steps)
        int mutations = 0;
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all genes at the current level
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                
                // If we reach the endGene, return the current mutation count
                if (currentGene.equals(endGene)) {
                    return mutations;
                }
                
                // Try all possible mutations (change each character of the gene)
                for (int j = 0; j < currentGene.length(); j++) {
                    char[] geneArray = currentGene.toCharArray();
                    
                    // Try all possible mutations (A, C, G, T) at position j
                    for (char c : new char[] {'A', 'C', 'G', 'T'}) {
                        geneArray[j] = c;
                        String mutatedGene = new String(geneArray);
                        
                        // If the mutated gene is in the bank and not visited, enqueue it
                        if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                            visited.add(mutatedGene);
                            queue.offer(mutatedGene);
                        }
                    }
                }
            }
            
            // Increment mutation count for each BFS level
            mutations++;
        }
        
        // If we exit the loop without finding the endGene, return -1 (no solution)
        return -1;
    }
}
