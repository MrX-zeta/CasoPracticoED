public class Efectivo extends Pago {
    
    public Efectivo(Double monto) {
        super(monto);
    }
    
    public void procesarPagoEfectivo() {
        System.out.println("Procesando pago en efectivo por: $" + this.getMonto());
    }
}
