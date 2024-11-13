


// Implentado por: Vinicio Changoluisa
// Diciembre 2023

package PD_Basico;

import java.util.Arrays;

public class Fibonacci_Spatial_Eval {

    static long[] memoRecursivo;
    static long[] memoTopDown;

    public static long fibonacciRecursivo(int n) {
        if (n <= 1) 
            return n;
        
        if (memoRecursivo[n] != -1) 
            return memoRecursivo[n];
        
        memoRecursivo[n] = fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);

        return memoRecursivo[n];
    }

    public static long espacioRecursivo(int n) {
        return Arrays.stream(memoRecursivo).filter(val -> val != -1).count();
    }

    public static long fibonacciTopDown(int n) {
        if (n <= 1) 
            return n;

        if (memoTopDown[n] != -1) 
            return memoTopDown[n];

        memoTopDown[n] = fibonacciTopDown(n - 1) + fibonacciTopDown(n - 2);

        return memoTopDown[n];
    }

    public static long espacioTopDown(int n) {
        return Arrays.stream(memoTopDown).filter(val -> val != -1).count();
    }

    public static long fibonacciBottomUp(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) 
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    public static long espacioBottomUp(int n) {
        return n + 1; // Complejidad espacial es O(n)
    }

    public static void main(String[] args) {
        int n = 60;

        // Recursivo
        memoRecursivo = new long[n + 1];
        Arrays.fill(memoRecursivo, -1);
        long resultRecursivo = fibonacciRecursivo(n);
        System.out.println("Fibonacci Recursivo de " + n + ": " + resultRecursivo);
        System.out.println("Espacio Recursivo: " + espacioRecursivo(n));

        // Top-Down
        memoTopDown = new long[n + 1];
        Arrays.fill(memoTopDown, -1);
        long resultTopDown = fibonacciTopDown(n);
        System.out.println("Fibonacci Top-Down de " + n + ": " + resultTopDown);
        System.out.println("Espacio Top-Down: " + espacioTopDown(n));

        // Bottom-Up
        long resultBottomUp = fibonacciBottomUp(n);
        System.out.println("Fibonacci Bottom-Up de " + n + ": " + resultBottomUp);
        System.out.println("Espacio Bottom-Up: " + espacioBottomUp(n));
    }
}

