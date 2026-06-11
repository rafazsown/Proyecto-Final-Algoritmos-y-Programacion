package Modelo;


public abstract class Empleado extends Persona {
    protected String noPersonal;
    protected String fechaIngreso;

    public Empleado(String nombre, String curp, String correo, String telefono, String noPersonal, String fechaIngreso) {
        super(nombre, curp, correo, telefono);
        this.noPersonal = noPersonal;
        this.fechaIngreso = fechaIngreso;
    }

    public void setNoPersonal(String noPersonal) {
        this.noPersonal = noPersonal;
    }

    public String getNoPersonal() {
        return noPersonal; }

    public String getFechaIngreso() {
        return fechaIngreso; }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}