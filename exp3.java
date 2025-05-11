1.QUESTION : Sort an array of non-negative integers using counting sort.
AIM:
   To sort an array in linear time when the range of elements is small.       
  ALGORITHM:
 Step1: Find the maximum value in the array.
 Step2: Initialize a count array of size max + 1.
 Step3: Count the frequency of each number.
 Step4: Traverse the count array and reconstruct the sorted array.

CODING:
import java.util.*;
public class CountingSort {
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];
        for (int num : arr) count[num]++;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) arr[index++] = i;
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}    
INPUT:
arr = [4, 2, 2, 8, 3, 3, 1].
    OUTPUT:
[1, 2, 2, 3, 3, 4, 8].


2.QUESTION : Sort an array of integers using radix sort.
AIM:
   To sort large integers in linear time using digit-wise sorting.       
  ALGORITHM:
 Step1: Find the maximum number to determine number of digits.
 Step2: For each digit (ones, tens, hundreds, etc.), do counting sort.
 Step3: Start with the least significant digit and move to the most significant.

CODING:
import java.util.*;
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSortByDigit(arr, exp);
    }
    private static void countSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        for (int num : arr) count[(num / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

    INPUT:
arr = [170, 45, 75, 90, 802, 24, 2, 66].
    OUTPUT:
[2, 24, 45, 66, 75, 90, 170, 802].


3.QUESTION : Find the first index at which a number can be inserted to maintain sorted order.
AIM:
   To find the lower bound (first occurrence ≥ key) using binary search.       
  ALGORITHM:
 Step1: Set left = 0, right = arr.length.
 Step2: While left < right, check mid = (left + right)/2.
 Step3: If arr[mid] < key, move left = mid + 1.
 Step4: Else, move right = mid.
 Step5: Return left.

CODING:
import java.util.*;
public class LowerBound {
    public static int lowerBound(int[] arr, int key) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 5, 6};
        int key = 3;
        System.out.println("Lower Bound of " + key + " is at index: " + lowerBound(arr, key));
    }
}
  
    INPUT:
arr = [1, 3, 3, 5, 6], key = 3.

    OUTPUT:
     Lower Bound of 3 is at index: 1.


4.QUESTION : Determine whether counting sort can be applied on a given array.
AIM:
   To check if the array has a small range of values that makes linear sorting feasible.       
  ALGORITHM:
 Step1: Find the min and max of the array.
 Step2: Calculate range = max - min.
 Step3: If range <= array.length, counting sort is feasible.

CODING:
public class LinearTimeSortCheck {
    public static boolean canUseCountingSort(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (max - min) <= arr.length; // Range is small enough
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        System.out.println("Can use Counting Sort: " + canUseCountingSort(arr));
    }
}    

    INPUT:
    arr = [1, 3, 2, 5, 4].

    OUTPUT:
    Can use Counting Sort: true.


5.QUESTION : Write a program to perform preorder traversal of a binary tree.
AIM:
   To visit the root node first, then traverse the left and right subtrees recursively.       
  ALGORITHM:
 Step1: Visit the root node.
 Step2: Traverse the left subtree.
 Step3: Traverse the right subtree.

CODING:
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}public class PreorderTraversal {
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.print("Preorder Traversal: ");
        preorder(root);
    }
}
    INPUT:
        1
       / \
      2   3
     / \
    4   5
    OUTPUT:
Preorder Traversal: 1 2 4 5 3.


6.QUESTION : Write a program to perform inorder traversal of a binary tree.
AIM:
  To traverse the left subtree first, then visit the root, and finally the right subtree.       
  ALGORITHM:
 Step1: Traverse the left subtree.
 Step2: Visit the root node.
 Step3: Traverse the right subtree.

CODING:
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
public class InorderTraversal {
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}

    INPUT:
        1
       / \
      2   3
     / \
    4   5
    OUTPUT:

     Inorder Traversal: 4 2 5 1 3.

7.QUESTION : Write a program to perform postorder traversal of a binary tree.
AIM:
   To traverse the left and right subtrees first, then visit the root node.       
  ALGORITHM:
Step1: Traverse the left subtree.
Step2: Traverse the right subtree.
Step3: Visit the root node.

CODING:
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
public class PostorderTraversal {
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Postorder Traversal: ");
        postorder(root);
    }
}

    INPUT:
        1
       / \
      2   3
     / \
    4   5
    OUTPUT:
Postorder Traversal: 4 5 2 3 1.

8.QUESTION : Write a Java program to implement a Min Heap using a priority queue and perform basic operations like insertion and extraction of the minimum element..
AIM:
  To implement a Min Heap, where the parent node is less than or equal to its children.       
  ALGORITHM:
 Step1: Insert elements one by one.
 Step2: After each insertion, heapify up to maintain the min-heap property.
 Step3: In extractMin(), remove the root and replace with the last element, then heapify down.
CODING:
import java.util.PriorityQueue;
public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(30);
        minHeap.add(2);
        System.out.println("Min Heap: " + minHeap);
        System.out.println("Extract Min: " + minHeap.poll()); // Removes 2
        System.out.println("After Extraction: " + minHeap);
    }
}  
    INPUT:
Insert: 10, 5, 30, 2.

    OUTPUT:
Min Heap: [2, 5, 30, 10]
Extract Min: 2
After Extraction: [5, 10, 30].

9.QUESTION : Write a Java program to implement a Max Heap using a priority queue and extract the maximum element..
AIM:
   To implement a Max Heap, where the parent node is greater than or equal to its children.       
  ALGORITHM:
 Step1: Use a PriorityQueue with a custom comparator to reverse natural order.
 Step2: Insert elements.
 Step3: Always the maximum element stays at the top.

CODING:
import java.util.Collections;
import java.util.PriorityQueue;
public class MaxHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(30);
        maxHeap.add(2);
        System.out.println("Max Heap: " + maxHeap);
        System.out.println("Extract Max: " + maxHeap.poll()); // Removes 30
        System.out.println("After Extraction: " + maxHeap);
    }
} 

   INPUT:
Insert: 10, 5, 30, 2.

    OUTPUT:
Max Heap: [30, 10, 5, 2]
Extract Max: 30
After Extraction: [10, 2, 5].

