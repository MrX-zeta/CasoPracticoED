import java.util.InputMismatchException;
import java.util.Scanner;

public class Pago {
    protected Double monto;

    public Pago() {
        this.monto = 0.0;
    }

    public Pago(Double monto) {
        this.monto = monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    public Double getMonto() {
        return monto;
    }

    public boolean procesarPago() {
        Scanner sc = new Scanner(System.in);
        try {
            int cantidad = 0;
            boolean cantidadValida = false;
            
            while (!cantidadValida) {
                try {
                    System.out.println("Ingrese la cantidad de productos a pagar: ");
                    cantidad = sc.nextInt();
                    sc.nextLine();
                    
                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser mayor a 0. Intente de nuevo.");
                    } else {
                        cantidadValida = true;
                    }
                    
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    sc.nextLine();
                }
            }

            Producto productos[] = new Producto[cantidad];
            Double montoTotal = 0.0;

            for (int i = 0; i < productos.length; i++) {
                System.out.println("Producto " + (i + 1) + ":");
                System.out.println("Ingrese el nombre del producto: ");
                String nombreP = sc.nextLine();

                Double montoP = null;
                boolean montoValido = false;
                
                while (!montoValido) {
                    try {
                        System.out.println("Ingrese el monto del producto: ");
                        montoP = sc.nextDouble();
                        sc.nextLine();
                        
                        if (montoP < 0) {
                            System.out.println("El monto no puede ser negativo. Intente de nuevo.");
                        } else {
                            montoValido = true;
                        }
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un número válido.");
                        sc.nextLine();
                    }
                }
                
                productos[i] = new Producto(nombreP, montoP);
                montoTotal += montoP;
            }

            this.setMonto(montoTotal);
            
            System.out.println("\nTotal a pagar: $" + montoTotal);
            
            int opcion;
            boolean opcionValida = false;
            
            while (!opcionValida) {
                try {
                    System.out.println("Ingrese una opcion valida para el metodo de pago: ");
                    System.out.println("1. Tarjeta");
                    System.out.println("2. Efectivo");
                    System.out.println("3. Mixto");
                    System.out.println("4. Salir");
                    opcion = sc.nextInt();
                    sc.nextLine();
                    
                    if (opcion >= 1 && opcion <= 4) {
                        opcionValida = true;
                        
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese su numero de tarjeta: ");
                                String NoTarjeta = sc.nextLine();
                                while (NoTarjeta.length() != 16) {
                                    System.out.println("El número debe tener exactamente 16 dígitos. Intente de nuevo: ");
                                    NoTarjeta = sc.nextLine();
                                }

                                System.out.println("Ingrese el banco: ");
                                String banco = sc.nextLine();

                                Tarjeta tarjeta = new Tarjeta(NoTarjeta, banco);
                                tarjeta.setMonto(montoTotal);
                                tarjeta.procesarPagoTarjeta();
                                break;
                            case 2:
                                Efectivo efectivo = new Efectivo(montoTotal);
                                efectivo.procesarPagoEfectivo();
                                break;
                            case 3:
                                PagoMixto pagoMixto = new PagoMixto(montoTotal);
                                pagoMixto.procesarPagoMixto();
                                break;
                            case 4:
                                System.out.println("Operación cancelada");
                                return false;
                        }
                    } else {
                        System.out.println("Por favor, ingrese un número entre 1 y 4.");
                    }
                    
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    sc.nextLine();
                }
            }
            return true;
            
        } catch (InputMismatchException e) {
            System.out.println("Ingrese una opcion valida: ");
            return false;
        } finally {
            sc.close();
        }
    }
}