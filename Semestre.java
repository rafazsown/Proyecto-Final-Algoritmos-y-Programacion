package Modelo;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Promediable;

public class Semestre implements Promediable {
    private int numeroSemestre;
    private List<Estudiante> estudiantes;

    public Semestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        if (e.getSemestre() == numeroSemestre) {
            estudiantes.add(e);
        }
    }

    @Override
    public double calcularPromedio() {
        double suma = 0;
        int contador = 0;
        for (Estudiante e : estudiantes) {
            suma += e.calcularPromedio();
            contador++;
        }
        return (contador > 0) ? suma / contador : 0;
    }

    public int getNumeroSemestre() { return numeroSemestre; }
    
}