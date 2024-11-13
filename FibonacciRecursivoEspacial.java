

// Implentado por: Vinicio Changoluisa
// Diciembre 2023

package PD_Basico;

public class FibonacciRecursivoEspacial {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 50;  // Ajusta el valor de n según tus necesidades

        // Medir el uso de memoria antes de ejecutar el algoritmo
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Ejecutar el algoritmo
        long result = fibonacci(n);

        // Medir el uso de memoria después de ejecutar el algoritmo
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Imprimir el resultado y el uso de memoria
        System.out.println("Fibonacci de " + n + ": " + result);
        System.out.println("Uso de memoria: " + (memoryAfter - memoryBefore) + " bytes");
    }
}
