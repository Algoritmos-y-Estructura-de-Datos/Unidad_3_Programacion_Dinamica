

// Implentado por: Vinicio Changoluisa
// Diciembre 2023

package PD_Basico;

import java.util.Arrays;

public class Fibonacci_Time_Eval {

    // Método recursivo
    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Método top-down con memoización
    public static long fibonacciTopDown(int n) {
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return fibonacciTopDownHelper(n, memo);
    }

    private static long fibonacciTopDownHelper(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibonacciTopDownHelper(n - 1, memo) + fibonacciTopDownHelper(n - 2, memo);
        return memo[n];
    }

    // Método bottom-up
    public static long fibonacciBottomUp(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 1000;

        long startTime = System.currentTimeMillis();
        //long resultRecursive = fibonacciRecursive(n);
        long endTime = System.currentTimeMillis();
        //System.out.println("Fibonacci recursivo de " + n + ": " + resultRecursive);
        //System.out.println("Tiempo de ejecución (recursivo): " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        long resultTopDown = fibonacciTopDown(n);
        endTime = System.currentTimeMillis();
        System.out.println("Fibonacci top-down de " + n + ": " + resultTopDown);
        System.out.println("Tiempo de ejecución (top-down): " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        long resultBottomUp = fibonacciBottomUp(n);
        endTime = System.currentTimeMillis();
        System.out.println("Fibonacci bottom-up de " + n + ": " + resultBottomUp);
        System.out.println("Tiempo de ejecución (bottom-up): " + (endTime - startTime) + " ms");
    }
}

