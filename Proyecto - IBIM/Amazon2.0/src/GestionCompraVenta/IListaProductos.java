package GestionCompraVenta;

import java.util.ArrayList;

public interface IListaProductos {
    
    boolean existeProducto(Producto producto);
    
    void addProducto(Producto producto);

    ArrayList<Producto> buscarProducto(String nombre);
    
    Producto obtenerProdBus(int indice);
    
    void mostrarListaProd();
        
    @Override
    String toString();
}
