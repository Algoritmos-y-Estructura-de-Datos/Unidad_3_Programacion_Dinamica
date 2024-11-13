
// Implentado por: Vinicio Changoluisa
// Diciembre 2023

package Problemas_clasicos;

public class Mochila {
    
    // Solución recursiva
    public static int mochilaRecursiva(int[] valores, int[] pesos, int capacidad, int n) {
        // Caso base: si la capacidad o el número de elementos es 0, el valor es 0
        if (n == 0 || capacidad == 0) {
            return 0;
        }
        
        // Si el peso del último elemento excede la capacidad, no se puede incluir
        if (pesos[n - 1] > capacidad) {
            return mochilaRecursiva(valores, pesos, capacidad, n - 1);
        }
        
        // Devolver el máximo entre incluir el elemento y no incluirlo
        return Math.max(valores[n - 1] + mochilaRecursiva(valores, pesos, capacidad - pesos[n - 1], n - 1),
                        mochilaRecursiva(valores, pesos, capacidad, n - 1));
    }
    
    // Solución con enfoque bottom-up (programación dinámica)
    public static int mochilaBottomUp(int[] valores, int[] pesos, int capacidad) {
        int n = valores.length;
        int[][] dp = new int[n + 1][capacidad + 1];
        
        // Llenar la tabla bottom-up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][capacidad];
    }
    
    // Solución con enfoque top-down (memoización)
    public static int mochilaTopDown(int[] valores, int[] pesos, int capacidad) {
        int n = valores.length;
        Integer[][] memo = new Integer[n + 1][capacidad + 1];
        return mochilaTopDownRecursivo(valores, pesos, capacidad, n, memo);
    }
    
    private static int mochilaTopDownRecursivo(int[] valores, int[] pesos, int capacidad, int n, Integer[][] memo) {
        if (n == 0 || capacidad == 0) {
            return 0;
        }
        if (memo[n][capacidad] != null) {
            return memo[n][capacidad];
        }
        if (pesos[n - 1] > capacidad) {
            memo[n][capacidad] = mochilaTopDownRecursivo(valores, pesos, capacidad, n - 1, memo);
        } else {
            memo[n][capacidad] = Math.max(valores[n - 1] + mochilaTopDownRecursivo(valores, pesos, capacidad - pesos[n - 1], n - 1, memo),
                                          mochilaTopDownRecursivo(valores, pesos, capacidad, n - 1, memo));
        }
        return memo[n][capacidad];
    }
    
    public static void main(String[] args) {
        int[] valores = {60, 100, 120};
        int[] pesos = {10, 20, 30};
        int capacidad = 50;
        
        System.out.println("El valor máximo que se puede obtener es: \" (Recursivo): " + mochilaRecursiva(valores, pesos, capacidad, valores.length));
        System.out.println("El valor máximo que se puede obtener es: \" (Bottom-Up): " + mochilaBottomUp(valores, pesos, capacidad));
        System.out.println("El valor máximo que se puede obtener es: \" (Top-Down): " + mochilaTopDown(valores, pesos, capacidad));
    }
}
