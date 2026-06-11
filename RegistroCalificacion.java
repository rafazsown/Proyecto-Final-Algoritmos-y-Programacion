package Modelo;

import java.io.Serializable;

public class RegistroCalificacion implements Serializable {
    private Estudiante estudiante;
    private Materia materia;
    private double nota;

    public RegistroCalificacion(Estudiante estudiante, Materia materia, double nota) {
        this.estudiante = estudiante;
        this.materia = materia;
        this.nota = nota;
    }

    // Getters y Setters
    public Estudiante getEstudiante() {return estudiante;}

    public void setEstudiante(Estudiante estudiante) {this.estudiante = estudiante;}

    public Materia getMateria() {return materia;}

    public void setMateria(Materia materia) {this.materia = materia;}

    public double getNota() {return nota;}

    public void setNota(double nota) {this.nota = nota;}
}