package GestionCompraVenta;

public class MetodoPago implements IMetodoPago
{
    @Override
    public void realizarPago(String metodoPago) {
        if (metodoPago.equalsIgnoreCase("tarjeta")) {
            // Lógica para procesar el pago con tarjeta
            System.out.println("Procesando pago con tarjeta...");
            // Verificar la validez de la tarjeta, realizar el cargo, etc.
        } else if (metodoPago.equalsIgnoreCase("efectivo")) {
            // Lógica para procesar el pago en efectivo
            System.out.println("Aceptando pago en efectivo...");
            // Realizar la transacción en efectivo, entregar el cambio, etc.
        } else {
            System.out.println("Método de pago inválido. Por favor, elija una opción válida.");
        }
    }
}
