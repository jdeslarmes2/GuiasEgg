/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.triangulo;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class trianguloServicio {

    Scanner leer = new Scanner(System.in);
    triangulo tr = new triangulo();
    
    
    public triangulo crearTriangulo(){

        System.out.println("Ingrese la base del triangulo en cm: ");
        Double base = leer.nextDouble();
        System.out.println("Ingrese la altura del triangulo en cm: ");
        Double altura = leer.nextDouble();
        Double area = (altura*base)/2;
        System.out.println(area);
        return new triangulo (base, altura, area);
        
    }

    public void calcularArea(triangulo t1){
        
        System.out.println("El área de su triangulo isoceles es: "+t1.getArea()+" cm2");

    }
       
    public void calcularPerimetro(triangulo t1){
        
        Double ladoIgual = Math.sqrt(Math.pow(t1.getAltura(), 2) + Math.pow(t1.getBase()/4, 2) );
        Double perimetro = 2 * ladoIgual + t1.getBase();
        System.out.println("El perimetro del triangulo es: "+ perimetro + " cms");

    }
    
    public void mostrarSuperficieMáxima(triangulo t1, triangulo t2, triangulo t3, triangulo t4){
        
        double [] areas = {t1.getArea(), t2.getArea(), t3.getArea(), t4.getArea()};
        double areaMax = 0;
        for(int i=0; i < 4; i++){
            if (areas[i]>areaMax){
                areaMax = areas[i];
            }
        }
        System.out.println("El área máxima del triangulo es: "+areaMax);       
        System.out.println("Area de triángulo 1: "+t1.getArea());
        System.out.println("Área del triangulo 2: "+t2.getArea());
        System.out.println("Area de triángulo 3: "+t3.getArea());
        System.out.println("Área del triangulo 4: "+t4.getArea());

        
    }
}
