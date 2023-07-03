package GestionUsuarios;

import GestionCompraVenta.Comprobante;
import GestionCompraVenta.ListaProductos;
import GestionCompraVenta.Venta;

public interface IVendedor {
    
    void gestionarVenta(ListaComprador listaComprador, ListaProductos listaProducto, int indiceCom, int indiceProd);

    Comprobante generarComprobante(Venta venta);
 
    void selecDelivery(ListaProductos prod, int indice);
    
    String iniciarSesion(String ingreso);

    @Override
    String toString();
}
