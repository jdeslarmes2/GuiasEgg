
package EjerciciosPrincipales;

public class Ejercicio18 {

    /**
     * Realizar un programa que rellene un matriz de 4 x 4 de valores 
     * aleatorios y muestre la traspuesta de la matriz. La matriz traspuesta 
     * de una matriz A se denota por B y se obtiene cambiando sus filas 
     * por columnas (o viceversa).
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int max = 10, min = 1;
        int[][] matriz = new int[4][4]; 
        for (int j = 0 ; j < 4; j++) {
    
            for (int i = 0 ; i < 4; i++){
            matriz[j][i] = (int) (Math.random()*(max-min) + min);
            System.out.print("[" + matriz[j][i] + "]");
            }
            System.out.println("");
        }
        System.out.println("===========");
        for (int j = 0 ; j < 4; j++) {
            for (int i = 0 ; i < 4; i++){
            System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
    }
}