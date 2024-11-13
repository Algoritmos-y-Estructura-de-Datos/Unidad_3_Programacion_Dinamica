
// Implentado por: Vinicio Changoluisa
// Diciembre 2023

package Problemas_clasicos;

public class MinCoinsChange_recursivo {

    public static int cambioMinimo(int[] monedas, int monto) {
        
        if (monto == 0) // Caso base: Si el monto es 0, no se necesitan monedas
            return 0;
        

        int resultado = Integer.MAX_VALUE;

        // Probar cada moneda
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] <= monto) {
                int subproblema = cambioMinimo(monedas, monto - monedas[i]);
                // Actualizar el resultado si se encuentra un nuevo mínimo
                if (subproblema != Integer.MAX_VALUE && subproblema + 1 < resultado) 
                    resultado = subproblema + 1;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] monedas = {1, 5, 10, 25}; // Denominaciones de monedas disponibles
        int monto = 63; // Monto para el cual queremos devolver el cambio

        int resultado = cambioMinimo(monedas, monto);

        System.out.println("Número mínimo de monedas para devolver el cambio: " + resultado);
    }
}
