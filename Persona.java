package Modelo;
import java.io.Serializable;

public abstract class Persona implements Serializable {
    protected String nombre;
    protected String curp;
    protected String correo;
    protected String telefono;

    public Persona(String nombre, String curp, String correo, String telefono) {
        this.nombre = nombre;
        this.curp = curp;
        this.correo = correo;
        this.telefono = telefono;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}