package GestionCompraVenta;

import GestionUsuarios.Vendedor;
import GestionUsuarios.Comprador;

public class Venta implements IVenta
{
    private Vendedor vendedor;
    private Comprador comprador;
    private Producto producto;

    public Venta() {
    }

    public Venta(Vendedor vendedor, Comprador comprador, Producto producto) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.producto = producto;
    }
    
    //Getters and setters
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    //toString
    @Override
    public String toString() {
        return "Detalles de la Venta:\n" 
                +vendedor.toString() + 
                comprador.toString() + 
                producto.toString();
    }
}
