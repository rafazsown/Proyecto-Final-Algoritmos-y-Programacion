package Modelo;

import java.util.Objects;
import java.io.Serializable;

public class Materia implements Serializable {
    private String idMateria;
    private String nombre;
    private int creditos;

    public Materia(String idMateria, String nombre, int creditos) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(idMateria, materia.idMateria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMateria);
    }
}