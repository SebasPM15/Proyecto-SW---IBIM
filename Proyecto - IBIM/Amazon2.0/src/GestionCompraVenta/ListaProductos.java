package GestionCompraVenta;

import java.util.ArrayList;

public class ListaProductos implements IListaProductos
{
    private ArrayList <Producto> listaProd;
    //Constructores

    public ListaProductos() 
    {
        this.listaProd = new ArrayList<Producto>();
    }

    public ListaProductos(ArrayList<Producto> listaProd) {
        this.listaProd = listaProd;
    }
    
    @Override
    public boolean existeProducto(Producto producto) 
    {
        // Verificar si el producto ya está en la lista
        for (Producto p: listaProd) 
        {
            if (p.getNombreProd().equals(producto.getNombreProd())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void addProducto(Producto producto)
    {
        if (existeProducto(producto)) {
            System.out.println("El producto ya existe en el sistema.");
        } else
        {
            listaProd.add(producto);
            System.out.println("Producto agregado correctamente!");
        }
    }
    

    
    @Override
    public ArrayList<Producto> buscarProducto(String nombre)
    {
        ArrayList<Producto> resultados = new ArrayList<>();
        for(Producto aux: listaProd)
        {
            if(aux.getNombreProd().equalsIgnoreCase(nombre))
            {
                resultados.add(aux);
            }
        }
        return resultados;
    }
    
    @Override
    public Producto obtenerProdBus(int indice)
    {
        if(indice>=0 && indice < listaProd.size())
        {
            return listaProd.get(indice);
        } else
        {
            return null;
        }
    }
    
    @Override
    public void mostrarListaProd()
    {
        for(int i=0; i<listaProd.size();i++)
        {
            Producto producto = listaProd.get(i);
            System.out.println((i+1)+". "+producto.getNombreProd());
        }
    }
    
    //Getters and setters
    public void setListaProd(ArrayList<Producto> listaProd) {    
        this.listaProd = listaProd;
    }

    public ArrayList<Producto> getListaProd() {
        return listaProd;
    }
        
    @Override
    public String toString() 
    {
        String salida="";
        for(Producto aux: listaProd)
        {
            salida += aux.getNombreProd() + " \n ";
        }
        return salida;
    }
    
}
