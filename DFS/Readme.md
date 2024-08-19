Code Breakdown
DFS Method
java
Copy code
public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
    // marking current node as visited
    vis[node] = true;
    ls.add(node);
    
    // getting neighbour nodes
    for (Integer it : adj.get(node)) {
        if (!vis[it]) {
            dfs(it, vis, adj, ls);
        }
    }
}
node: The current node being visited.
vis: A boolean array to keep track of visited nodes.
adj: The adjacency list representing the graph.
ls: A list to store the DFS traversal result.
This method marks the current node as visited, adds it to the result list, and recursively visits all its unvisited neighbors.
DFS Traversal Function
java
Copy code
public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    // boolean array to keep track of visited vertices
    boolean vis[] = new boolean[V + 1];
    vis[0] = true; 
    ArrayList<Integer> ls = new ArrayList<>();
    dfs(0, vis, adj, ls); 
    return ls; 
}
V: Number of vertices in the graph.
adj: The adjacency list representing the graph.
This function initializes the visited array, marks the starting node (0) as visited, and calls the DFS method starting from node 0. It then returns the DFS traversal result.
Main Method
java
Copy code
public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        adj.add(new ArrayList<>());
    }
    adj.get(0).add(2);
    adj.get(2).add(0);
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(0).add(3);
    adj.get(3).add(0);
    adj.get(2).add(4);
    adj.get(4).add(2);
    
    Solution sl = new Solution(); 
    ArrayList<Integer> ans = sl.dfsOfGraph(5, adj);
    int n = ans.size(); 
    for (int i = 0; i < n; i++) {
        System.out.print(ans.get(i) + " "); 
    }
}
Initializes the adjacency list for a graph with 5 vertices.
Adds edges to the adjacency list.
Creates an instance of Solution and calls dfsOfGraph.
Prints the DFS traversal result.
Example
Let's consider the graph defined in the code:

Vertices: 0, 1, 2, 3, 4
Edges:
0 - 1
0 - 2
0 - 3
2 - 4
Adjacency List Representation
css
Copy code
adj[0] = [2, 1, 3]
adj[1] = [0]
adj[2] = [0, 4]
adj[3] = [0]
adj[4] = [2]
DFS Traversal Steps
Start from vertex 0.

Visited: [0]
DFS Result: [0]
Visit neighbor 2 of vertex 0.

Visited: [0, 2]
DFS Result: [0, 2]
Visit neighbor 4 of vertex 2.

Visited: [0, 2, 4]
DFS Result: [0, 2, 4]
All neighbors of vertex 4 are visited. Backtrack to vertex 2.

All neighbors of vertex 2 are visited. Backtrack to vertex 0.

Visit neighbor 1 of vertex 0.

Visited: [0, 2, 4, 1]
DFS Result: [0, 2, 4, 1]
All neighbors of vertex 1 are visited. Backtrack to vertex 0.

Visit neighbor 3 of vertex 0.

Visited: [0, 2, 4, 1, 3]
DFS Result: [0, 2, 4, 1, 3]
Final DFS Traversal
Copy code
0 2 4 1 3
Visual Representation of DFS
perl
Copy code
0
|\
| \
2  1  3
|    /
|   /
4
Start from 0, visit 2, then 4. Backtrack to 2, then 0, visit 1, then 3.
This DFS traversal starts from vertex 0 and explores as far as possible along each branch before backtracking, ensuring each vertex is visited exactly once.