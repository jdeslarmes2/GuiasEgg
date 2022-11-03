
package entidades;

/**
 *
 * @author jdeslarmes
 */
public class Televisor extends Electrodomestico{
    
    private int pulgadas;
    private boolean tdt;
    

    
    public Televisor() {
    }

    public Televisor(int pulgadas, boolean tdt, Double precio, String color, char consumoEnergetico, int peso) {
        super(precio, color, consumoEnergetico, peso);
        this.pulgadas = pulgadas;
        this.tdt = tdt;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }
    
    public void crearTelevisor(){
        System.out.println("");
        System.out.println("-----------------Creando Televisor------------");
        System.out.println("");

        super.crearElectrodomestico();
        System.out.println("Ingrese las pulgadas de la TV: ");
        this.setPulgadas(leer.nextInt());
        System.out.println("Ingerese si la tv tiene sintonozador TDT (true o false): ");
        this.setTdt(leer.nextBoolean());
        

    }
    
    public void precioFinal(){
        
        super.precioFinal();
        if (this.getPulgadas()>40){
            this.setPrecio(this.getPrecio()+(this.getPrecio()*0.3));
        }if ( this.isTdt() == true){
            this.setPrecio(this.getPrecio()+ 500);
        }

    }
}
