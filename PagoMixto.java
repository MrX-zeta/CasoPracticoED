import java.util.InputMismatchException;
import java.util.Scanner;

public class PagoMixto extends Pago {
    private Double montoTarjeta;
    private Double montoEfectivo;
    private Tarjeta tarjeta;
    private Efectivo efectivo;

    public PagoMixto(Double monto) {
        super(monto);
    }

    public Double getMontoTarjeta() {
        return montoTarjeta;
    }
    
    public Double getMontoEfectivo() {
        return montoEfectivo;
    }
    
    public Tarjeta getTarjeta() {
        return tarjeta;
    }
    
    public Efectivo getEfectivo() {
        return efectivo;
    }
    
    public boolean esValido() {
        return (montoTarjeta != null && montoEfectivo != null && 
                (montoTarjeta + montoEfectivo) == this.getMonto());
    }

    public void procesarPagoMixto() {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Total a pagar: $" + this.getMonto());

            Double montoMixto = null;
            boolean montoValido = false;
            
            while (!montoValido) {
                try {
                    System.out.println("Ingrese la cantidad a pagar con tarjeta (máximo $" + this.getMonto() + "): ");
                    montoMixto = sc.nextDouble();
                    sc.nextLine();
                    
                    if (montoMixto < 0) {
                        System.out.println("El monto debe ser mayor o igual a 0. Intente de nuevo.");
                    } else if (montoMixto > this.getMonto()) {
                        System.out.println("El monto con tarjeta no puede ser mayor al total a pagar. Intente de nuevo.");
                    } else {
                        montoValido = true;
                    }
                    
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    sc.nextLine();
                }
            }
            
            this.montoTarjeta = montoMixto;
            this.montoEfectivo = this.getMonto() - this.montoTarjeta;
            
            System.out.println("Monto con tarjeta: $" + this.montoTarjeta);
            System.out.println("Monto en efectivo: $" + this.montoEfectivo);

            if (this.montoTarjeta > 0) {
                System.out.println("Ingrese su número de tarjeta: ");
                String noTarjeta = sc.nextLine();
                
                System.out.println("Ingrese el nombre del banco: ");
                String banco = sc.nextLine();
                
                this.tarjeta = new Tarjeta(noTarjeta, banco, this.montoTarjeta);
                System.out.println("Pago con tarjeta procesado: $" + this.montoTarjeta);
            }

            if (this.montoEfectivo > 0) {
                this.efectivo = new Efectivo(this.montoEfectivo);
                System.out.println("Pago en efectivo procesado: $" + this.montoEfectivo);
            }
            
            System.out.println("\nPago mixto completado exitosamente.");
            System.out.println("Total pagado: $" + this.getMonto());
            
        } catch (Exception e) {
            System.out.println("Error al procesar el pago mixto: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
    
}
