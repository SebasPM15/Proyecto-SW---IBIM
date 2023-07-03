package GestionCompraVenta;

import GestionUsuarios.Vendedor;
import GestionUsuarios.ListaComprador;

public class Comprobante implements IComprobante
{
private Venta venta;
    
    // Constructor
    public Comprobante() {
    }

    public Comprobante(Venta venta) {
        this.venta = venta;
    }

    // Getter y Setter para venta
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    // Método generarComprobante
    @Override
    public void generarComprobante(Vendedor vendedor, ListaComprador comprador, ListaProductos producto, int indComp, int indProd) 
    {
        // Generar el comprobante
        System.out.println("Vendedor: " + vendedor.getNombre());
        System.out.println("Comprador: " + comprador.getListaComp().get(indComp).getNombre());
        System.out.println("Producto: " + producto.getListaProd().get(indProd).getNombreProd());
        System.out.println("Detalles del producto: "+producto.getListaProd().get(indProd).getDescrip());
    }   
}
