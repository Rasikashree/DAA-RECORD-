1.QUESTION : Find the factorial of a number using recursion.
AIM:
   To compute the factorial of a number n using a recursive function.

  ALGORITHM:
 Step1: If n is 0 or 1, return 1.
 Step2: Else return n * factorial(n - 1). 
 Step3: Use recursive calls to break the problem.
 Step4: Return the result to the caller.
 Step5: Print the final factorial value.

CODING:
public class RecursionExamples 
{
    public static int factorial(int n) 
    {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}

    INPUT:
     n = 5.

    OUTPUT:
     Factorial of 5 is 120

2.QUESTION : Find the nth Fibonacci number using recursion.
AIM:
   To find the nth Fibonacci number using a recursive function.

  ALGORITHM:
 Step 1: If n is 0, return 0.
 Step 2: If n is 1, return 1.
 Step 3: Else return fibonacci(n-1) + fibonacci(n-2).
 Step 4: Use recursion to break the problem into smaller subproblems.
 Step 5: Return the final result.

CODING:
public class RecursionExamples 
{
    public static int fibonacci(int n) 
    {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}   

   INPUT:
    n = 6.

   OUTPUT:
    Fibonacci of 6 is 8


3.QUESTION : Solve the Tower of Hanoi problem using recursion.

AIM:
To move n disks from the source rod to the destination rod using recursion and divide-and-conquer strategy. 
      
  ALGORITHM:
 Step 1: Move n-1 disks from source to helper.
 Step 2: Move the nth disk from source to destination.
 Step 3: Move n-1 disks from helper to destination.
 Step 4: Use recursion to repeat the process for smaller n.
 Step 5: Print each move.

CODING:
public class RecursionExamples {
    public static void towerOfHanoi(int n, char source, char helper, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, helper); // Step 1
        System.out.println("Move disk " + n + " from " + source + " to " + destination); // Step 2
        towerOfHanoi(n - 1, helper, source, destination); // Step 3
    }
}   

    INPUT:
     n = 3 (source = A, helper = B, destination = C).
    OUTPUT:
	Move disk 1 from A to C  
Move disk 2 from A to B  
Move disk 1 from C to B  
Move disk 3 from A to C  
Move disk 1 from B to A  
Move disk 2 from B to C  
Move disk 1 from A to C  


4.QUESTION : Sort an array using the merge sort algorithm.
AIM:
   To sort elements by dividing the array and merging them in sorted order using the merge sort algorithm.  
     
  ALGORITHM:
 Step1: Divide the array into two halves recursively.
 Step2: Sort each half using merge sort.
 Step3: Merge the sorted halves into one sorted array.
 Step4: Repeat until the full array is sorted.
 Step5: Return the sorted array.

CODING:
public class MergeSort {
    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public static void merge(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) merged[k++] = arr[i++];
            else merged[k++] = arr[j++];
        }
        while (i <= mid) merged[k++] = arr[i++];
        while (j <= end) merged[k++] = arr[j++];
        for (int l = 0; l < merged.length; l++) arr[start + l] = merged[l];
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) System.out.print(num + " ");
    }
}    

    INPUT:
    arr = [6, 3, 9, 5, 2, 8].

    OUTPUT:
     Sorted array: [2, 3, 5, 6, 8, 9]. 


5.QUESTION : Sort an array using the merge sort algorithm.
AIM:
  To sort elements by dividing the array and merging them in sorted order using the merge sort algorithm.       
  ALGORITHM:
 Step1: Choose a pivot element.
 Step2: Partition the array such that elements < pivot go left, > pivot go right.
 Step3: Recursively apply quick sort on left and right subarrays.
 Step4: Combine the sorted partitions.
 Step5: Return the sorted array.

CODING:
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) System.out.print(num + " ");
    }
}

    INPUT:
    arr = [7, 2, 1, 6, 8, 5, 3, 4].
    OUTPUT:
    Sorted array: [1, 2, 3, 4, 5, 6, 7, 8]. 

6.QUESTION : Find the closest pair of points from a given set of 2D points using divide and conquer.
AIM:
  To compute the smallest distance between two points in a plane using an efficient divide and conquer algorithm.       
  ALGORITHM:
 Step1: Sort all points by X-coordinate.
 Step2: Recursively divide points into left and right halves.
 Step3: Find the closest pair in each half.
 Step4: Check for closer points across the split line (within strip).
 Step5: Return the minimum of the three cases.

CODING:
import java.util.*;
public class ClosestPair {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
    public static double closestPair(Point[] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        return closestUtil(points, 0, points.length - 1);
    }
    static double closestUtil(Point[] pts, int left, int right) {
        if (right - left <= 3) return bruteForce(pts, left, right);
        int mid = (left + right) / 2;
        double dl = closestUtil(pts, left, mid);
        double dr = closestUtil(pts, mid + 1, right);
        double d = Math.min(dl, dr);
        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++)
            if (Math.abs(pts[i].x - pts[mid].x) < d)
                strip.add(pts[i]);
        strip.sort(Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < d; j++) {
                d = Math.min(d, distance(strip.get(i), strip.get(j)));
            }
        }
        return d;
    }
    static double bruteForce(Point[] pts, int left, int right) {
        double min = Double.MAX_VALUE;
        for (int i = left; i <= right; i++)
            for (int j = i + 1; j <= right; j++)


                min = Math.min(min, distance(pts[i], pts[j]));
        return min;
    }
    static double distance(Point p1, Point p2) {
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }
    public static void main(String[] args) {
        Point[] points = {
            new Point(2, 3),
            new Point(12, 30),
            new Point(40, 50),
            new Point(5, 1),
            new Point(12, 10),
            new Point(3, 4)
        };
        System.out.printf("Closest distance: %.3f\n", closestPair(points));
    }
}

    INPUT:
    Points = [(2, 3), (12, 30), (40, 50), (5, 1), (12, 10), (3, 4)].
    OUTPUT:
Closest distance: 1.414
Closest pair: (2, 3) and (3, 4). 


7.QUESTION : Place N queens on an N×N chessboard such that no two queens threaten each other.
AIM:
   To solve the N-Queens problem using backtracking and display one of the possible arrangements.       
  ALGORITHM:
 Step1: Place queens row by row starting from row 0.
 Step2: For each row, try placing a queen in every column.
 Step3: Check if the position is safe (no attacks from previously placed queens).
 Step4: If safe, place the queen and move to the next row recursively.
 Step5: Backtrack if no column is safe in the current row.

CODING:
public class NQueens {
    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) java.util.Arrays.fill(row, '.');
        placeQueens(board, 0);
    }
    public static boolean placeQueens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return true; // Return false if you want all solutions
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                if (placeQueens(board, row + 1)) return true;
                board[row][col] = '.'; // backtrack
            }
        }
        return false;
    }
    public static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int N = 4;
        solveNQueens(N);
    }
}


    INPUT:
     N = 4.
    OUTPUT:
Q . . .  
. . Q .  
. . . Q  
. Q . .  


8.QUESTION : Fill a 9×9 Sudoku board so that each row, column, and 3×3 subgrid contains all digits 1 to 9 without repetition.
AIM:
   To solve a partially-filled Sudoku puzzle using backtracking.       
  ALGORITHM:
 Step1: Traverse each cell of the board.
 Step2: If the cell is empty, try placing numbers 1 to 9.
 Step3: Check if placing the number is valid.
 Step4: If valid, recursively try to solve the rest of the board.
 Step5: Backtrack if no number leads to a solution.

CODING:
public class SudokuSolver {
    public static boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (solveSudoku(board)) return true;
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c || board[row][i] == c) return false;
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == c) return false;
        }
        return true;
    }
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        if (solveSudoku(board)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}

    INPUT:
	    A 9×9 board with some pre-filled digits and '.' for empty cells.

    OUTPUT:
    The completed Sudoku board.  


9.QUESTION : Sort an array of integers using Insertion Sort technique.
AIM:
To sort an array by inserting each element into its correct position in the sorted part of the array using decrease and conquer strategy.       
  ALGORITHM:
 Step1: Start from the second element (index 1) in the array.
 Step2: Store the current element in a variable.
 Step3: Compare it with elements to its left (sorted part) and shift larger elements one position to the right.
 Step4: Insert the current element at the correct position.
 Step5: Repeat until the end of the array.

CODING:
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        insertionSort(arr);
        for (int num : arr) System.out.print(num + " ");
    }
}

    INPUT:
An array of integers:
arr = {5, 2, 9, 1, 5, 6}.

    OUTPUT:
Sorted array:
1 2 5 5 6 9.  


10.QUESTION :  Count the frequency of each element in an array.
AIM:
   To demonstrate how hashing can be used to store and retrieve element frequencies efficiently.       
  ALGORITHM:
 Step1: Create an empty hash map.
 Step2: Traverse the array.
 Step3: For each element, increment its count in the map.
 Step4: After the loop, print each key-value pair.

CODING:
import java.util.*;
public class HashingExample {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 3, 5, 2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
}    
    INPUT:
arr = [2, 3, 2, 3, 5, 2].

    OUTPUT:
2 -> 3  
3 -> 2  
5 -> 1  


11.QUESTION : Generate all permutations of a given string.
AIM:
   To recursively generate all permutations using backtracking.       
  ALGORITHM:
 Step1: If the input string is empty, print the answer.
 Step2: Loop through the string.
 Step3: Pick each character and fix it.
 Step4: Recurse with the remaining characters.
 Step5: Backtrack to explore other options.

CODING:
public class Permutations {
    public static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permute(ros, ans + ch);
        }
    }
    public static void main(String[] args) {
        permute("ABC", "");
    }
}
    INPUT:
str = "ABC".

    OUTPUT:
ABC  
ACB  
BAC  
BCA  
CAB  
     CBA


12.QUESTION : Find number of combinations of n items taken r at a time.
AIM:
   To compute nCr using recursion.       
  ALGORITHM:
 Step1: If r == 0 or r == n, return 1.
 Step2: Recursively calculate nCr = (n-1)C(r-1) + (n-1)Cr.
 Step3: Return the result.

CODING:
public class Combinations {
    public static int nCr(int n, int r) {
        if (r == 0 || r == n) return 1;
        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
    public static void main(String[] args) {
        System.out.println("5C2 = " + nCr(5, 2));
    }
}

    INPUT:
n = 5, r = 2.
    OUTPUT:
     5C2 = 10.

13.QUESTION : Print all subsequences of a given string.
AIM:
   To generate all subsequences of a string using recursion.       
  ALGORITHM:
 Step1: If string is empty, print current answer.
 Step2: Recurse by excluding first character.
 Step3: Recurse by including first character.
 Step4: Continue until all characters are processed.

CODING:
public class Subsequences {
    public static void generateSubsequences(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        generateSubsequences(str.substring(1), ans);       
        generateSubsequences(str.substring(1), ans + str.charAt(0)); 
    }
    public static void main(String[] args) {
        generateSubsequences("abc", "");
    }
}
    
    INPUT:
str = "abc".
    OUTPUT:
(empty)  
c  
b  
bc  
a  
ac  
ab  
abc.


14.QUESTION : Generate all subsets of a given integer array.
AIM:
   To generate power set (all subsets) using recursion and backtracking.       
  ALGORITHM:
 Step1: If index == array length, print current subset.
 Step2: Recurse without including current element.
 Step3: Include current element, recurse, then backtrack.

CODING:
import java.util.*;
public class Subsets {
    public static void findSubsets(int[] arr, List<Integer> current, int index) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }
        findSubsets(arr, current, index + 1);
        current.add(arr[index]);
        findSubsets(arr, current, index + 1);
        current.remove(current.size() - 1); // backtrack
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        findSubsets(arr, new ArrayList<>(), 0);
    }
}    
    INPUT:
arr = [1, 2, 3].
    OUTPUT:
[ ]  
[3]  
[2]  
[2, 3]  
[1]  
[1, 3]  
[1, 2]  
[1, 2, 3].
