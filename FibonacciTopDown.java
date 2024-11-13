

// Implentado por: Vinicio Changoluisa
// Diciembre 2023

package PD_Basico;
/***
 * Top-Down (de arriba hacia abajo):

    En este enfoque, se comienza resolviendo el problema principal y luego se descomponen las subproblemas más pequeños a medida que surgen.
    Se utiliza la recursión y la memorización (almacenamiento de resultados intermedios) para evitar recalcular subproblemas ya resueltos.
    Es esencialmente una implementación recursiva con memoización.

Ejemplo en Java (Fibonacci usando top-down):
 * 
 * 
 * ***/

import java.util.HashMap;

public class FibonacciTopDown {
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;

        if (memo.containsKey(n))
            return memo.get(n);

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci de " + n + ": " + fibonacci(n));
    
    long inicioRecursivo = System.currentTimeMillis();
    long resultadoRecursivo = fibonacci(n);
    long finRecursivo = System.currentTimeMillis();
    System.out.println("Resultado (Recursivo): " + resultadoRecursivo);
    System.out.println("Tiempo de ejecución (Recursivo): " + (finRecursivo - inicioRecursivo) + " ms");
    }
}
