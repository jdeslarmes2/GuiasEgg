

package tienda.jdbc.entidades;

import tienda.jdbc.entidades.Fabricante;



/**
 *
 * @author jdeslarmes
 */
public class Producto {
    
    private int codigo;
    private String nombre;
    private double precio;
    private int codigo_fabricante;
    private Fabricante fabricante;  //Cada producto tiene un fabricante, tengo una relación

    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int codigo_fabricante, Fabricante fabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_fabricante = codigo_fabricante;
        this.fabricante = fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", codigo_fabricante=" + codigo_fabricante + ", fabricante=" + fabricante + '}';
    }

    

    
}
