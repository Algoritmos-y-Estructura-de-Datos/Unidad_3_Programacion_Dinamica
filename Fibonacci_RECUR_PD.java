

// Implentado por: Vinicio Changoluisa
// Diciembre 2023


package PD_Basico;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci_RECUR_PD {

    public static long fibonacciRecursivo(int n) {
        if (n <= 1) 
            return n;
        else 
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
   }

    public static long fibonacciConMemorizacion(int n, Map<Integer, Long> memo) {
        if (n <= 1) 
            return n;
        
        if (memo.containsKey(n)) 
            return memo.get(n);
        
        long resultado = fibonacciConMemorizacion(n - 1, memo) + fibonacciConMemorizacion(n - 2, memo);
        memo.put(n, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        int n = 50; 

        // Medir el tiempo de ejecución para la implementación recursiva
        long inicioRecursivo = System.currentTimeMillis();
        long resultadoRecursivo = fibonacciRecursivo(n);
        long finRecursivo = System.currentTimeMillis();
        System.out.println("Resultado (Recursivo): " + resultadoRecursivo);
        System.out.println("Tiempo de ejecución (Recursivo): " + (finRecursivo - inicioRecursivo) + " ms");

        // Medir el tiempo de ejecución para la implementación con memorización
        long inicioMemorizacion = System.currentTimeMillis();
        Map<Integer, Long> memo = new HashMap<>();
        long resultadoMemorizacion = fibonacciConMemorizacion(n, memo);
        long finMemorizacion = System.currentTimeMillis();
        System.out.println("Resultado (Memorización): " + resultadoMemorizacion);
        System.out.println("Tiempo de ejecución (Memorización): " + (finMemorizacion - inicioMemorizacion) + " ms");
    }
}
