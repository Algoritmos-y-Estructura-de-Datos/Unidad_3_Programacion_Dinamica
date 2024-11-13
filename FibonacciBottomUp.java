
// Implentado por: Vinicio Changoluisa
// Diciembre 2023

package PD_Basico;

public class FibonacciBottomUp {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci de " + n + ": " + fibonacci(n));
    }
}


