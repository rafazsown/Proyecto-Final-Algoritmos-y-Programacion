package Modelo;

public class Administrador extends Empleado {
    private String carreraAsignada;

    public Administrador(String nombre, String curp, String correo, String telefono, String noPersonal, String fechaIngreso, String carreraAsignada) {
        super(nombre, curp, correo, telefono, noPersonal, fechaIngreso);
        this.carreraAsignada = carreraAsignada;
    }

    public String getCarreraAsignada() {
        return carreraAsignada;
    }

    public void setCarreraAsignada(String carreraAsignada) {
        this.carreraAsignada = carreraAsignada;
    }
}