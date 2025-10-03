public class Producto {
    private String nombre;
    private int monto;

    public Producto(String nombre, int monto){
        this.nombre = nombre;
        this.monto = monto;
    }

    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){return nombre;}

    public void setMonto(int monto){this.monto = monto;}
    public int getMonto(){return monto;}

}
