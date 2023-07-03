package GestionUsuarios;

import GestionCompraVenta.ListaProductos;

public interface IComprador {
    
    void realizarPago(String nombreProducto, ListaProductos producto, int indice);
    
    void solicitarServiTec();
    
    String iniciarSesion(String ingreso);
    
    @Override
    String toString();
}
