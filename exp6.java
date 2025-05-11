1.QUESTION: Given n items with weights w[i] and values v[i], and a knapsack capacity W, find the maximum value that can be put in a knapsack of capacity W.

AIM:
To implement the 0/1 Knapsack Problem using Dynamic Programming approaches: Memoization and Tabulation.

ALGORITHM:
Step 1: Initialize a 2D DP table dp[n+1][W+1] to store maximum values.
Step 2: Iterate over items (i from 1 to n) and weights (j from 1 to W).
Step 3: If w[i-1] <= j, then take dp[i][j] = max(dp[i-1][j], val[i-1] + dp[i-1][j - wt[i-1]]).
Step 4: Else, dp[i][j] = dp[i-1][j].
Step 5: Return dp[n][W].

CODING:
public class Knapsack {
    public static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {10, 40, 50, 70};
        int W = 8;
        System.out.println("Maximum value: " + knapsack(wt, val, W, wt.length));
    }
}

INPUT:
Weights = [1, 3, 4, 5]
Values = [10, 40, 50, 70]
Capacity = 8

OUTPUT:
Maximum value: 110


2.QUESTION: Given a directed graph, find the transitive closure using Warshall’s Algorithm.

AIM:
To determine the transitive closure of a graph using Warshall’s Algorithm.

ALGORITHM:
Step 1: Input adjacency matrix of graph.
Step 2: For each intermediate vertex k, update path[i][j] = path[i][j] || (path[i][k] && path[k][j]).

CODING:
public class Warshall {
    static int V = 4;
    void transitiveClosure(int[][] graph) {
        int[][] reach = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                reach[i][j] = graph[i][j];
        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    reach[i][j] = (reach[i][j] != 0 || (reach[i][k] != 0 && reach[k][j] != 0)) ? 1 : 0;
        System.out.println("Transitive closure:");
        for (int i = 0; i < V; i++, System.out.println())
            for (int j = 0; j < V; j++)
                System.out.print(reach[i][j] + " ");
    }
    public static void main(String[] args) {
        int[][] graph = {
            {1, 1, 0, 1},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {0, 0, 0, 1}
        };
        new Warshall().transitiveClosure(graph);
    }
}

INPUT:
V=4

OUTPUT:
Transitive closure:
1 1 1 1
0 1 1 1
0 0 1 1
0 0 0 1


3.QUESTION: Given a weighted directed graph, find the shortest paths between all pairs of vertices.

AIM:
To implement Floyd-Warshall’s algorithm to find the shortest distance between all pairs of nodes.

ALGORITHM:
Step 1: Initialize dist[i][j] = weight[i][j] if there’s an edge, or ∞ otherwise.
Step 2: For each intermediate k, update dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]).

CODING:
public class FloydWarshall {
    final static int INF = 99999, V = 4;
    void floyd(int[][] graph) {
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
        System.out.println("Shortest distances:");
        for (int i = 0; i < V; i++, System.out.println())
            for (int j = 0; j < V; j++)
                System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + " ");
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };
        new FloydWarshall().floyd(graph);
    }
}

INPUT:
INF = 99999, V = 4;

OUTPUT:
Shortest distances:
0 5 8 9 
INF 0 3 4 
INF INF 0 1 
INF INF INF 0

