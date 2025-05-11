
1.QUESTION: You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.

AIM:
To implement an efficient algorithm to check whether each type of fruit can be placed into a basket such that no basket overflows its capacity and each basket is used for only one type of fruit.

ALGORITHM:
Step 1: Sort the fruits array in descending order.
Step 2: Sort the baskets array in descending order.
Step 3: Traverse both arrays; for each i, check if fruits[i] ≤ baskets[i].
Step 4: If any fruits[i] > baskets[i], return "Not Possible"; otherwise, return "Possible".

CODING:
class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int ans = 0;

        for(int i = 0; i < f.length; i++) {
            for(int j = 0; j < b.length; j++) {
                if(f[i] <= b[j]){
                    b[j] = 0;
                    ans++;
                    break;
                }
            }
        }
        return f.length - ans;
    }
}

INPUT:
fruits = [4,2,5], baskets = [3,5,4]

OUTPUT:
1

