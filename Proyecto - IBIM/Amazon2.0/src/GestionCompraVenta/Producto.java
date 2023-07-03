package GestionCompraVenta;

public class Producto implements IProducto
{
    private String nombreProd;
    private String descrip;
    private double precio;
    private int stock;
    
    //Agregamos los constructores
    public Producto() {
    }

    public Producto(String nombreProd, String descrip, double precio, int stock) {
        this.nombreProd = nombreProd;
        this.descrip = descrip;
        this.precio = precio;
        this.stock = stock;
    }
    
    //Método      
    @Override
    public void actualizarStock()
    {
        if(stock>0)
        {
            stock--;
            System.out.println("Stock actualizado: "+ stock);
        } else
        {
            System.out.println("No hay suficiente stock disponible");
        }
    }
    
    //Getters and Setters
    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //toString
    @Override
    public String toString() {
        return "\n-----> Detalles del Producto seleccionado: " 
                +"\nNombre=" + nombreProd + "\nDescripcion=" + descrip + "\nPrecio=" + precio + "\nStock=" + stock;
    }
    
}
