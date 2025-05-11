1.QUESTION: Two players, P1 (First) and P2 (Second), are playing a game with a starting number of stones n. They play optimally, and P1 always starts first. The rules of the game are: In a single move, a player can remove either 2, 3, or 5 stones. The player who cannot make a move loses. Given the number of stones n, determine who will win the game if both players play optimally.

AIM:
To determine the winner of the game based on the optimal moves by each player using dynamic programming and the principles of combinatorial game theory.

ALGORITHM:
Step 1: Initialize a boolean array dp[0...n] to store winning/losing states.
Step 2: Set dp[0] = false as no stones means the current player loses.
Step 3: Loop i from 1 to n.
Step 4: Set dp[i] = true if any of dp[i−2], dp[i−3], or dp[i−5] is false.
Step 5: If dp[n] is true, print "First"; else, print "Second".

CODING:
import java.util.*;
public class GameOfStones {
    public static String gameOfStones(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        for (int i = 1; i <= n; i++) {
            if (i >= 2 && !dp[i - 2]) dp[i] = true;
            else if (i >= 3 && !dp[i - 3]) dp[i] = true;
            else if (i >= 5 && !dp[i - 5]) dp[i] = true;
            else dp[i] = false;
        }
        return dp[n] ? "First" : "Second";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while (t-- > 0) {
            int n = sc.nextInt(); 
            System.out.println(gameOfStones(n));
        }
        sc.close();
    }
}

INPUT:
4 1 2 3 7

OUTPUT:
Second
First
First
Second
