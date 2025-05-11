1.QUESTION: Given an undirected graph with n vertices and m edges, your task is to determine if a Hamiltonian path exists in the graph.

AIM:
To design and implement an algorithm to determine the existence of a Hamiltonian Path in a given undirected graph using backtracking.

ALGORITHM:
Step 1: Represent the graph using an adjacency list or matrix.
Step 2: Start from each vertex and apply backtracking to find a path that visits all vertices exactly once.
Step 3: Maintain a visited array and path list.
Step 4: At each step, move to an unvisited adjacent vertex and recursively explore further.
Step 5: If the path includes all vertices, return true (Hamiltonian Path found).
Step 6: If no such path is found from any starting vertex, return false.

CODING:
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(ArrayList<Integer> i:Edges){
            list.get(i.get(0)).add(i.get(1));
            list.get(i.get(1)).add(i.get(0));
        }
        for(int i=1;i<=N;i++){
            Set<Integer> vis=new HashSet<>();
            if(!vis.contains(i)){
                if(dfs(i,N,list,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int src,int total,List<List<Integer>> list,Set<Integer> vis){
       
        vis.add(src);
        if(vis.size()==total){
            return true;
        }
        for(Integer nbr:list.get(src)){
            if(!vis.contains(nbr)){
                if(dfs(nbr,total,list,vis)) return true;
            }
        }
        vis.remove(src);
        return false;
    }
}


INPUT:
n = 4, m = 4
edges[][]= { {1,2}, {2,3}, {3,4}, {2,4} }

OUTPUT:
1

2.QUESTION: Given a matrix cost of size n where cost[i][j] denotes the cost of moving from city i to city j. Your task is to complete a tour from city 0 (0-based index) to all other cities such that you visit each city exactly once and then at the end come back to city 0 at minimum cost.

AIM:
To implement a solution using Dynamic Programming with Bitmasking to find the minimum cost Hamiltonian cycle (Travelling Salesman Problem) for a given cost matrix.

ALGORITHM:
Step 1: Let dp[mask][i] be the minimum cost to reach city i after visiting all cities in mask.
Step 2: Initialize dp[1<<0][0] = 0 as starting from city 0.
Step 3: For every state (mask) and city (i), try moving to all unvisited cities (j).
Step 4: Update dp[mask | (1 << j)][j] = min(dp[mask | (1 << j)][j], dp[mask][i] + cost[i][j]).
Step 5: The final answer is min(dp[fullMask][i] + cost[i][0]) for all i, where fullMask = (1 << n) - 1.
Step 6: Return the minimum cost of completing the tour.

CODING:
class Solution {
    int[][] dp;
    int n;
    public int tsp(int[][] cost) {
        this.n = cost.length;
        int size = 1 << n; 
        dp = new int[size][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(1, 0, cost); 
    }
    private int helper(int mask, int pos, int[][] cost) {
        if (mask == (1 << n) - 1) {
            return cost[pos][0]; 
        }
        if (dp[mask][pos] != -1)
            return dp[mask][pos];
        int minCost = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) { 
                int newMask = mask | (1 << city);
                int newCost = cost[pos][city] + helper(newMask, city, cost);
                minCost = Math.min(minCost, newCost);
            }
        }
        return dp[mask][pos] = minCost;
    }
}
INPUT:
cost = [[0, 111], [112, 0]]

OUTPUT:
223
