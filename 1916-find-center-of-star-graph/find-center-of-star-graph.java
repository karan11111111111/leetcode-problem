class Solution {
    public int findCenter(int[][] edges) {
        // Take the first two edges
        int[] edge1 = edges[0];
        int[] edge2 = edges[1];
        
        // The center node is the one that appears in both edges
        if (edge1[0] == edge2[0] || edge1[0] == edge2[1]) {
            return edge1[0];
        } else {
            return edge1[1];
        }
    }
}
