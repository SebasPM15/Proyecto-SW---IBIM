package GestionUsuarios;

public interface IListaComprador {
    
    boolean existeComprador(Comprador comprador);
    
    void addComprador(Comprador comprador);
    
    Comprador obtenerComprador(int indice);
    
    void mostrarListaComprador();
}
