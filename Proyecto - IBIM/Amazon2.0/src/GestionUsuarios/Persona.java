package GestionUsuarios;

public abstract class Persona 
{
    public String nombre;
    public String direcc;

    //Constructores
    public Persona() {
    }

    public Persona(String nombre, String direcc) {
        this.nombre = nombre;
        this.direcc = direcc;
    }
    
    //Métodos
    public abstract String iniciarSesion(String ingreso);
    
    //Generamos los Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }
    
    //Agregamos el toString
    @Override
    public String toString() {
        return "Nombre=" + nombre
                +"\nDireccion=" + direcc;
    }
    
}
