public class Producto {
    private String nombre;
    private Double monto;

    public Producto(String nombre, Double monto){
        this.nombre = nombre;
        this.monto = monto;
    }

    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){return nombre;}

    public void setMonto(Double monto){this.monto = monto;}
    public Double getMonto(){return monto;}

}
