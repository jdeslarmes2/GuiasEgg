package principal.dominio.departamento;


public class Departamento {
    
    private int id_depto;
    private String nombre_depto;
    private String ciudad;
    private String codigo_director;

    public Departamento() {
    }

    public Departamento(int id_depto, String nombre_depto, String ciudad, String codigo_director) {
        this.id_depto = id_depto;
        this.nombre_depto = nombre_depto;
        this.ciudad = ciudad;
        this.codigo_director = codigo_director;
    }

    public int getId_depto() {
        return id_depto;
    }

    public void setId_depto(int id_depto) {
        this.id_depto = id_depto;
    }

    public String getNombre_depto() {
        return nombre_depto;
    }

    public void setNombre_depto(String nombre_depto) {
        this.nombre_depto = nombre_depto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_director() {
        return codigo_director;
    }

    public void setCodigo_director(String codigo_director) {
        this.codigo_director = codigo_director;
    }
    
    
    
    
}
