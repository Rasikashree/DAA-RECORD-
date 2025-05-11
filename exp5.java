1.QUESTION: Find the Minimum Spanning Tree starting from any vertex.

AIM: To implement Prim’s Algorithm using the Greedy method to find the Minimum Spanning Tree (MST) of a connected, undirected, and weighted graph.

ALGORITHM:
Step 1: Initialize a min-heap and a visited set.
Step 2: Start from any node and push all adjacent edges to the heap.
Step 3: Always pick the minimum weight edge from the heap.
Step 4: If the edge leads to an unvisited node, add it to MST and mark visited.
Step 5: Repeat until all nodes are included in the MST.

CODING:
import java.util.*;
class PrimMST {
    static class Pair {
        int vertex, weight;
        Pair(int v, int w) {
            vertex = v;
            weight = w;
        }
    }
    public static void primsAlgo(int V, List<List<Pair>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(0, 0));
        int totalWeight = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (visited[curr.vertex]) continue;
            visited[curr.vertex] = true;
            totalWeight += curr.weight;
            for (Pair edge : adj.get(curr.vertex)) {
                if (!visited[edge.vertex]) {
                    pq.add(new Pair(edge.vertex, edge.weight));
                }
            }
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(1, 3));
        adj.get(0).add(new Pair(3, 6));
        adj.get(3).add(new Pair(0, 6));
        adj.get(1).add(new Pair(3, 8));
        adj.get(3).add(new Pair(1, 8));
        adj.get(1).add(new Pair(4, 5));
        adj.get(4).add(new Pair(1, 5));
        primsAlgo(V, adj);
    }
}

INPUT:
Number of vertices = 5
Edges[] = [[0,1,1],[0,3,3],[1,3,3],[1,2,2],[2,3,4],[2,4,4],[3,4,5]]

OUTPUT:
Total Weight of MST: 10

2.QUESTION: Build MST by choosing the smallest weight edges first.

AIM:
To implement Kruskal’s Algorithm using the Greedy method to construct the Minimum Spanning Tree (MST) of a graph by selecting the shortest possible edges while avoiding cycles.

ALGORITHM:
Step 1: Sort all edges in increasing order of weight.
Step 2: Initialize Disjoint Set (Union-Find) for all vertices.
Step 3: For each edge (u, v), if u and v are in different sets, add it to MST.
Step 4: Merge the sets of u and v.
Step 5: Repeat until MST has (V - 1) edges.

CODING:
import java.util.*;
class KruskalMST {
    static class Edge implements Comparable<Edge> {
        int u, v, weight;
        Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.weight = w;
        }
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
    static int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    static void union(int[] parent, int x, int y) {
        int parX = find(parent, x);
        int parY = find(parent, y);
        parent[parX] = parY;
    }
    public static void main(String[] args) {
        int V = 5;
        Edge[] edges = {
            new Edge(0, 1, 2),
            new Edge(1, 2, 3),
            new Edge(0, 3, 6),
            new Edge(1, 3, 8),
            new Edge(1, 4, 5)
        };
        Arrays.sort(edges);
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int totalWeight = 0;
        for (Edge e : edges) {
            if (find(parent, e.u) != find(parent, e.v)) {
                totalWeight += e.weight;
                union(parent, e.u, e.v);
            }

        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
}

INPUT:
Number of vertices = 5
Edges[] = [[0,1,1],[0,3,3],[1,3,3],[1,2,2],[2,3,4],[2,4,4],[3,4,5]]

OUTPUT:
Total Weight of MST: 10

3.QUESTION: Find the shortest path from a source vertex to all other vertices.

AIM:
To implement Dijkstra’s Algorithm using the Greedy method to find the shortest path from a given source vertex to all other vertices in a weighted graph with non-negative edge weights.

ALGORITHM:
Step 1: Set all distances to infinity, source to 0.
Step 2: Use a priority queue (min-heap) to pick the vertex with the smallest distance.
Step 3: For the current node, update the distance of all unvisited neighbors.
Step 4: If a shorter path is found, update and push it to the queue.
Step 5: Repeat until all nodes are processed.

CODING:
import java.util.*;
class Dijkstra {
    static class Pair {
        int vertex, weight;
        Pair(int v, int w) {
            vertex = v; weight = w;
        }
    }
    public static void dijkstra(int V, List<List<Pair>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for (Pair neighbor : adj.get(curr.vertex)) {
                if (dist[curr.vertex] + neighbor.weight < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = dist[curr.vertex] + neighbor.weight;
                    pq.add(new Pair(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " -> " + dist[i]);
        }
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Pair(1, 10));
        adj.get(0).add(new Pair(4, 5));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(4, 2));
        adj.get(2).add(new Pair(3, 4));
        adj.get(3).add(new Pair(2, 6));




        adj.get(4).add(new Pair(1, 3));
        adj.get(4).add(new Pair(2, 9));
        adj.get(4).add(new Pair(3, 2));
        dijkstra(V, adj, 0);
    }
}

INPUT:
Number of vertices = 5
Edge[] = [[0,1],[0,3],[1,2],[3,1],[3,4],[2,4]]
Source vertex = 0

OUTPUT:
Shortest distances from node 0:
Node 0 : 0
Node 1 : 2
Node 2 : 5
Node 3 : 1
Node 4 : 7

4.QUESTION: Generate prefix codes for a given set of characters and their corresponding frequencies.

AIM:
To implement Huffman Coding using the Greedy Algorithm to achieve efficient data compression by assigning variable-length codes to input characters based on their frequencies.

ALGORITHM:
Step 1: Create a min-heap and insert all characters with their frequencies.
Step 2: While there is more than one node in the heap: Remove two nodes with the smallest frequencies.
Step 3: Repeat until one node remains (the root of the Huffman Tree).
Step 4: Traverse the tree to assign binary codes to each character: Left edge = '0', Right edge = '1'.
Step 5: Print the Huffman codes for each character.

CODING:
import java.util.*;
class HuffmanNode {
    int data;
    char c;
    HuffmanNode left, right;
}
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}
public class HuffmanCoding {
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ": " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charFreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }
        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';


            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }
        System.out.println("Huffman Codes are:");
        printCode(root, "");
    }
}

INPUT:
Characters: a, b, c, d, e, f
Frequencies: 5, 9, 12, 13, 16, 45

OUTPUT:
Huffman Codes are:
f: 0
c: 100
d: 101
a: 1100
b: 1101
e: 111
