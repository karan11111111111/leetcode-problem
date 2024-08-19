Code Breakdown
Class Definition and Method Signature
java
Copy code
import java.util.*;
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
The class Solution contains the method bfsOfGraph, which takes the number of vertices V and the adjacency list adj as parameters and returns the BFS traversal as an ArrayList<Integer>.
Initialization
java
Copy code
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
bfs: An ArrayList to store the BFS traversal result.
vis: A boolean array to keep track of visited vertices.
q: A queue to manage the BFS traversal process.
Start BFS from the First Node (0)
java
Copy code
        q.add(0);
        vis[0] = true;
Add the starting node (0) to the queue and mark it as visited.
BFS Traversal
java
Copy code
        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it: adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
While the queue is not empty, do the following:
Dequeue a node from the queue.
Add this node to the BFS result list.
Get all adjacent vertices of the dequeued node.
If an adjacent vertex has not been visited, mark it as visited and enqueue it.
Return BFS Result
java
Copy code
        return bfs;
    }
Return the BFS traversal result.
Main Method to Test the BFS Implementation
java
Copy code
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        Solution sl = new Solution(); 
        ArrayList<Integer> ans = sl.bfsOfGraph(5, adj);
        int n = ans.size(); 
        for(int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " "); 
        }
    }
}
Create the adjacency list for a graph with 5 vertices.
Add edges to the adjacency list.
Create an instance of Solution and call bfsOfGraph.
Print the BFS traversal result.
Example
Let's consider the graph defined in the code:

Vertices: 0, 1, 2, 3, 4
Edges:
0 - 1
0 - 4
1 - 2
1 - 3
Adjacency List Representation
css
Copy code
adj[0] = [1, 4]
adj[1] = [0, 2, 3]
adj[2] = [1]
adj[3] = [1]
adj[4] = [0]
BFS Traversal Steps
Start from vertex 0.

Queue: [0]
BFS Result: []
Dequeue 0, visit its neighbors 1 and 4.

Queue: [1, 4]
BFS Result: [0]
Dequeue 1, visit its neighbors 2 and 3 (0 is already visited).

Queue: [4, 2, 3]
BFS Result: [0, 1]
Dequeue 4 (no unvisited neighbors).

Queue: [2, 3]
BFS Result: [0, 1, 4]
Dequeue 2 (no unvisited neighbors).

Queue: [3]
BFS Result: [0, 1, 4, 2]
Dequeue 3 (no unvisited neighbors).

Queue: []
BFS Result: [0, 1, 4, 2, 3]
Final BFS Traversal
Copy code
0 1 4 2 3
This BFS traversal starts from vertex 0 and visits all vertices level by level, ensuring each vertex is visited exactly once.