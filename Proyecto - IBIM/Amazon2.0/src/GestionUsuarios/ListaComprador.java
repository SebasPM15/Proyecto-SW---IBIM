package GestionUsuarios;

import java.util.ArrayList;


public class ListaComprador implements IListaComprador
{
    private ArrayList <Comprador> listaComp;
    
    //Constructores
    public ListaComprador() {
        this.listaComp = new ArrayList<Comprador>();
    }

    public ListaComprador(ArrayList<Comprador> listaComp) {
        this.listaComp = listaComp;
    }
    
    //Metodos
    @Override
    public boolean existeComprador(Comprador comprador) 
    {
        // Verificar si el producto ya está en la lista
        for (Comprador aux: listaComp) 
        {
            if (aux.getNombre().equals(comprador.getNombre())) {
                return true;
            }
        }
        return false;
    }    
    
    @Override
    public void addComprador(Comprador comprador)
    {
        if(existeComprador(comprador))
        {
            System.out.println("Este comprador ya está registrado en el sistema!");
        } else
        {
            listaComp.add(comprador);
            System.out.println("Comprador agregado a la lista!!");
        }
    }
    
    @Override
    public Comprador obtenerComprador(int indice)
    {
        if(indice>=0 && indice < listaComp.size())
        {
            return listaComp.get(indice);
        } else
        {
            return null;
        }
    }
    
    @Override
    public void mostrarListaComprador()
    {
        for(int i=0; i<listaComp.size();i++)
        {
            Comprador comprador = listaComp.get(i);
            System.out.println((i+1)+". Nombre: "+comprador.getNombre()+" --- Direccion: "+comprador.getDirecc());
        }
    }
    
    //Getters and setters
    public ArrayList<Comprador> getListaComp() {
        return listaComp;
    }

    public void setListaComp(ArrayList<Comprador> listaComp) {
        this.listaComp = listaComp;
    }
    
}
