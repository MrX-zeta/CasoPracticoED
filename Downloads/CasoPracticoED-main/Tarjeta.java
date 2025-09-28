public class Tarjeta extends Pago {
    private String noTarjeta;
    private String banco;

    public Tarjeta(String noTarjeta, String banco) {
        super();
        this.noTarjeta = noTarjeta;
        this.banco = banco;
    }

    public Tarjeta(String noTarjeta, String banco, Double monto) {
        super(monto);
        this.noTarjeta = noTarjeta;
        this.banco = banco;
    }

    public void setNoTarjeta(String noTarjeta) {
        if (noTarjeta == null || String.valueOf(noTarjeta).length() != 16) {
        System.out.println("El número de tarjeta debe tener exactamente 16 dígitos.");
        return;
    }
    this.noTarjeta = noTarjeta;
    }
    
    public String getNoTarjeta() {
        return noTarjeta;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    
    public String getBanco() {
        return banco;
    }
    
    public void procesarPagoTarjeta() {
        System.out.println("Procesando pago con tarjeta: " + this.noTarjeta 
                         + " del banco: " + this.banco 
                         + " por: $" + this.getMonto());
    }
}
