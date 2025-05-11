1.QUESTION: Find Prime Factorisation of a Number using Sieve.
AIM:
To find the prime factorization of a number efficiently using the Sieve method.

ALGORITHM:
Step1:  Create an empty list to store prime factors.
Step2:   Loop i from 2 to √N and check if i divides N.
Step3:   While i divides N, add i to the list and divide N by i.
Step4:    After the loop, if N is not 1, add N itself to the list (it’s prime).
Step5:    Return the list of prime factors.

CODING:

class Solution {
    
    static void sieve() {}

    static List<Integer> findPrimeFactors(int N) {

        List<Integer> l = new ArrayList();
        int[] arr =new int[N+1];
        for(int i=2; i*i<=N; i++){
            while(N%i==0){
                l.add(i);
                N=N/i;
            }
        }
        if(N!=1){
            l.add(N);
        }
        return l;
        
    }
}


INPUT: 
N = 12246
OUTPUT: 
2 3 13 157



2.QUESTION: Find GCD and LCM of Two Numbers Using Euclid’s Algorithm.

AIM: 
Write a Java program to find GDC and LCM of Two numbers using Euclid’s algorithm.

ALGORITHM:
Step1:  Input two numbers A and B.
Step2:  Store original A and B for LCM calculation.
Step3:  Find GCD using Euclidean Algorithm: while B ≠ 0, set A = B and B = A % B.
Step4:  GCD is now A; calculate LCM = (original A × original B) / GCD.
Step5:  Output GCD and LCM.

CODING:
class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        int gcd = gcd(a,b);
        int lcm=(a*b)/gcd;
        return new int[] {lcm,gcd};
    }
      private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

INPUT :
a = 7, b = 5

OUTPUT :
[35, 1]
 

3.QUESTION: Write a program to perform modular arithmetic operations: addition, subtraction, multiplication, and modular inverse using the Extended Euclidean Algorithm.

AIM: 
To implement a java program that performs basic modular arithmetic operations (addition, subtraction, multiplication) and calculates the modular inverse using Euclid’s Extended Algorithm.

ALGORITHM:
Step1:  Take inputs a, b, and m for the arithmetic operations.
Step2:  Perform and output modular addition, subtraction,multiplication using the formulas(a + b) % m,(a - b)%m,(a * b)% m.
Step3:  For the modular inverse, use the Extended Euclidean Algorithm to find the GCD of a and m.
Step4:  If GCD is 1, calculate and output the modular inverse (result[1] + m) % m.
Step5:  Display the results of all operations.

CODING:
import java.util.Scanner;
public class ModularArithmetic {
    public static int modularAdd(int a, int b, int m) {
        return (a + b) % m;
    }
    public static int modularSubtract(int a, int b, int m) {
        return (a - b + m) % m;
    }
    public static int modularMultiply(int a, int b, int m) {
        return (a * b) % m;
    }
    public static int modularInverse(int a, int m) {
        int[] result = extendedGCD(a, m);
        int gcd = result[0];
        if (gcd != 1) {
            System.out.println("Inverse does not exist");
            return -1;
        } else {
            // Ensure the result is positive
            return (result[1] + m) % m;
        }
    }
    private static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[] {a, 1, 0}; 
        }
        int[] temp = extendedGCD(b, a % b);
        int gcd = temp[0];
        int x = temp[2];


        int y = temp[1] - (a / b) * temp[2];
        return new int[] {gcd, x, y};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number (a): ");
        int a = scanner.nextInt();      
        System.out.println("Enter second number (b): ");
        int b = scanner.nextInt();
        System.out.println("Enter modulus (m): ");
        int m = scanner.nextInt();
        System.out.println("Modular Addition (a + b) % m = " + modularAdd(a, b, m));
        System.out.println("Modular Subtraction (a - b) % m = " + modularSubtract(a, b, m));
        System.out.println("Modular Multiplication (a * b) % m = " + modularMultiply(a, b, m));
        int inverse = modularInverse(a, m);
        if (inverse != -1) {
            System.out.println("Modular Inverse of a mod m = " + inverse);
        }
        scanner.close();
    }
}


INPUT:
Enter first number (a): 7
Enter second number (b): 3
Enter modulus (m): 11
OUTPUT:
Modular Addition (a + b) % m = 10
Modular Subtraction (a - b) % m = 4
Modular Multiplication (a * b) % m = 10
Modular Inverse of a mod m = 8



4.QUESTION: Given an integer n, return the number of prime numbers that are strictly less than n.

AIM:
To count the number of prime numbers less than a given integer n using the Sieve of Eratosthenes algorithm.

ALGORITHM:
Step1: If n <= 2, return 0 because there are no primes less than 2.
Step2: Create a boolean array isPrime where each index represents a number, initialized as true.
Step3: Implement the Sieve of Eratosthenes: For each prime i, mark all its multiples as false.
Step4: After marking, iterate through the isPrime array to count all true values.
Step5: Return the count of prime numbers.

CODING:

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}

INPUT: n = 10
OUTPUT: 4


5.QUESTION: Checks whether the i-th bit of a given integer is set (1) or not set (0) using bitwise operations

AIM:
To implement a Java program that checks whether the i-th bit (starting from the least significant bit) of a given integer is set  (1) or not set (0) using bitwise operations.

ALGORITHM:
Step 1: Start the program and take two integer inputs from the user-the number n and the bit position i.
Step 2: Right-shift the number n by i positions using n >> i.
Step 3: Perform a bitwise AND operation between the result and 1 i.e., (n >> i) & 1.
Step 4: If the result is 1, then the i-th bit is set (1); otherwise, it is not set (0).
Step 5: Display the result to the user.
Step 6: End the program.

CODING:

import java.util.Scanner;
public class BitCheck {
    public static boolean isBitSet(int number, int i) {
        return ((number >> i) & 1) == 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        System.out.print("Enter the bit position to check (0 for LSB): ");
        int i = scanner.nextInt();
        if (isBitSet(number, i)) {
            System.out.println("The " + i + "-th bit is set (1).");
        } else {
            System.out.println("The " + i + "-th bit is not set (0).");
        }
        scanner.close();
    }
}
INPUT:
Enter an integer: 42
Enter the bit position to check (0 for LSB): 3
OUTPUT:
The 3-th bit is set (1).


6.QUESTION: check whether a given number is odd or not using bitwise operation.

AIM:
To Write a Java program to check whether a given number is odd or not using bitwise operation.

ALGORITHM:
Step 1: Start the program.
Step 2: Take an integer input n from the user.
Step 3: Perform a bitwise AND operation between n and 1 using the expression n & 1.
Step 4: If the result is 1, then the number is odd.If the result is 0, then the number is even.
Step 5: Display the result to the user.
Step 6: End the program.

CODING:
import java.util.Scanner;
public class OddCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if ((num & 1) == 1) {
            System.out.println(num + " is an odd number.");
        } else {
            System.out.println(num + " is not an odd number.");
        }

        sc.close();
    }
}

INPUT:
Enter a number: 7
OUTPUT:
7 is an odd number.


7.QUESTION : Given an integer n, return true if it is a power of two. Otherwise, return false. An integer n is a power of two, if there exists an integer x such that n == 2x.

AIM:
To write a Java program to check whether a given integer is a power of two using bitwise operations and return true if it is, otherwise return false.

ALGORITHM:
Step 1: Start the program.
Step 2: Take an integer input n from the user.
Step 3: Check if n is greater than 0.
Step 4: Perform bitwise operation using the expression n & (n - 1).
Step 5: If the result is 0, then n is a power of two; otherwise, it is not.
Step 6: Display the result and end the program.

CODING:
class Solution {
    public boolean isPowerOfTwo(int n) {
        
        return (n>0&&(n&(n-1))==0);}
}

 INPUT:  
 n = 16
 OUTPUT:  
 true


8.QUESTION : Write a Java program to count the number of set bits (1s) in the binary representation of a given integer using bitwise operations.

AIM:
To write a Java program that counts the number of set bits (bits with value 1) in the binary representation of a given integer using bitwise operations.

ALGORITHM:
Step 1: Start the program.
Step 2: Take an integer input n from the user.
Step 3: Initialize a counter variable count to 0.
Step 4: Repeat the following steps while n is not equal to 0,Perform n & 1 to check the least significant bit, If it is 1, increment count, Right shift n by 1 using n = n >> 1.
Step 5: Display the value of count as the number of set bits.
Step 6: End the program.

CODING:
import java.util.Scanner;
public class SetBitsCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        System.out.println("Number of set bits: " + count);
        sc.close();
    }
}
INPUT:
Enter an integer: 13
OUTPUT:
Number of set bits: 3


9.QUESTION : Write a Java program to set the rightmost unset bit of a given integer using bitwise operations.

AIM:
To write a Java program that sets the rightmost unset bit (i.e., the 0 that occurs first from the right in binary) of a given integer using bitwise operations.

ALGORITHM:
Step 1: Start the program.
Step 2: Take an integer input n from the user.
Step 3: Compute the result using the expression: n | (n + 1)
Step 4: Display the result.
Step 5: End the program.

CODING:
import java.util.Scanner;
public class SetRightmostUnsetBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        int result = n | (n + 1);
        System.out.println("Result after setting rightmost unset bit: " + result);
        sc.close();
    }
}

INPUT:
Enter an integer: 18

OUTPUT:
Result after setting rightmost unset bit: 19


10.QUESTION: Write a Java program to swap two numbers using bitwise XOR operation (without using a temporary variable).

AIM:
To write a Java program to swap two integers using the XOR bitwise operator, without using a third variable.

ALGORITHM:
Step 1: Start the program.
Step 2: Take two integer inputs a and b from the user.
Step 3: Swap the values using XOR: a = a ^ b, b = a ^ b, a = a ^ b
Step 4: Display the values after swapping.
Step 5: End the program.


CODING:
import java.util.Scanner;
public class SwapUsingBitwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number (a): ");
        int a = sc.nextInt();
        System.out.print("Enter second number (b): ");
        int b = sc.nextInt();
        System.out.println("Before Swapping: a = " + a + ", b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After Swapping: a = " + a + ", b = " + b);
        sc.close();
    }
}

INPUT:
Enter first number (a): 5  
Enter second number (b): 7

OUTPUT:
Before Swapping: a = 5, b = 7  
After Swapping: a = 7, b = 5


11.QUESTION: Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

AIM:
To implement integer division by repeatedly subtracting the divisor from the dividend using loops and bitwise operations, without using multiplication, division, or modulo operators.

ALGORITHM:
Step 1: Take two integer inputs: dividend and divisor.11
Step 2: Handle edge cases such as division by zero or overflow.
Step 3: Convert both numbers to their absolute values and determine the result sign (positive or negative).
Step 4: Initialize quotient as 0.Use left-shifting to subtract the largest multiple of the divisor from the dividend.
Step 5: Accumulate the multiple values in quotient.
Step 6: Apply the sign to the result and return the final quotient.

CODING:
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; 
        }
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int quotient = 0;
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;  
                multiple <<= 1;     
            }
            absDividend -= tempDivisor;
            quotient += multiple;  
        }
        if ((dividend < 0) ^ (divisor < 0)) {
            quotient = -quotient;
        }
        return quotient;
    }
}

INPUT: dividend = 10, divisor = 3
OUTPUT: 3


