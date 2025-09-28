public class Tarjeta extends Pago {
    private Long noTarjeta;
    private String banco;

    public Tarjeta(Long noTarjeta, String banco) {
        super();
        this.noTarjeta = noTarjeta;
        this.banco = banco;
    }

    public Tarjeta(Long noTarjeta, String banco, Double monto) {
        super(monto);
        this.noTarjeta = noTarjeta;
        this.banco = banco;
    }

    public void setNoTarjeta(Long noTarjeta) {
        this.noTarjeta = noTarjeta;
    }
    
    public Long getNoTarjeta() {
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
