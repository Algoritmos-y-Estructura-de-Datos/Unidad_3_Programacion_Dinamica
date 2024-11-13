


// Implentado por: Vinicio Changoluisa
// Diciembre 2023


package PD_Basico;
import java.util.Arrays;

public class Fibonacci_TopDown_arrays{

    static long[] memo;

    public static long fibonacci(int n) {
        if (n <= 1) 
            return n;
        
        if (memo[n] != -1) 
            return memo[n];

        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10; 
        memo = new long[n + 1];
        Arrays.fill(memo, -1); //rellena de -1 el array

        long result = fibonacci(n);
        System.out.println("Fibonacci de " + n + ": " + result);
    }
}

