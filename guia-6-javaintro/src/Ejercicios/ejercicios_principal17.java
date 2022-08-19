/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introJava_ejercicios_principales;

/**
 *
 * @author Usuario
 */
public class ejercicios_principal17 {

    /**
     Recorrer un vector de N enteros contabilizando cuántos números son de 1 dígito, cuántos
de 2 dígitos, etcétera (hasta 5 dígitos).
     */
    public static void main(String[] args) {
       int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0;
               
       int[] vector = new int [20];
       for (int i = 0 ; i < 20; i++){
           vector[i] = (int) (Math.random()*99999);
           System.out.print("[" + vector[i] + "]");
           
       }
       System.out.println("");
      for (int i = 0; i < 20; i++){
       int largo = String.valueOf(vector[i]).length();
          switch (largo) {
              case 1:
                  cont1++;
                  break;
              case 2:
                  cont2++;
                  break;
              case 3:
                  cont3++;
                  break;
              case 4:
                  cont4++;
                  break;
              case 5:
                  cont5++;
                  break;      
              default:
                  throw new AssertionError();
          }
         
      }
        System.out.println("Se encontraron " + cont1 + " números con 1 cifras");
        System.out.println("Se encontraron " + cont2 + " números con 2 cifras");
        System.out.println("Se encontraron " + cont3 + " números con 3 cifras");
        System.out.println("Se encontraron " + cont4 + " números con 4 cifras");
        System.out.println("Se encontraron " + cont5 + " números con 5 cifras");
        
    }
    
}
