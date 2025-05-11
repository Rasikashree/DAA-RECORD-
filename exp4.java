1.QUESTION : Write a program to perform Depth First Search (DFS) traversal on a graph.
AIM:
  To traverse a graph by going as deep as possible along each branch before backtracking.       
  ALGORITHM:
 Step1: Start from a selected source node.
 Step2: Mark the node as visited.
 Step3: Recur for all unvisited adjacent nodes.
 Step4: Use recursion or a stack.

CODING:
import java.util.*;
public class DFSExample {
    static void dfs(int v, boolean[] visited, List<List<Integer>> adj) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }
    public static void main(String[] args) {
        int vertices = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        dfs(0, visited, adj);
    }
}
   INPUT:
0 -> 1, 2  
1 -> 3, 4
    OUTPUT:
DFS Traversal: 0 1 3 4 2

2.QUESTION : Write a program to perform Breadth First Search (BFS) traversal on a graph.
AIM:

   To traverse a graph level by level using a queue.       

  ALGORITHM:

 Step1: Start from the source node and mark it visited.
 Step2: Add it to a queue.
 Step3: While the queue is not empty; Remove a node,Visit all its unvisited adjacent nodes and enqueue them

CODING:
import java.util.*;
public class BFSExample {
    static void bfs(int start, List<List<Integer>> adj, int vertices) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        int vertices = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        System.out.print("BFS Traversal: ");
        bfs(0, adj, vertices);
    }
}

   INPUT:
0 -> 1, 2  
1 -> 3, 4
    OUTPUT:
BFS Traversal: 0 1 2 3 4

3.QUESTION : Find the shortest path from a source node to all other nodes in a weighted graph with non-negative edge weights.

AIM:
     To compute the shortest distances from a single source node to all other nodes using a priority queue.       
  ALGORITHM:
 Step1: Initialize distances as infinity, except for the source node (0).
 Step2: Use a priority queue to pick the node with the minimum distance.
 Step3: For each adjacent node, update its distance if a shorter path is found.
 Step4: Repeat until the queue is empty.

CODING:
   import java.util.*;
   class DijkstraExample {
       static class Pair {
           int node, weight;
            Pair(int n, int w) { node = n; weight = w; }
       }
       public static void dijkstra(List<List<Pair>> graph, int src) {
           int n = graph.size();
           int[] dist = new int[n];
           Arrays.fill(dist, Integer.MAX_VALUE);
           dist[src] = 0;
           PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
           pq .add(new Pair(src, 0));
           while (!pq.isEmpty()) {
               Pair current = pq.poll();
               for (Pair neighbor : graph.get(current.node)) {
                   if (dist[current.node] + neighbor.weight < dist[neighbor.node]) {
                       dist[neighbor.node] = dist[current.node] + neighbor.weight;
                       pq.add(new Pair(neighbor.node, dist[neighbor.node]));
                   }
               }
           }
           System.out.println("Shortest distances from node " + src + ":");
           for (int i = 0; i < n; i++) {
               System.out.println("To node " + i + " = " + dist[i]);
           }
       }
       public static void main(String[] args) {
           int n = 5;
           List<List<Pair>> graph = new ArrayList<>();
           for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
           graph.get(0).add(new Pair(1, 4));
           graph.get(0).add(new Pair(2, 1));
           graph.get(2).add(new Pair(1, 2));
           graph.get(1).add(new Pair(3, 1));
           graph.get(2).add(new Pair(3, 5));
           graph.get(3).add(new Pair(4, 3));
           dijkstra(graph, 0);
       }
   }   



    INPUT:
0 -> 1 (4), 0 -> 2 (1)  
2 -> 1 (2), 1 -> 3 (1), 2 -> 3 (5), 3 -> 4 (3)
     OUTPUT:
Shortest distances from node 0:  
To node 0 = 0  
To node 1 = 3  
To node 2 = 1  
To node 3 = 4  
To node 4 = 7  


4.QUESTION : Find the shortest paths from a source to all vertices in a graph that may contain negative weights.

AIM:
     To detect negative weight edges and compute the shortest distances from a single source.   
    
  ALGORITHM:
 Step1: Initialize distances to all vertices as ∞, except the source = 0.
 Step2: Repeat V-1 times (V = number of vertices); Relax all edges: update dist[u] + weight < dist[v].
 Step3: (Optional) Run one more time to check for negative weight cycle.

CODING:
   public class BellmanFord {
    static class Edge {
        int u, v, weight;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.weight = w;
        }
    }
    public static void bellmanFord(int V, Edge[] edges, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE &&
                    dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            }
        }
        for (Edge edge : edges) {
            if (dist[edge.u] != Integer.MAX_VALUE &&
                dist[edge.u] + edge.weight < dist[edge.v]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }
    }
    public static void main(String[] args) {
        int V = 5;
        Edge[] edges = {
            new Edge(0, 1, -1),
            new Edge(0, 2, 4),
            new Edge(1, 2, 3),


            new Edge(1, 3, 2),
            new Edge(1, 4, 2),
            new Edge(3, 2, 5),
            new Edge(3, 1, 1),
            new Edge(4, 3, -3)
        };
        bellmanFord(V, edges, 0);
    }
}   
     INPUT:
0 → 1 (-1), 0 → 2 (4), 1 → 2 (3), 1 → 3 (2),  
1 → 4 (2), 3 → 2 (5), 3 → 1 (1), 4 → 3 (-3)
     OUTPUT:
Shortest distances from source 0:
To 0 = 0
To 1 = -1
To 2 = 2
To 3 = -2
To 4 = 1  

5.QUESTION : Find the shortest distances between all pairs of vertices in a weighted graph.
AIM:
     To compute shortest paths between every pair of nodes, even with negative edge weights (but no negative cycles).       

  ALGORITHM:
 Step1: Create a distance matrix dist[][] from the input graph.
 Step2: For each vertex k, update the distance dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]).
 Step3: Repeat for all vertices k as intermediate nodes.
 Step4: Detect negative cycles if dist[i][i] < 0 after the algorithm.

CODING:
   public class FloydWarshall {
    final static int INF = 99999;
    public static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        System.out.println("All-Pairs Shortest Path Matrix:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] graph = {
            {0,   5,  INF, 10},
            {INF, 0,   3, INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };
        floydWarshall(graph, V);
    }
}  




     INPUT:
0 → 1 (5), 0 → 3 (10)  
1 → 2 (3)  
2 → 3 (1)
     OUTPUT:
All-Pairs Shortest Path Matrix:
0 5 8 9
INF 0 3 4
INF INF 0 1
INF INF INF 0  


6.QUESTION: Given a weighted, undirected, and connected graph of V vertices and E edges.
AIM:
To implement Prim’s Algorithm to find the Minimum Spanning Tree (MST) of a given connected, undirected, and weighted graph and compute the sum of the weights of the edges included in the MST.

ALGORITHM:
Step 1: Initialize distance matrix dist[][] with edge weights, dist[i][j] = 0 if i == j, and ∞ if no edge exists.
Step 2: For each vertex k, consider it as an intermediate node.
Step 3: For each pair (i, j), update dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]).
Step 4: After all updates, if dist[i][i] < 0 for any i, report a negative weight cycle.
CODING:
import java.util.*;
class Pair {
    int node;
    int distance;
    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V];
        pq.add(new Pair(0, 0));
        int sum = 0;
        while (pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            if (vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1)

                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }  }   }
        return sum;
    }}
public class tUf {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);
            tmp2.add(u);
            tmp2.add(w);
            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
        Solution obj = new Solution();
        int sum = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
}
INPUT: 
V = 5, edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}}
OUTPUT: 16

7.QUESTION: Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
AIM:
The aim is to find the number of strongly connected components (SCCs) in a directed graph with V vertices and E edges. A strongly connected component is a subgraph where any two vertices are reachable from each other.
ALGORITHM:
Step 1: Initialize a stack st and visited array visited[] as false for all V vertices.
Step 2: For each vertex v, if not visited, perform DFS and push vertices onto the stack after visiting all descendants.
Step 3: Create the transpose (reverse) of the graph by reversing all edges.
Step 4: Reset the visited array visited[] to false.
Step 5: While the stack is not empty, pop the top vertex v; if not visited, perform DFS on the transposed graph starting from v and count it as one SCC.
Step 6: After the stack is empty, return the number of DFS calls performed in step 5 as the number of SCCs.

CODING:
import java.util.*;
public class SCCKosaraju {
    private static void dfs1(int v, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor])
                dfs1(neighbor, graph, visited, stack);
        }
        stack.push(v);
    }
    private static void dfs2(int v, List<List<Integer>> transpose, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : transpose.get(v)) {
            if (!visited[neighbor])
                dfs2(neighbor, transpose, visited);
        }
    }
    public static int countSCCs(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, graph, visited, stack);
            }
        }
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                transpose.get(v).add(u);  
            }
        }
        Arrays.fill(visited, false);
        int count = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                dfs2(v, transpose, visited);
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(1).add(3);
        graph.get(3).add(4);
        int result = countSCCs(V, graph);
        System.out.println("Number of Strongly Connected Components: " + result);
    }
}

INPUT:
Number of Vertices (V): 5  
Number of Edges (E): 5  
Edges[] = [[1,2],[2,1],[3,0],[4,3],[5,4]]

OUTPUT:
Number of Strongly Connected Components: 3  
Components:  
Component 1: 0 1 2  
Component 2: 3  
Component 3: 4

8.QUESTION: Given two components of an undirected graph.

AIM:
To identify and verify two connected components in an undirected graph and determine whether any path exists between nodes from different components.

ALGORITHM:
Step 1: Initialize a visited array to mark visited nodes.
Step 2: Traverse all vertices using DFS starting from each unvisited node.
Step 3: For each DFS traversal, store the connected nodes in a component list.
Step 4: Label each component with a unique identifier.
Step 5: After processing, you will get two or more components depending on connectivity.
Step 6: Return the list of components or check whether two nodes belong to the same component.

CODING:
import java.io.*;
import java.util.*;
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}
class Main {
    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);


        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

INPUT:
rank: {1,2,3}
parent: {4,5,6,7}

OUTPUT:
Not Same
Same

9.QUESTION: Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

AIM:
To implement a program that finds any valid topological sorting of a Directed Acyclic Graph (DAG) using an appropriate algorithm such as Kahn’s Algorithm (BFS-based) or DFS-based approach.

ALGORITHM:
Step 1: Calculate the indegree of all vertices.
Step 2: Add all vertices with indegree 0 to a queue.
Step 3: Remove from queue, add to topological order, and reduce indegree of neighbors.
Step 4: If any neighbor’s indegree becomes 0, add it to the queue.
Step 5: Repeat until the queue is empty and all vertices are processed.

CODING:
import java.util.*;
class Solution {
    private static void dfs(int node, int vis[], Stack<Integer> st,
            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0)
                dfs(it, vis, st, adj);
        }
        st.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
}
public class tUf {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);


        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = Solution.topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}

INPUT:
V = 4, E = 3

OUTPUT:
3, 2, 1, 0
