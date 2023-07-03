package GestionUsuarios;

import GestionCompraVenta.Comprobante;
import GestionCompraVenta.ListaProductos;
import GestionCompraVenta.Producto;
import GestionCompraVenta.IProducto;
import GestionServicios.SolicitarDelivery;
import GestionServicios.ISolicitarDelivery;
import GestionCompraVenta.IVenta;
import GestionCompraVenta.Venta;
import java.time.LocalDate;

public class Vendedor extends Persona implements IVendedor
{
    private IProducto producto;
    private String tipoIngreso;

    // Constructor
    public Vendedor() {
    }

    public Vendedor(String nombre, String direcc) {
        super(nombre, direcc);
    }

    // Métodos adicionales
    
    @Override
    public void gestionarVenta(ListaComprador listaComprador, ListaProductos listaProducto, int indiceCom, int indiceProd) 
    {
        Comprador comprador = listaComprador.getListaComp().get(indiceCom);
        producto = listaProducto.getListaProd().get(indiceProd);
        IVenta venta = new Venta(this, comprador, (Producto) producto);
        System.out.println(venta.toString());
    }

    @Override
    public Comprobante generarComprobante(Venta venta) {
        // Lógica para generar un comprobante
        return new Comprobante(venta);
    }
 
    @Override
    public void selecDelivery(ListaProductos prod, int indice)
    {
        LocalDate fechaAct = LocalDate.now();
        Producto prodSec = prod.getListaProd().get(indice);
        ISolicitarDelivery selec = new SolicitarDelivery(this, prodSec, fechaAct);
        selec.generarTicketDelivery();
    }
    
    @Override
    public String iniciarSesion(String ingreso) 
    {
        return this.tipoIngreso = ingreso;
    }

    @Override
    public String toString() 
    {
        return "\n-----> Detalles del Vendedor:\n"
                +super.toString();
                
    }
    
    
}
