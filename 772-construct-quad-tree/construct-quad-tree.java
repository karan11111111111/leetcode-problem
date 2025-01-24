/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length, grid[0].length);
    }
    
    private Node construct(int[][] grid, int x, int y, int width, int height) {
        // Base case: if the area is a single cell
        if (width == 1 && height == 1) {
            return new Node(grid[x][y] == 1, true);  // If it's 1, make it a leaf with value true; otherwise, false
        }
        
        // Check if all elements in the current region are the same
        boolean isUniform = true;
        int val = grid[x][y];
        
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                if (grid[i][j] != val) {
                    isUniform = false;
                    break;
                }
            }
            if (!isUniform) {
                break;
            }
        }

        // If all elements are the same, make the current node a leaf
        if (isUniform) {
            return new Node(val == 1, true);
        }

        // Otherwise, divide the grid into 4 quadrants and recursively construct each one
        Node node = new Node(false, false);
        node.topLeft = construct(grid, x, y, width / 2, height / 2);
        node.topRight = construct(grid, x, y + height / 2, width / 2, height / 2);
        node.bottomLeft = construct(grid, x + width / 2, y, width / 2, height / 2);
        node.bottomRight = construct(grid, x + width / 2, y + height / 2, width / 2, height / 2);
        
        return node;
    }
}

