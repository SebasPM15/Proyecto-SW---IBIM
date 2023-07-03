package GestionServicios;

import GestionCompraVenta.MetodoPago;
import GestionCompraVenta.Venta;
import GestionCompraVenta.Producto;
import GestionCompraVenta.Comprobante;
import GestionCompraVenta.IComprobante;
import GestionCompraVenta.IListaProductos;
import GestionCompraVenta.IMetodoPago;
import GestionCompraVenta.IProducto;
import GestionCompraVenta.IVenta;
import GestionUsuarios.Vendedor;
import GestionUsuarios.Comprador;
import GestionUsuarios.ListaComprador;
import GestionCompraVenta.ListaProductos;
import GestionUsuarios.IComprador;
import GestionUsuarios.IListaComprador;
import GestionUsuarios.IVendedor;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) 
    {
        boolean flag = true;
        IListaProductos listaProd = new ListaProductos();
        IListaComprador listaComprador = new ListaComprador();
        IVenta venta = new Venta();
        IComprobante comprobante = new Comprobante();
        IVendedor vendedor = new Vendedor();
        IMetodoPago metPago = new MetodoPago();
        IComprador comprador = new Comprador();
        IProducto producto = new Producto();
        int opcion, stock;
        int indiceSelecProd = -1;
        int indiceSelecComp = -1;
        double precioProd=0.0;
        String buscarProd;
        String ingresar, nombre, metodoPago, dir, nombreProd, descriProd;        
        //Mensaje de Bienvenida e ingreso del usuario 
        do {
            //Declaracion de variables e instanciacion de objetos a utilizar
            Scanner sc = new Scanner(System.in);
            Scanner aux = new Scanner(System.in);
            System.out.println("\n-----------------------------------");
            System.out.println("   *********************   ");
            System.out.println("¡Bienvenido al sistema AMAZON!");
            System.out.println("   *********************   ");
            System.out.println("Ingrese su nombre: ");
            nombre = sc.nextLine();
            System.out.println("Ingrese su direccion: ");
            dir = sc.nextLine();            
            System.out.println("Por favor, ingrese la forma de ingreso (Comprador o Vendedor)");
            ingresar = sc.nextLine();

            if(vendedor.iniciarSesion(ingresar).equalsIgnoreCase("Vendedor"))
            {
                vendedor = new Vendedor(nombre, dir);
                //Creamos el menú
                do {            
                    System.out.println("\nBienvenido a su interfaz de VENTA "+nombre+", puedes escoger entre las siguientes opciones:");
                    System.out.println("1. Agregar un producto");
                    System.out.println("2. Gestionar venta");
                    System.out.println("3. Generar un comprobante de venta");
                    System.out.println("4. Solicitar Delivery con Info guardada!");
                    System.out.println("5. Mostrar lista de productos publicados");
                    System.out.println("6. Salida de la intefaz de VENTA");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("\n ------ AGREGANDO PRODUCTO ------ ");
                            System.out.print("Nombre del producto: ");
                            nombreProd = aux.nextLine();
                            System.out.print("\nDetalles del producto: ");
                            descriProd = aux.nextLine();
                            System.out.print("\nPrecio: ");
                            precioProd = aux.nextDouble();
                            System.out.print("\nStock: ");
                            stock = aux.nextInt();
                            System.out.println(" ---------------------------------");
                            producto = new Producto(nombreProd, descriProd, precioProd, stock);
                            listaProd.addProducto((Producto) producto); //Agregamos el producto a la lista
                            aux.nextLine(); //Limpiamos el buffer
                            break;
                        case 2:
                            System.out.println("\n------LISTA COMPRADORES ------");
                            listaComprador.mostrarListaComprador();
                            System.out.println("Ingrese el indice del comprador de la venta: ");
                            indiceSelecComp = sc.nextInt();
                            sc.nextLine();
                            System.out.println("\n------ GESTIONANDO VENTA ------");
                            try 
                            {
                                vendedor.gestionarVenta((ListaComprador)listaComprador, (ListaProductos)listaProd, indiceSelecComp-1, indiceSelecProd-1);
                                System.out.println("-------------------------------");
                            } catch (Exception e) 
                            {
                                System.out.println("ERROR");
                            }
                            break;
                        case 3:
                            System.out.println("\n------ COMPROBANTE DE VENTA ------");
                            comprobante.generarComprobante((Vendedor)vendedor, (ListaComprador)listaComprador, (ListaProductos)listaProd, indiceSelecComp-1, indiceSelecProd-1);
                            System.out.println("-------------------------------");
                            break;
                        case 4:
                            System.out.println("\n------ SELECCIONAR DELIVERY ------");
                            vendedor.selecDelivery((ListaProductos)listaProd, indiceSelecProd-1);
                            break;
                        case 5:
                            System.out.println("\n------- LISTA DE PRODUCTOS PUBLICADOS -------");
                            listaProd.mostrarListaProd();
                            System.out.println(" ---------------------------------");
                        case 6:
                            System.out.println("Saliendo de la interfaz de venta, gracias.");
                            break;
                    }
                } while (opcion!=6);
            } else if(comprador.iniciarSesion(ingresar).equalsIgnoreCase("Comprador"))
            {
                System.out.println("Por favor, registre su metodo de pago en caso de realizar alguna compra: ");
                metodoPago = sc.nextLine();
                comprador = new Comprador(metodoPago, nombre, dir);
                listaComprador.addComprador((Comprador)comprador);
                //Creamos el menú
                do {            
                    System.out.println("\nBienvenido a su interfaz de COMPRA "+nombre+", puedes escoger entre las siguientes opciones:");
                    System.out.println("1. Buscar un producto");
                    System.out.println("2. Realizar Pago");
                    System.out.println("3. Solicitar Soporte Tecnico");
                    System.out.println("4. Salida de la intefaz de COMPRA");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("\n------- LISTA DE PRODUCTOS PUBLICADOS -------");
                            listaProd.mostrarListaProd();
                            System.out.println("------ BUSCANDO PRODUCTO ------");
                            System.out.println("Ingrese el indice del producto a buscar: ");
                            indiceSelecProd = sc.nextInt();
                            sc.nextLine();
                            Producto prodObtenido = listaProd.obtenerProdBus(indiceSelecProd-1);
                            if(prodObtenido!=null)
                            {
                                System.out.println("------- Producto encontrado ------");
                                System.out.println("Nombre del producto: "+prodObtenido.getNombreProd());
                            } else
                            {
                                System.out.println("Indice de producto invalido!!");
                            }
                            break;
                        case 2:
                            System.out.println("\n----- REALIZANDO PAGO -----: ");
                            try 
                            {
                                metPago.realizarPago(metodoPago);
                                Producto prodPagar = listaProd.obtenerProdBus(indiceSelecProd-1);
                                System.out.println("Su producto seleccionado anteriormente es: "+prodPagar.getNombreProd());
                                comprador.realizarPago(prodPagar.getNombreProd(), (ListaProductos)listaProd, indiceSelecProd-1);
                            } catch (Exception e) {
                                System.out.println("Ha ocurrido un ERROR con el indice de su producto seleccionado!");
                            }
                            break;
                        case 3:
                            System.out.println("\n------ SOLICITANDO SERVICIO TECNICO ------");
                            comprador.solicitarServiTec();
                            System.out.println("-----------------------------------------");
                            break;
                        case 4:
                            System.out.println("Saliendo de la interfaz de venta, gracias.");
                            break;
                    }
                } while (opcion!=4);                
            } else
            {
                System.out.println("Tipo de ingreso NO VALIDO. Cerrando programa");
                flag = false;
            }
        } while (flag == true);

    }
    
}
