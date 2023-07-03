package GestionUsuarios;

import GestionCompraVenta.ListaProductos;
import GestionServicios.ServicioTecnico;
import GestionServicios.IServicioTecnico;

public class Comprador extends Persona implements IComprador
{
    private String tipoIngreso;
    private String metodoPago; 
    private IServicioTecnico solicitarST;
    //Agregamos los constructores
    public Comprador() 
    {
    }

    public Comprador(String metodoPago, String nombre, String direcc) {
        super(nombre, direcc);
        solicitarST = new ServicioTecnico();
        this.metodoPago = metodoPago;
    }
    
    public Comprador(String tipoIngreso, String metodoPago, String nombre, String direcc) {
        super(nombre, direcc);
        this.tipoIngreso = tipoIngreso;
        this.metodoPago = metodoPago;
    }
    
    //Implementamos el método abstracto de la superclase Persona
    @Override
    public String iniciarSesion(String ingreso) 
    {
        return this.tipoIngreso = ingreso;
    }
       
    @Override
    public void realizarPago(String nombreProducto, ListaProductos producto, int indice)
    {
        producto.getListaProd().get(indice).actualizarStock();
        System.out.println("Realizando pago del producto "+nombreProducto+" con un valor de "+producto.getListaProd().get(indice).getPrecio()+" $");
        try {
            Thread.sleep(2000); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Pago realizado con EXITO!!");
        System.out.println(" ------------------------------ ");
    }
       
    @Override
    public void solicitarServiTec()
    {
        solicitarST.solicitarServicioTecnico();
    }
    
    //Agregamos los getters and setters
    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "\n----- > Datos del comprador: \n"
                +super.toString()
                +"\nMetodo de pago:" + metodoPago;
    }
    
    
}
