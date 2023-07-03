package GestionCompraVenta;

import GestionUsuarios.ListaComprador;
import GestionUsuarios.Vendedor;

public interface IComprobante {

    void generarComprobante(Vendedor vendedor, ListaComprador comprador, ListaProductos producto, int indComp, int indProd);
}
