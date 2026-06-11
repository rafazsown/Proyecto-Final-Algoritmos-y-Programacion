package Modelo;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Promediable;

public class Grupo implements Promediable {
    private String nombreGrupo;
    private List<Estudiante> estudiantes;

    public Grupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
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

    public String getNombreGrupo() { return nombreGrupo; }
}