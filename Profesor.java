package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Empleado {
    private List<Materia> materiasAsignadas;

    public Profesor(String nombre, String curp, String correo, String telefono, String noPersonal, String fechaIngreso) {
        super(nombre, curp, correo, telefono, noPersonal, fechaIngreso);
        this.materiasAsignadas = new ArrayList<>();
    }

    public List<Materia> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void setMateriasAsignadas(List<Materia> materiasAsignadas) {
        this.materiasAsignadas = materiasAsignadas;
    }

    public void asignarMateria(Materia materia) {
        materiasAsignadas.add(materia);
    }

    public void asignarCalificacion(Estudiante estudiante, Materia materia, double nota) {
        if (materiasAsignadas.contains(materia)) {
            estudiante.actualizarCalificacion(materia, nota);
            System.out.println("Profesor " + getNombre() + " asignó " + nota +
                               " en " + materia.getNombre() +
                               " al estudiante " + estudiante.getNombre());
        } else {
            System.out.println("El profesor no imparte la materia " + materia.getNombre());
        }
    }
}