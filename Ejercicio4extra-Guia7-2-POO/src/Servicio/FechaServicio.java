/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidades.Fecha;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class FechaServicio {

    Scanner leer = new Scanner(System.in);
    Fecha f1 = new Fecha();

    public Fecha crearFecha() {

        System.out.println("Ingrese el día: ");
        int dia = leer.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = leer.nextInt();
        System.out.println("Ingrese el año: ");
        int ano = leer.nextInt();

        return new Fecha(dia, mes, ano);

    }

    public void verificarAno(Fecha f1) {

        if (f1.getAno() > 2021 || f1.getAno() < 1900) {
            f1.setAno(1900);
            System.out.println("Su año es igual a: " + f1.getAno());
        } else {
            System.out.println("Su año es igual a: " + f1.getAno());
        }

    }

    public void verificarDias(Fecha f1) {

        switch (f1.getMes() - 1) {

            case 0:
                System.out.println("Tiene 31 días");
                break;
            case 1:
                System.out.println("Tiene 28 días");
                break;
            case 2:
                System.out.println("Tiene 31 días");
                break;
            case 3:
                System.out.println("Tiene 30 días");
                break;
            case 4:
                System.out.println("Tiene 31 días");
                break;
            case 5:
                System.out.println("Tiene 30 días");
                break;
            case 6:
                System.out.println("Tiene 31 días");
                break;
            case 7:
                System.out.println("Tiene 31 días");
                break;
            case 8:
                System.out.println("Tiene 30 días");
                break;
            case 9:
                System.out.println("Tiene 31 días");
                break;
            case 10:
                System.out.println("Tiene 30 días");
                break;
            case 11:
                System.out.println("Tiene 31 días");
                break;

        }

    }

    public void mostrarDiaAnterior(Fecha f1) {

        if (f1.getDia() > 1 && f1.getDia() <= 31) {

            String[] mes = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

            System.out.println("El día anterior es: " + (f1.getDia() - 1) + " del mes de: " + mes[f1.getMes() - 1]);
        }
        if (f1.getDia() == 1) {
            System.out.print("El día anterior es: ");
            switch (f1.getMes() - 1) {

                case 0:
                    System.out.println("31 de Dieciembre");
                    break;
                case 1:
                    System.out.println("31 de Enero");
                    break;
                case 2:
                    System.out.println("28 de Febrero");
                    break;
                case 3:
                    System.out.println("31 de Marzo");
                    break;
                case 4:
                    System.out.println("30 de Abril");
                    break;
                case 5:
                    System.out.println("31 de Mayo");
                    break;
                case 6:
                    System.out.println("30 de Junio");
                    break;
                case 7:
                    System.out.println("31 de Julio");
                    break;
                case 8:
                    System.out.println("31 de Agosto");
                    break;
                case 9:
                    System.out.println("30 de Septiembre");
                    break;
                case 10:
                    System.out.println("31 de Octubre");
                    break;
                case 11:
                    System.out.println("30 de Noviembre");
                    break;

            }

        }
    }
    
        public void mostrarDiaPosterior(Fecha f1) {
        
            String[] mes = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        if (f1.getDia() < 31) {

            System.out.println("El día posterior es: " + (f1.getDia() + 1) + " del mes de: " + mes[f1.getMes() - 1]);
        }

        if (f1.getDia() == 31) {
            if (f1.getMes()==12){
             System.out.println("El día anterior es 1 "+ " del mes de: " + mes[0]);
            } else {

            System.out.println("El día anterior es 1 "+ " del mes de: " + mes[f1.getMes()]);

            }
        }
        }
        
        public void verificarBisiesto(Fecha f1) {
        
        if (f1.getAno() % 4 == 0){
            System.out.println("El año es bisiesto");
        } else {
            System.out.println("El año no es bisiesto");
        }    
            
    }
    
    
    
    
    
    
}
