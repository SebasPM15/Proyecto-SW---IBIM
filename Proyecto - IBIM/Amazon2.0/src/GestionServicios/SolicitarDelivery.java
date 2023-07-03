package GestionServicios;

import GestionCompraVenta.Producto;
import GestionUsuarios.Vendedor;
import java.time.LocalDate;
import java.util.UUID;

public class SolicitarDelivery implements ISolicitarDelivery
{
    private Vendedor vendedor;
    private Producto producto;
    private LocalDate fecha;
    private String nombre;
    private boolean disponibilidad;

    public SolicitarDelivery() {
    }

    public SolicitarDelivery(String nombre) {
        this.nombre = nombre;
    }
    
    public SolicitarDelivery(Vendedor vendedor, Producto producto, LocalDate fecha) {
        this.vendedor = vendedor;
        this.producto = producto;
        this.fecha = fecha;
    }   
    
    @Override
    public void generarTicketDelivery() {

        String numeroTicket = UUID.randomUUID().toString();    
        System.out.println("Ticket de Delivery: "+numeroTicket);
        System.out.println("Vendedor: " + vendedor.getNombre());
        System.out.println("Producto: " + producto.getNombreProd());
        System.out.println("Fecha: " + fecha);
    } 
    
    public String getNombre() 
    {
        return nombre;
    }

}
