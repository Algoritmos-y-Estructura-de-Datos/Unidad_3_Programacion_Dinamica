
// Implentado por: Vinicio Changoluisa
// Diciembre 2023

package Problemas_clasicos;

public class MinCoinsChange {
    public static int minCoins(int[] denominations, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++)  // Inicializar la tabla
            dp[i] = Integer.MAX_VALUE;
        
        for (int coin : denominations) 
            for (int i = coin; i <= amount; i++) 
                if (dp[i - coin] != Integer.MAX_VALUE) 
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
   
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] denominations = {1, 5, 10, 21, 25};
        int amount = 63;

        int result = minCoins(denominations, amount);

        if (result != -1) 
            System.out.println("Cantidad mínima de monedas: " + result);
        else 
            System.out.println("No es posible dar cambio exacto.");
        
    }
}


